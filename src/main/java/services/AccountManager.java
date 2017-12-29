package services;

import objects.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccountManager {
    private Map<String,User> onlineUsers;

    public AccountManager(){
        onlineUsers = new HashMap<>();
    }

    public void connectUser(User user){
        onlineUsers.put(user.getUsername(),user);
    }

    public User getUser(String login){
        if(onlineUsers == null) return null;
        if(onlineUsers.isEmpty()) return null;
        if(onlineUsers.containsKey(login)) return onlineUsers.get(login);
        else return null;
    }

    public void disconectUser(String login){
        onlineUsers.remove(login);
    }

    public void disconectUser(User user){
        onlineUsers.remove(user.getUsername());
    }

    public boolean isAuth(String user){
        return getUser(user).equals(null) ? false : true;
    }

    public boolean isAuth(User user){
        return getUser(user.getUsername()).equals(null) ? false : true;
    }
}
