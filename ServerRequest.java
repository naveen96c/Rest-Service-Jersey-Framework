import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.jws.WebService;
import javax.persistence.Entity;
import javax.jws.WebMethod;



import java.sql.*;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
@WebService()
@Entity
@Path("/user")
public class ServerRequest {

    @POST
    @Path("/fetch")
    @WebMethod(operationName = "insert")
    public static boolean insert()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;


        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pet_Records","root", "Krishna5746@");
            int ID=4;
            String Name = "HEODO";
            String Type ="DOG";
            String query = "insert into pets (ID, NAME, TYPE) values ("+ID +", '"+Name+"','"+Type+"')";
            System.out.println(query);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);

//            while (rs.next()) {
//                System.out.println(rs.getInt("count"));
//            }
//            while(rs.next()){
//                String resultname = rs.getString("NAME");
//                String resultpassword = rs.getString("TYPE");
//                System.out.println(resultname+" "+resultpassword);
//            }
//            assert rs != null;
//            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return true ;

    }
}
