import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.swing.*;
import java.sql.*;

public class Main {


        private static final String URL="jdbc:mysql://localhost:3306/mydbtest?useSSL=false";
        private static final String PASSWORD="root";
        private static final String USERNAME="root";

        public static void main(String[] args) throws SQLException {
            DBProcessor db=new DBProcessor();
            Connection connection = db.getConnection(URL,USERNAME,PASSWORD);
            String query="Select * from mydbtest.users";
            Statement statement=connection.createStatement();
            ResultSet resSet = statement.executeQuery(query);
            while (resSet.next()){
                int id;
                String name;
                int age;
                String email;
                id=resSet.getInt("users.id");
                name=resSet.getString("users.name");
                age=resSet.getInt("users.age");
                email=resSet.getString("users.email");
                Users user=new Users(id,name,age,email);
                System.out.println(user);
            }
            statement.close();
            connection.close();
        }
    }


