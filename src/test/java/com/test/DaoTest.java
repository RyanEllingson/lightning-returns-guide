package com.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.DAOImpl;
import com.models.Region;

public class DaoTest {

	private static Connection conn;
	private static DAOImpl dao;
	
	@BeforeClass
	public static void setup() {
		String url = "jdbc:postgresql://localhost/postgres?currentSchema=lightning_returns";
		String username = "postgres";
		String password = "postgres";
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dao = new DAOImpl(conn);
	}
	
	@Test
	public void testGetAllRegions() {
		List<Region> regions = dao.getAllRegions();
		assertEquals(4, regions.size());
		assertEquals("Luxerion", regions.get(0).getRegion());
		assertEquals("Yusnaan", regions.get(1).getRegion());
		assertEquals("The Wildlands", regions.get(2).getRegion());
		assertEquals("The Dead Dunes", regions.get(3).getRegion());
	}
	
	@AfterClass
	public static void teardown() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
