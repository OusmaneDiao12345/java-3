package repositories;

import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<User> getActiveUsers() {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.isActive()) {
                result.add(user);
            }
        }
        return result;
    }

    public List<User> getUsersByRole(String role) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getRole().equals(role)) {
                result.add(user);
            }
        }
        return result;
    }

    public void deactivateUser(User user) {
        user.setActive(false);
    }

    public void activateUser(User user) {
        user.setActive(true);
    }
}
