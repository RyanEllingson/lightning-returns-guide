package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controllers.Quests;
import com.controllers.Regions;

public class GetRequestHelper {

	public static void process(HttpServletRequest req, HttpServletResponse res) {
		String uri = req.getRequestURI();
		if (uri.matches("/lightning-returns-guide/api/regions")) {
			Regions.getAllRegions(req, res);
		} else if (uri.matches("/lightning-returns-guide/api/quests")) {
			Quests.getAllQuests(req, res);
		} else if (uri.matches("/lightning-returns-guide/api/quests/region/(.*)")) {
			Quests.getQuestsByRegion(req, res);
		} else if (uri.matches("/lightning-returns-guide/api/quests/name/(.*)")) {
			Quests.getQuestsByName(req, res);
		}
	}
}
