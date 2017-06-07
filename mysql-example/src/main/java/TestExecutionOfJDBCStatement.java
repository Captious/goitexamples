import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class TestExecutionOfJDBCStatement {

    private static final String DB_URL = "jdbc:mysql://localhost/TEST_SCHEMA";
    private static final String USER = "root";
    private static final String PASS = "password";
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement("INSERT  INTO  test_table (id, test_data) VALUES (?, ?)")) {
            statement.setInt(1, RANDOM.nextInt());
            statement.setString(2, "Some string");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
