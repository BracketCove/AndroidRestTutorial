package com.wiseassblog.androidresttutorial;

import com.wiseassblog.androidresttutorial.data.GitHubRestAdapter;
import com.wiseassblog.androidresttutorial.data.GithubRepository;
import com.wiseassblog.androidresttutorial.data.UrlManager;
import com.wiseassblog.androidresttutorial.error.ErrorInterceptor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import io.reactivex.subscribers.TestSubscriber;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by R_KAY on 11/17/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class GitHubRestAdapterTest {

    //MWS is what we'll use to test the REST Adapter
    private MockWebServer server;
    private GitHubRestAdapter adapter;


    /**
     * Using MWS, we can test our entire REST stack. Pretty cool, eh?
     * @throws IOException
     */
    @Before
    public void setUp() throws IOException {
        server = new MockWebServer();
        server.start();

        OkHttpClient client =
                new OkHttpClient.Builder()
                        .addInterceptor(
                                new ErrorInterceptor()
                        ).build();

        adapter = new GitHubRestAdapter(
                new Retrofit.Builder()
                        .client(client)
                        .baseUrl(
                                server.url("/").toString()
                        )
                        .addConverterFactory(MoshiConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
        );

    }

    /**
     * Server responds with:
     * Status: 200 OK (200 status code indicates successful request/response from server)
     *
     */
    @Test
    public void onGetRepositoriesSuccessful(){
        server.enqueue(new MockResponse()
        .setResponseCode(200)
        .setBody(TestData.SAMPLE_JSON_DATA));

        //So... BaseTestConsumer returns a List<T> of the consumed value type
        //which happens to be a list<GithubRepository>. This seems suboptimal.
        List<GithubRepository> result = adapter.getUserRepositories("BracketCove")
                .test()
                .values()
                .get(0);

        assert (result.size() == 2);
    }

//
//    @Test
//    public void onGetRepositoriesNetworkError(){
//        server.enqueue(
//                new MockResponse().
//        );
//
//        //So... BaseTestConsumer returns a List<T> of the consumed value type
//        //which happens to be a list<GithubRepository>. This seems suboptimal.
//        List<GithubRepository> result = adapter.getUserRepositories("BracketCoveTest")
//                .test()
//                .values()
//                .get(0);
//
//        assert (result.size() == 2);
//    }

    @Test
    public void onGetRepositoriesInvalidUsername(){
        server.enqueue(new MockResponse()
                .setResponseCode(404)
                .setBody(TestData.ERROR_NOT_FOUND));

        //So... BaseTestConsumer returns a List<T> of the consumed value type
        //which happens to be a list<GithubRepository>. This seems suboptimal.
        List<Throwable> result = adapter.getUserRepositories("BracketCoveTest")
                .test()
                .errors();

        assert (result.get(0).getMessage().equals("Not Foun"));


    }

    @After
    public void tearDown() throws IOException {
        server.shutdown();
    }
}
