package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.Quest;
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

	@Override
	public List<Quest> getAllQuests() {
		List<Quest> quests = new ArrayList<>();
		String sql = "SELECT quests.quest_id, quests.region_id, regions.region, quests.name, quests.prerequisites, quests.availability, quests.notes FROM quests INNER JOIN regions ON quests.region_id = regions.region_id";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				quests.add(new Quest(
						rs.getInt(1),
						new Region(rs.getInt(2), rs.getString(3)),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quests;
	}

	@Override
	public List<Quest> getQuestsByRegion(int regionId) {
		List<Quest> quests = new ArrayList<>();
		String sql = "SELECT quests.quest_id, quests.region_id, regions.region, quests.name, quests.prerequisites, quests.availability, quests.notes FROM quests INNER JOIN regions ON quests.region_id = regions.region_id WHERE quests.region_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, regionId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				quests.add(new Quest(
						rs.getInt(1),
						new Region(rs.getInt(2), rs.getString(3)),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quests;
	}

	@Override
	public List<Quest> getQuestsByName(String name) {
		List<Quest> quests = new ArrayList<>();
		String sql = "SELECT quests.quest_id, quests.region_id, regions.region, quests.name, quests.prerequisites, quests.availability, quests.notes FROM quests INNER JOIN regions ON quests.region_id = regions.region_id WHERE quests.name LIKE ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				quests.add(new Quest(
						rs.getInt(1),
						new Region(rs.getInt(2), rs.getString(3)),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quests;
	}

}
