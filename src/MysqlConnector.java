import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnector {

    private String database;
    private String user;
    private String password;
    private Connection connection;

    public MysqlConnector() {
        this.database ="jdbc:mysql://127.0.0.1/shoptop";
        this.user = "root";
        this.password = "desenvolvimento";
        this.connect();
    }

    public void connect(){
        try {
            this.connection = DriverManager.getConnection(
                    this.database, this.user, this.password
            );
        } catch (SQLException $e) {
            System.out.println("Um erro ocorreu ao conectar: " + $e);
        }
    }

    public Connection getConnection(){
        return this.connection;
    }

    public void disconnect() {
        try {
            this.connection.close();
        } catch (SQLException $e) {
            System.out.println("Um erro ocorreu ao desconectar: " + $e);
        }
    }

}
