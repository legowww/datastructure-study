package gitApi;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mainTest {

    public static void main(String[] args) throws IOException {
        GitHub myGithub = GitConnect.getInstance();
        GHRepository repository = myGithub.getRepository("whiteship/live-study");

        List<GHIssue> issues = repository.getIssues(GHIssueState.ALL);
        Map<String, Integer> userLogCount = new HashMap<>();
        for (GHIssue issue : issues) {
            String title = issue.getTitle();
            System.out.println("title = " + title);
//            List<GHIssueComment> comments = issue.getComments();
//            for (GHIssueComment comment : comments) {
//                String userId = comment.getUser().getLogin();
//                userLogCount.put(userId, userLogCount.getOrDefault(userId, 0) + 1);
//            }
        }
        for (String user : userLogCount.keySet()) {
            Integer cnt = userLogCount.get(user);
            System.out.println(user + ": " + cnt);
        }
    }
}
