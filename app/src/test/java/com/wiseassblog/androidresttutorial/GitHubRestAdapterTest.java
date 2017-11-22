package com.wiseassblog.androidresttutorial;

import com.wiseassblog.androidresttutorial.data.GitHubRestAdapter;
import com.wiseassblog.androidresttutorial.datamodel.RepositoryDataModel;
import com.wiseassblog.androidresttutorial.error.ErrorInterceptor;
import com.wiseassblog.androidresttutorial.error.GitHubError;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Response;
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
        .setBody(AdapterTestData.SAMPLE_JSON_DATA));

        //So... BaseTestConsumer returns a List<T> of the consumed value type
        //which happens to be a list<RepositoryDataModel>. This seems suboptimal.
        Response<List<RepositoryDataModel>> result = adapter.getUserRepositories("BracketCove")
                .test()
                .values()
                .get(0);

        //SAMPLE_JSON_DATA returns a json array with 2 elements, hence assertion here
        Assert.assertEquals(result.body().size(),2);
    }


    @Test
    public void onGetRepositoriesInvalidUsername(){
        server.enqueue(new MockResponse()
                .setResponseCode(404)
                .setBody(AdapterTestData.ERROR_NOT_FOUND));

        //So... BaseTestConsumer returns a List<T> of the consumed value type
        //which happens to be a list<RepositoryDataModel>. This seems suboptimal.
        adapter.getUserRepositories("BracketCoveTest")
                .test()
                .assertError(GitHubError.class);
    }

    @After
    public void tearDown() throws IOException {
        server.shutdown();
    }
}
