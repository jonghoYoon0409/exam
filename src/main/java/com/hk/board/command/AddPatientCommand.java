package com.hk.board.command;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.NotBlank;

public class AddPatientCommand {
	
	@NotBlank(message = "환자 고유아이디를 입력하세요")
	private String patient_id;
	
	@NotBlank(message = "환자의 이름을 입력하세요")
	private String patient_name;
	
	@NotBlank(message = "병명을 입력하세요")
	private String diagnosis;
	
	@NotNull
	private String admission_date;
	
	@NotBlank(message = "보호자 성명을 입력하세요")
	private String guardian_name;
	
	@NotBlank(message = "특이사항을 입력하세요")
	private String special_notes;
	
	private int memberid;

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public AddPatientCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public AddPatientCommand(@NotBlank(message = "환자 고유아이디를 입력하세요") String patient_id,
			@NotBlank(message = "환자의 이름을 입력하세요") String patient_name, @NotBlank(message = "병명을 입력하세요") String diagnosis,
			String admission_date, @NotBlank(message = "보호자 성명을 입력하세요") String guardian_name,
			@NotBlank(message = "특이사항을 입력하세요") String special_notes, int memberid) {
		super();
		this.patient_id = patient_id;
		this.patient_name = patient_name;
		this.diagnosis = diagnosis;
		this.admission_date = admission_date;
		this.guardian_name = guardian_name;
		this.special_notes = special_notes;
		this.memberid = memberid;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getAdmission_date() {
		return admission_date;
	}

	public void setAdmission_date(String admission_date) {
		this.admission_date = admission_date;
	}

	public String getGuardian_name() {
		return guardian_name;
	}

	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}

	public String getSpecial_notes() {
		return special_notes;
	}

	public void setSpecial_notes(String special_notes) {
		this.special_notes = special_notes;
	}

	@Override
	public String toString() {
		return "AddPatientCommand [memberid="+ memberid +"patient_id=" + patient_id + ", patient_name=" + patient_name + ", diagnosis="
				+ diagnosis + ", admission_date=" + admission_date + ", guardian_name=" + guardian_name
				+ ", special_notes=" + special_notes + "]";
	}

	
	
	
}









