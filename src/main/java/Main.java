import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.swing.*;
import java.sql.*;

public class Main {


        private static final String URL="jdbc:mysql://localhost:3306/mydbtest?useSSL=false";
        private static final String PASSWORD="root";
        private static final String USERNAME="root";

        public static void main(String[] args) throws SQLException {
            DBProcessor db=new DBProcessor();
            String query ="Select * from mydbtest.users";

            String insert = "insert into mydbtest.users (name, age, email) values (?, ?, ?)";

            Connection connection = db.getConnection(URL,USERNAME,PASSWORD);

            PreparedStatement preparedInsert = connection.prepareStatement(insert);
            preparedInsert.setString(1,"Kolya");
            preparedInsert.setInt(2,25);
            preparedInsert.setString(3,"lolya@gmail.ru");
            preparedInsert.execute();

            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resSet=preparedStatement.executeQuery();
            while(resSet.next()){
                System.out.println(resSet.getInt("id")+"    "+resSet.getString("name"));
            }
            preparedStatement.close();
            connection.close();
        }
    }


