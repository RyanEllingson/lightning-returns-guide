package com.models;

public class Region {
	private int regionId;
	private String region;
	
	public Region() {
		super();
	}

	public Region(int regionId, String region) {
		super();
		this.regionId = regionId;
		this.region = region;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", region=" + region + "]";
	}
	
	
}
