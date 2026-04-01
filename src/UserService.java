import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class UserService {
    private List<RegisteredUsers> userList = new ArrayList<>();

    public void addUser(RegisteredUsers user) {
        userList.add(user);
    }
    public List<RegisteredUsers> getAllUsers() {
        return userList;
    }
    public void removeUser(String email) {
        Iterator<RegisteredUsers> it = userList.iterator();
        while (it.hasNext()) {
            RegisteredUsers u = it.next();
            if (u.getEmailAddress().equals(email)) {
                it.remove();
                break;
            }
        }
    }

    public RegisteredUsers findUser(String email) {
        for (RegisteredUsers u : userList) {
            if (u.getEmailAddress().equals(email)) {
                return u;
            }
        }
        return null;
    }
}