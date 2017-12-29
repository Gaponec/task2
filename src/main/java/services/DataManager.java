package services;

import objects.User;

import java.util.HashMap;
import java.util.Map;

public class DataManager {

    private Map<String,User> users;
    private static DataManager dataManager;

    public static DataManager instance(){
        if(dataManager==null){
            dataManager = new DataManager();
        }
        return dataManager;
    }

    private DataManager(){
        users = new HashMap<>();
    }

    public void addUser(User user){
        users.put(user.getUsername(),user);
    }

    public boolean makeAuthentication(String login,String password){
        if(users.isEmpty()) return false;

        User user = users.get(login);
        if(user == null) return false;

        if(user.getPassword().equals(password)){
            return true;
        } else {
            return false;
        }
    }

    public void registerUser(User user){
        if(users.containsKey(user.getUsername())){
        } else {
            addUser(user);
        }
    }
}
