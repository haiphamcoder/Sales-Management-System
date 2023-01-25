package Controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import Model.LoginModel;

public class LoginController {

    public static boolean checkData(LoginModel login) {
        try {
            Connection conn = ConnectionDatabase.getConnection();
            if (conn != null) {
                CallableStatement statement = conn.prepareCall("{ CALL sp_Login(?,?) }");
                statement.setString(1, login.getUserName());
                statement.setString(2, login.getPassword());
                ResultSet resultSet = statement.executeQuery();
                if (resultSet != null && resultSet.next()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDatabase.closeConnection();
        }
        return false;
    }
}
