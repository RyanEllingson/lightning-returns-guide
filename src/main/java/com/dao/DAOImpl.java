package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.Region;

public class DAOImpl implements DAO {
	private Connection conn;
	
	public DAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Region> getAllRegions() {
		List<Region> regions = new ArrayList<>();
		String sql = "SELECT * FROM regions";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				regions.add(new Region(
					rs.getInt(1),
					rs.getString(2)
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return regions;
	}

}
