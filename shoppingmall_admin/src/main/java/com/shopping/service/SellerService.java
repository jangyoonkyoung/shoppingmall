package com.shopping.service;

import com.shopping.mapper.SellerMapper;
import com.shopping.vo.SellerInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired SellerMapper mapper;
    //가입하는 자 조건에 맞으면 true 틀리면 false
    public boolean insertSeller(SellerInfoVO vo) {
        //중복 가입자 확인하기
        //중복 될 경우 로그인 하지 못하게 한다.
        Integer cnt = mapper.selectSellerById(vo.getSi_id());
        if(cnt!=0) return false;

        if(vo.getSi_id() == "" || vo.getSi_id() == null || vo.getSi_id().length() < 4) {
            return false;
        }
        if(vo.getSi_pwd() == "" || vo.getSi_pwd() == null || vo.getSi_pwd().length() < 6) {
            return false;
        }
        if(vo.getSi_name() == "" || vo.getSi_name() == null) {
            return false;
        }
        if(vo.getSi_phone() == "" || vo.getSi_phone() == null) {
            return false;
        }
        if(vo.getSi_address() == "" || vo.getSi_address() == null) {
            return false;
        }
        if(vo.getSi_email() == "" || vo.getSi_email() == null) {
            return false;
        }
        mapper.insertSeller(vo);
        return true;
    }
    public boolean isDuplicated(String id){
        Integer r =mapper.selectSellerById(id);
        if(r==0){
            return false; //해당 아이디로 가입된 가입자가 없다.
        }
        return true; //해당 아이디로 가입된 가입자가 있다.
    }

}
