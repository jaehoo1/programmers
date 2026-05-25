import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class User {

    String id, name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Users {

    Map<String, User> users;

    public Users() {
        this.users = new HashMap<>();
    }

    void addUserOrChangeName(String id, String name) {
        users.put(id, new User(id, name));
    }

    String getUserName(String id) {
        return users.get(id).name;
    }
}

class Solution {

    String[] solution(String[] record) {
        Users users = new Users();
        Arrays.stream(record)
                .filter(s -> s.contains("Enter") || s.contains("Change"))
                .forEach(s -> {
                    StringTokenizer st = new StringTokenizer(s);
                    st.nextToken();
                    users.addUserOrChangeName(st.nextToken(), st.nextToken());
                });
        return Arrays.stream(record)
                .filter(s -> s.contains("Enter") || s.contains("Leave"))
                .map(s -> {
                    StringTokenizer st = new StringTokenizer(s);
                    String cmd = st.nextToken();
                    String id = st.nextToken();
                    return users.getUserName(id) + (cmd.equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.");
                })
                .toArray(String[]::new);
    }
}