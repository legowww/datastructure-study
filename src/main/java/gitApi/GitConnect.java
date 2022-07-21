package gitApi;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;

public class GitConnect {
    /*
        get token ->
        https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token
    */
    private final static String MY_OAUTH = "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";
    private static GitHub myGitHub;

    private GitConnect() {

    }

    static GitHub getInstance() throws IOException {
        if (myGitHub == null) {
            connectGithub();
        }
        return myGitHub;
    }

    private static void connectGithub() throws IOException {
        myGitHub = new GitHubBuilder().withOAuthToken(MY_OAUTH).build();
    }
}
