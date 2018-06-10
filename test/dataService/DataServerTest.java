package dataService;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;


public class DataServerTest {
    static DataServer dataServer;

    @BeforeClass
    public static void setupEnviroment(){
        dataServer = DataServer.getInstance();
    }

    @Before
    public void resetEnvironment(){
        dataServer.resetEnvironment();
    }

    @Test
    public void dataServerShouldBeInstanceOfDataServer(){
        assertThat(dataServer, instanceOf(DataServer.class));
    }
    @Test
    public void dataReturnedFromServerShouldBeInstanceOfArrayList(){
        assertThat(dataServer.getAllUsersFromLocalDatabase(), instanceOf(ArrayList.class));
        assertThat(dataServer.getAllUsersFromGlobalDatabase(), instanceOf(ArrayList.class));
    }

    @Test
    public void shouldBeAbleToAddUserToLocalDataBase(){
        //Give I have user who is not included in current database
        String newUserName = "Nowak";
        assertThat(dataServer.getAllUsersFromLocalDatabase(), is(not(hasItem(newUserName))));
        //When I add user to local
        dataServer.addLocalUser(newUserName);
        //Then user should be there
        assertThat(dataServer.getAllUsersFromLocalDatabase(),hasItem(newUserName));
    }

    @Test
    public void afterMigrationAllRecordsShouldBeInGlobal(){
        ArrayList<String> localRecords = dataServer.getAllUsersFromLocalDatabase();
        dataServer.migrateLocalDbToGlobal();
        assertThat(dataServer.getAllUsersFromGlobalDatabase(), hasItems(localRecords.toArray(new String[1])));
    }
    @Test
    public void afterMigrationAllRecordsInGlobalShouldEqualLocal(){
        ArrayList<String> localRecords = dataServer.getAllUsersFromLocalDatabase();
        dataServer.migrateLocalDbToGlobal();
        assertThat(dataServer.getAllUsersFromGlobalDatabase(), equalTo(localRecords));
    }

}
