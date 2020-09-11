package com.controllers;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAOImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Region;
import com.util.ConnectionFactory;

public class Regions {

	public static void getAllRegions(HttpServletRequest req, HttpServletResponse res) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			DAOImpl dao = new DAOImpl(conn);
			ObjectMapper om = new ObjectMapper();
			List<Region> regions = dao.getAllRegions();
			res.setStatus(200);
			res.getWriter().write(om.writeValueAsString(regions));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
