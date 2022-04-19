package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("deptDTO")
public class DeptDTO {

	
	String gcode;
	
	
	public DeptDTO() {
	}


	public DeptDTO(String gcode) {
		super();
		this.gcode = gcode;
	}


	public String getGcode() {
		return gcode;
	}


	public void setGcode(String gcode) {
		this.gcode = gcode;
	}


	@Override
	public String toString() {
		return "DeptDTO [gcode=" + gcode + "]";
	}
	
}
	