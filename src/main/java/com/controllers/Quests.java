package com.controllers;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAOImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Quest;
import com.util.ConnectionFactory;

public class Quests {

	public static void getAllQuests(HttpServletRequest req, HttpServletResponse res) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			DAOImpl dao = new DAOImpl(conn);
			ObjectMapper om = new ObjectMapper();
			List<Quest> quests = dao.getAllQuests();
			res.setStatus(200);
			res.getWriter().write(om.writeValueAsString(quests));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getQuestsByRegion(HttpServletRequest req, HttpServletResponse res) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			DAOImpl dao = new DAOImpl(conn);
			ObjectMapper om = new ObjectMapper();
			String[] url = req.getRequestURI().split("/");
			int regionId = Integer.parseInt(url[5]);
			List<Quest> quests = dao.getQuestsByRegion(regionId);
			res.setStatus(200);
			res.getWriter().write(om.writeValueAsString(quests));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getQuestsByName(HttpServletRequest req, HttpServletResponse res) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			DAOImpl dao = new DAOImpl(conn);
			ObjectMapper om = new ObjectMapper();
			String[] url = req.getRequestURI().split("/");
			String name = url[5];
			List<Quest> quests = dao.getQuestsByName(name);
			res.setStatus(200);
			res.getWriter().write(om.writeValueAsString(quests));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
