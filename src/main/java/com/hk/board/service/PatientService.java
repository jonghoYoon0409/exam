package com.hk.board.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hk.board.command.AddPatientCommand;
import com.hk.board.dtos.PatientDto;
import com.hk.board.mapper.patientMapper;

@Service
public class PatientService {

    @Autowired
    private patientMapper patientMapper; // PatientMapper 주입

    // 환자 추가 메소드
    public boolean addPatient(AddPatientCommand addPatientCommand) {
        try {
            // admission_Date를 String에서 Date로 변환
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date admissionDate = formatter.parse(addPatientCommand.getAdmission_date());
            // PatientDto 객체에 값 설정
            PatientDto patientDto = new PatientDto();
            patientDto.setPatientId(addPatientCommand.getPatient_id());
            patientDto.setPatientName(addPatientCommand.getPatient_name());
            patientDto.setDiagnosis(addPatientCommand.getDiagnosis());
            patientDto.setAdmissionDate(admissionDate); // 변환된 Date 사용
            patientDto.setGuardianName(addPatientCommand.getGuardian_name());
            patientDto.setSpecialNotes(addPatientCommand.getSpecial_notes());
            patientDto.setMemberid(addPatientCommand.getMemberid());

           System.out.println(patientDto);
            // DB에 저장
            return patientMapper.addPatient(patientDto); 
        } catch (ParseException e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
            return false; // 변환 실패 시 false 반환
        }
        
    }
    public List<PatientDto> getPatientsByMemberId(String memberId) {
        // Map 객체에 memberid를 넣어 Mapper에 전달
        Map<String, String> params = new HashMap<>();
        params.put("memberid", memberId);

        // MyBatis Mapper 호출
        return patientMapper.patientlist(params);
    }

    
}



/*
 * // 환자 정보 조회 메소드 (예시) public PatientDto getPatient(int patientId) { return
 * patientMapper.getPatient(patientId); // DB에서 환자 정보 조회 } }
 */






