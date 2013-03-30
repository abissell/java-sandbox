import java.sql.*;

class UpdateCar {
	public static void UpdateCarNum(int carNum, int empNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection("jdbc:default:connection");

			pstmt = con.prepareStatement("UPDATE EMPLOYEES " + "SET CAR_NUMBER = ?" + "WHERE EMPLOYEE_NUMBER = ?");
			pstmt.setInt(1, carNum);
			pstmt.setInt(2, empNum);
			pstmt.executeUpdate();
		}
		finally {
			if (pstmt != null) pstmt.close();
		}
	}
}
