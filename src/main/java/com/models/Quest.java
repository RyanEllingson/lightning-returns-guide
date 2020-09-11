package com.models;

public class Quest {
	private int questId;
	private Region region;
	private String name;
	private String prerequisites;
	private String availability;
	private String notes;
	
	public Quest() {
		super();
	}

	public Quest(int questId, Region region, String name, String prerequisites, String availability, String notes) {
		super();
		this.questId = questId;
		this.region = region;
		this.name = name;
		this.prerequisites = prerequisites;
		this.availability = availability;
		this.notes = notes;
	}

	public int getQuestId() {
		return questId;
	}

	public void setQuestId(int questId) {
		this.questId = questId;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Quest [questId=" + questId + ", region=" + region + ", name=" + name + ", prerequisites="
				+ prerequisites + ", availability=" + availability + ", notes=" + notes + "]";
	}
	
	
}
