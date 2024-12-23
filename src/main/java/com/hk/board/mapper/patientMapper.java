package com.hk.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hk.board.dtos.MemberDto;
import com.hk.board.dtos.PatientDto;

@Mapper
public interface patientMapper {
	
	public boolean addPatient(PatientDto dto);
	
	public String idChk(String id);
	
	public MemberDto loginUser(String id);
	
	public List<PatientDto> patientlist(Map<String, String> params);
	
}







