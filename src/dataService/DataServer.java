package dataService;

import java.util.ArrayList;
import java.util.Arrays;

public class DataServer {
    //let's imagine that is some sort of database interface which could return different data
    //Interface provide connection to two distributed database
    //This class should handle CRUD operations for both databases: global and local.
    //Please ensure that you reset state of this class after each test
    private static DataServer dataServer = null;
    private static ArrayList<String> usersInLocalDataBase;
    private static ArrayList<String> usersInGlobalDataBase;

    public static DataServer getInstance(){
        if (dataServer==null) {
            dataServer = new DataServer();
            dataServer.resetStateOfDatabases();
        }
        return dataServer;
    }

    public ArrayList<String> getAllUsersFromLocalDatabase(){
        return new ArrayList<>(dataServer.usersInLocalDataBase);
    }

    public ArrayList<String> getAllUsersFromGlobalDatabase(){
        return new ArrayList<>(dataServer.usersInGlobalDataBase);
    }

    public void addLocalUser(String userName){
        dataServer.usersInLocalDataBase.add(userName);
    }

    public void migrateLocalDbToGlobal(){
        dataServer.usersInGlobalDataBase.addAll(dataServer.getAllUsersFromLocalDatabase());
        dataServer.usersInGlobalDataBase.addAll(Arrays.asList("Rachel","Monica","Phoebe","Chandler","Joey","Ross"));
    }

    public static void resetEnvironment(){
        dataServer.resetStateOfDatabases();
    }

    private static void resetStateOfDatabases(){
        dataServer.usersInLocalDataBase = new ArrayList<>(Arrays.asList("John", "Al", "Kris", "Jack", "Margaret"));
        dataServer.usersInGlobalDataBase = new ArrayList<>();
    }
}
