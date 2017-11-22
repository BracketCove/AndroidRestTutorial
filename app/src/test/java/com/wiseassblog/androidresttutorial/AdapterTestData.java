package com.wiseassblog.androidresttutorial;

import com.wiseassblog.androidresttutorial.viewmodel.ListViewModel;

/**
 * Created by R_KAY on 11/17/2017.
 */

public class AdapterTestData {
    public static final String SAMPLE_JSON_DATA = "[\n" +
            "  {\n" +
            "    \"id\": 84743813,\n" +
            "    \"name\": \"android-architecture\",\n" +
            "    \"full_name\": \"BracketCove/android-architecture\",\n" +
            "    \"owner\": {\n" +
            "      \"login\": \"BracketCove\",\n" +
            "      \"id\": 12968428,\n" +
            "      \"avatar_url\": \"https://avatars2.githubusercontent.com/u/12968428?v=4\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/BracketCove\",\n" +
            "      \"html_url\": \"https://github.com/BracketCove\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/BracketCove/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/BracketCove/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/BracketCove/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/BracketCove/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/BracketCove/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/BracketCove/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/BracketCove/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/BracketCove/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/BracketCove/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false\n" +
            "    },\n" +
            "    \"private\": false,\n" +
            "    \"html_url\": \"https://github.com/BracketCove/android-architecture\",\n" +
            "    \"description\": \"A collection of samples to discuss and showcase different architectural tools and patterns for Android apps.\",\n" +
            "    \"fork\": true,\n" +
            "    \"url\": \"https://api.github.com/repos/BracketCove/android-architecture\",\n" +
            "    \"forks_url\": \"https://api.github.com/repos/BracketCove/android-architecture/forks\",\n" +
            "    \"keys_url\": \"https://api.github.com/repos/BracketCove/android-architecture/keys{/key_id}\",\n" +
            "    \"collaborators_url\": \"https://api.github.com/repos/BracketCove/android-architecture/collaborators{/collaborator}\",\n" +
            "    \"teams_url\": \"https://api.github.com/repos/BracketCove/android-architecture/teams\",\n" +
            "    \"hooks_url\": \"https://api.github.com/repos/BracketCove/android-architecture/hooks\",\n" +
            "    \"issue_events_url\": \"https://api.github.com/repos/BracketCove/android-architecture/issues/events{/number}\",\n" +
            "    \"events_url\": \"https://api.github.com/repos/BracketCove/android-architecture/events\",\n" +
            "    \"assignees_url\": \"https://api.github.com/repos/BracketCove/android-architecture/assignees{/user}\",\n" +
            "    \"branches_url\": \"https://api.github.com/repos/BracketCove/android-architecture/branches{/branch}\",\n" +
            "    \"tags_url\": \"https://api.github.com/repos/BracketCove/android-architecture/tags\",\n" +
            "    \"blobs_url\": \"https://api.github.com/repos/BracketCove/android-architecture/git/blobs{/sha}\",\n" +
            "    \"git_tags_url\": \"https://api.github.com/repos/BracketCove/android-architecture/git/tags{/sha}\",\n" +
            "    \"git_refs_url\": \"https://api.github.com/repos/BracketCove/android-architecture/git/refs{/sha}\",\n" +
            "    \"trees_url\": \"https://api.github.com/repos/BracketCove/android-architecture/git/trees{/sha}\",\n" +
            "    \"statuses_url\": \"https://api.github.com/repos/BracketCove/android-architecture/statuses/{sha}\",\n" +
            "    \"languages_url\": \"https://api.github.com/repos/BracketCove/android-architecture/languages\",\n" +
            "    \"stargazers_url\": \"https://api.github.com/repos/BracketCove/android-architecture/stargazers\",\n" +
            "    \"contributors_url\": \"https://api.github.com/repos/BracketCove/android-architecture/contributors\",\n" +
            "    \"subscribers_url\": \"https://api.github.com/repos/BracketCove/android-architecture/subscribers\",\n" +
            "    \"subscription_url\": \"https://api.github.com/repos/BracketCove/android-architecture/subscription\",\n" +
            "    \"commits_url\": \"https://api.github.com/repos/BracketCove/android-architecture/commits{/sha}\",\n" +
            "    \"git_commits_url\": \"https://api.github.com/repos/BracketCove/android-architecture/git/commits{/sha}\",\n" +
            "    \"comments_url\": \"https://api.github.com/repos/BracketCove/android-architecture/comments{/number}\",\n" +
            "    \"issue_comment_url\": \"https://api.github.com/repos/BracketCove/android-architecture/issues/comments{/number}\",\n" +
            "    \"contents_url\": \"https://api.github.com/repos/BracketCove/android-architecture/contents/{+path}\",\n" +
            "    \"compare_url\": \"https://api.github.com/repos/BracketCove/android-architecture/compare/{base}...{head}\",\n" +
            "    \"merges_url\": \"https://api.github.com/repos/BracketCove/android-architecture/merges\",\n" +
            "    \"archive_url\": \"https://api.github.com/repos/BracketCove/android-architecture/{archive_format}{/ref}\",\n" +
            "    \"downloads_url\": \"https://api.github.com/repos/BracketCove/android-architecture/downloads\",\n" +
            "    \"issues_url\": \"https://api.github.com/repos/BracketCove/android-architecture/issues{/number}\",\n" +
            "    \"pulls_url\": \"https://api.github.com/repos/BracketCove/android-architecture/pulls{/number}\",\n" +
            "    \"milestones_url\": \"https://api.github.com/repos/BracketCove/android-architecture/milestones{/number}\",\n" +
            "    \"notifications_url\": \"https://api.github.com/repos/BracketCove/android-architecture/notifications{?since,all,participating}\",\n" +
            "    \"labels_url\": \"https://api.github.com/repos/BracketCove/android-architecture/labels{/name}\",\n" +
            "    \"releases_url\": \"https://api.github.com/repos/BracketCove/android-architecture/releases{/id}\",\n" +
            "    \"deployments_url\": \"https://api.github.com/repos/BracketCove/android-architecture/deployments\",\n" +
            "    \"created_at\": \"2017-03-12T17:28:02Z\",\n" +
            "    \"updated_at\": \"2017-07-26T08:21:01Z\",\n" +
            "    \"pushed_at\": \"2017-03-12T13:59:52Z\",\n" +
            "    \"git_url\": \"git://github.com/BracketCove/android-architecture.git\",\n" +
            "    \"ssh_url\": \"git@github.com:BracketCove/android-architecture.git\",\n" +
            "    \"clone_url\": \"https://github.com/BracketCove/android-architecture.git\",\n" +
            "    \"svn_url\": \"https://github.com/BracketCove/android-architecture\",\n" +
            "    \"homepage\": \"\",\n" +
            "    \"size\": 7469,\n" +
            "    \"stargazers_count\": 1,\n" +
            "    \"watchers_count\": 1,\n" +
            "    \"language\": null,\n" +
            "    \"has_issues\": false,\n" +
            "    \"has_projects\": true,\n" +
            "    \"has_downloads\": true,\n" +
            "    \"has_wiki\": true,\n" +
            "    \"has_pages\": false,\n" +
            "    \"forks_count\": 3,\n" +
            "    \"mirror_url\": null,\n" +
            "    \"archived\": false,\n" +
            "    \"open_issues_count\": 0,\n" +
            "    \"forks\": 3,\n" +
            "    \"open_issues\": 0,\n" +
            "    \"watchers\": 1,\n" +
            "    \"default_branch\": \"master\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 110599775,\n" +
            "    \"name\": \"AndroidRestTutorial\",\n" +
            "    \"full_name\": \"BracketCove/AndroidRestTutorial\",\n" +
            "    \"owner\": {\n" +
            "      \"login\": \"BracketCove\",\n" +
            "      \"id\": 12968428,\n" +
            "      \"avatar_url\": \"https://avatars2.githubusercontent.com/u/12968428?v=4\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/BracketCove\",\n" +
            "      \"html_url\": \"https://github.com/BracketCove\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/BracketCove/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/BracketCove/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/BracketCove/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/BracketCove/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/BracketCove/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/BracketCove/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/BracketCove/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/BracketCove/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/BracketCove/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false\n" +
            "    },\n" +
            "    \"private\": false,\n" +
            "    \"html_url\": \"https://github.com/BracketCove/AndroidRestTutorial\",\n" +
            "    \"description\": \"Tutorial/Demo Project aimed at demonstrating the fundamentals of communcitating via RESTful Web Services.\",\n" +
            "    \"fork\": false,\n" +
            "    \"url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial\",\n" +
            "    \"forks_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/forks\",\n" +
            "    \"keys_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/keys{/key_id}\",\n" +
            "    \"collaborators_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/collaborators{/collaborator}\",\n" +
            "    \"teams_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/teams\",\n" +
            "    \"hooks_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/hooks\",\n" +
            "    \"issue_events_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/issues/events{/number}\",\n" +
            "    \"events_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/events\",\n" +
            "    \"assignees_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/assignees{/user}\",\n" +
            "    \"branches_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/branches{/branch}\",\n" +
            "    \"tags_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/tags\",\n" +
            "    \"blobs_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/git/blobs{/sha}\",\n" +
            "    \"git_tags_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/git/tags{/sha}\",\n" +
            "    \"git_refs_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/git/refs{/sha}\",\n" +
            "    \"trees_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/git/trees{/sha}\",\n" +
            "    \"statuses_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/statuses/{sha}\",\n" +
            "    \"languages_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/languages\",\n" +
            "    \"stargazers_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/stargazers\",\n" +
            "    \"contributors_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/contributors\",\n" +
            "    \"subscribers_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/subscribers\",\n" +
            "    \"subscription_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/subscription\",\n" +
            "    \"commits_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/commits{/sha}\",\n" +
            "    \"git_commits_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/git/commits{/sha}\",\n" +
            "    \"comments_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/comments{/number}\",\n" +
            "    \"issue_comment_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/issues/comments{/number}\",\n" +
            "    \"contents_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/contents/{+path}\",\n" +
            "    \"compare_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/compare/{base}...{head}\",\n" +
            "    \"merges_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/merges\",\n" +
            "    \"archive_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/{archive_format}{/ref}\",\n" +
            "    \"downloads_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/downloads\",\n" +
            "    \"issues_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/issues{/number}\",\n" +
            "    \"pulls_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/pulls{/number}\",\n" +
            "    \"milestones_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/milestones{/number}\",\n" +
            "    \"notifications_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/notifications{?since,all,participating}\",\n" +
            "    \"labels_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/labels{/name}\",\n" +
            "    \"releases_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/releases{/id}\",\n" +
            "    \"deployments_url\": \"https://api.github.com/repos/BracketCove/AndroidRestTutorial/deployments\",\n" +
            "    \"created_at\": \"2017-11-13T20:43:22Z\",\n" +
            "    \"updated_at\": \"2017-11-13T20:44:42Z\",\n" +
            "    \"pushed_at\": \"2017-11-16T20:04:45Z\",\n" +
            "    \"git_url\": \"git://github.com/BracketCove/AndroidRestTutorial.git\",\n" +
            "    \"ssh_url\": \"git@github.com:BracketCove/AndroidRestTutorial.git\",\n" +
            "    \"clone_url\": \"https://github.com/BracketCove/AndroidRestTutorial.git\",\n" +
            "    \"svn_url\": \"https://github.com/BracketCove/AndroidRestTutorial\",\n" +
            "    \"homepage\": null,\n" +
            "    \"size\": 118,\n" +
            "    \"stargazers_count\": 0,\n" +
            "    \"watchers_count\": 0,\n" +
            "    \"language\": \"Java\",\n" +
            "    \"has_issues\": true,\n" +
            "    \"has_projects\": true,\n" +
            "    \"has_downloads\": true,\n" +
            "    \"has_wiki\": true,\n" +
            "    \"has_pages\": false,\n" +
            "    \"forks_count\": 0,\n" +
            "    \"mirror_url\": null,\n" +
            "    \"archived\": false,\n" +
            "    \"open_issues_count\": 0,\n" +
            "    \"forks\": 0,\n" +
            "    \"open_issues\": 0,\n" +
            "    \"watchers\": 0,\n" +
            "    \"default_branch\": \"master\"\n" +
            "  }" +
            "]";

    public static final String ERROR_NOT_FOUND = "{\n"+
            "  \"message\": \"Not Found\",\n"+
            "  \"documentation_url\": \"https://developer.github.com/v3/repos/#list-user-repositories\"\n"+
            "}";


}
