import java.sql.*;
import redis.clients.jedis.Jedis;

public class Worker {
    public static void main(String[] args) throws Exception {
        Jedis redis = new Jedis("redis");
        Connection db = DriverManager.getConnection("jdbc:postgresql://db:5432/votes", "postgres", "postgres");

        while (true) {
            String vote = redis.lpop("votes");
            if (vote != null) {
                PreparedStatement stmt = db.prepareStatement("INSERT INTO votes (vote) VALUES (?)");
                stmt.setString(1, vote);
                stmt.executeUpdate();
                System.out.println("Inserted: " + vote);
            }
            Thread.sleep(1000);
        }
    }
}
