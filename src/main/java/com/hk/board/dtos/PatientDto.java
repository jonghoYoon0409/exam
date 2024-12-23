package com.hk.board.dtos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PatientDto {

    private String patientId;        // PATIENT_ID
    private String patientName;      // PATIENT_NAME
    private String diagnosis;         // DIAGNOSIS
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date admissionDate;      // ADMISSION_DATE
    private String guardianName;     // GUARDIAN_NAME
    private String specialNotes;      // SPECIAL_NOTES
    private int memberid;
    
    
    public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public PatientDto() {
        super();
    }

    public PatientDto(String patientId, String patientName, String diagnosis, Date admissionDate, String guardianName,
            String specialNotes, int memberid ) {
        super();
        this.patientId = patientId;
        this.patientName = patientName;
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
        this.guardianName = guardianName;
        this.specialNotes = specialNotes;
        this.memberid=memberid;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

	@Override
	public String toString() {
		return "PatientDto [patientId=" + patientId + ", patientName=" + patientName + ", diagnosis=" + diagnosis
				+ ", admissionDate=" + admissionDate + ", guardianName=" + guardianName + ", specialNotes="
				+ specialNotes + ", memberid=" + memberid + "]";
	}

   
}


