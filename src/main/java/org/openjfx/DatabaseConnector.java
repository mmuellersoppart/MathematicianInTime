package org.openjfx;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
/**
 * Database connector
 */
public class DatabaseConnector{

    private final static String DATABASE_URL = "jdbc:sqlite:src/main/resources/org/openjfx/buildingup.db";
    private Dao<User, Integer> userDao;
    
    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private ConnectionSource connect() throws Exception{
        // SQLite connection string
        
        ConnectionSource connectionSource = null;
        try {
            // conn = DriverManager.getConnection(url);
            // create our data-source for the database
			connectionSource = new JdbcConnectionSource(DATABASE_URL);
			// setup our database and DAOs
            setupDatabase(connectionSource);
            readWriteData();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connectionSource;
    }

    /**
	 * Setup our database and DAOs
	 */
	private void setupDatabase(ConnectionSource connectionSource) throws Exception {

		userDao = DaoManager.createDao(connectionSource, User.class);

		// if you need to create the table
		TableUtils.createTable(connectionSource, User.class);
    }
    
    private void readWriteData() throws Exception {
		// create an instance of Account
		String name = "Jim Coakley";
		User user = new User(name);

		// persist the account object to the database
		userDao.create(user);
        int id = user.getId();
        System.out.println(id);

        String myname = "Peter";
        User userPeter = new User(myname);
        userDao.create(userPeter);

		// query for all items in the database
        List<User> users = userDao.queryForAll();
        System.out.println(users); 

		// loop through items in the database
		int accountC = 0;
		for (User user2 : userDao) {
            System.out.println(user2);
            accountC++;
		}
        System.out.println(accountC);

		// construct a query using the QueryBuilder
		QueryBuilder<User, Integer> statementBuilder = userDao.queryBuilder();
		// shouldn't find anything: name LIKE 'hello" does not match our account
		statementBuilder.where().like(User.NAME_FIELD_NAME, "Peter");
        users = userDao.query(statementBuilder.prepare());
        System.out.println(users);
	}
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
 
        DatabaseConnector app = new DatabaseConnector();
        app.connect();
    }
 
}
