package models;

import main.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PCStoreDAO {

	public void registerItem(PCStore pcStore) {
		String sqlQuery = "INSERT INTO store (model, brand, color, price) values (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = DatabaseConfig.getConnection();
			pstm = conn.prepareStatement(sqlQuery);
			pstm.setString(0, pcStore.getModel());
			pstm.setString(1, pcStore.getBrand());
			pstm.setString(2, pcStore.getColor());
			pstm.setDouble(4, pcStore.getPrice());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
