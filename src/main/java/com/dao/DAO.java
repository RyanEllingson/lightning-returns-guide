package com.dao;

import java.util.List;

import com.models.Quest;
import com.models.Region;

public interface DAO {
	
	public List<Region> getAllRegions();

	public List<Quest> getAllQuests();
	
	public List<Quest> getQuestsByRegion(int regionId);
	
	public List<Quest> getQuestsByName(String name);
}
