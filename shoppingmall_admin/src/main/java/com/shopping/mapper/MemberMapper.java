package com.shopping.mapper;

import java.util.List;

import com.shopping.vo.LoginVO;
import com.shopping.vo.MemberInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public void insertmember(MemberInfoVO vo);
    public Integer selectMemberById(String id);
    public Integer selectMemberByEmail(String email);
    public Integer memberLogin(LoginVO vo);
    public MemberInfoVO selectMemberInfo(String id);
    public List<MemberInfoVO> selectMemberList ();
    public void deleteMember(Integer seq);
}
