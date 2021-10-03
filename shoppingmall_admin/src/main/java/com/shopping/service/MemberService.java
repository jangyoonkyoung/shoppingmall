package com.shopping.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.shopping.mapper.MemberMapper;
import com.shopping.utils.AESAlgorithm;
import com.shopping.vo.LoginVO;
import com.shopping.vo.MemberInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired MemberMapper mapper;
    //회원가입
    public Map<String, Object> insertmember(MemberInfoVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        resultMap.put("status", true);
        resultMap.put("message", "회원가입이 완료되었습니다.");

        String pwd = vo.getMi_pwd();
        try {
            pwd = AESAlgorithm.Encrypt(pwd);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        vo.setMi_pwd(pwd);

        mapper.insertmember(vo);

        return resultMap;
    }
    
    //아이디 중복 확인
    public boolean isDuplicatedId(String id){
        return mapper.selectMemberById(id)>0;
    }
    //아이디 중복 확인
    public boolean isDuplicatedEmail(String email){
        return mapper.selectMemberByEmail(email)>0;
    }
    //로그인
    public Map<String, Object> MemberLogin(LoginVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        String pwd = vo.getPwd();
        try {
            pwd = AESAlgorithm.Encrypt(pwd);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        vo.setPwd(pwd);
        Integer result = mapper.memberLogin(vo);
        if(result == 1) {
            resultMap.put("status", true);
            MemberInfoVO member = mapper.selectMemberInfo(vo.getId());
            resultMap.put("member", member);
        }
        else {
            resultMap.put("status", false);
            resultMap.put("message", "아이디 혹은 비밀번호를 확인해주세요.");
        }
        return resultMap;
    }
    public List<MemberInfoVO> selectMemberList(){
        return mapper.selectMemberList();
    }
    public void deleteMember(Integer seq){
        mapper.deleteMember(seq);
    }
}
