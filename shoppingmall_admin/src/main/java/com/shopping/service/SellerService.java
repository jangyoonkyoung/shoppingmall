package com.shopping.service;

import java.util.List;

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
        mapper.insertSeller(vo);
        return true;
    }

    public boolean isDuplicatedId(String id){
        Integer r =mapper.selectSellerById(id);
        if(r==0){
            return false; //해당 아이디로 가입된 가입자가 없다.
        }
        return true; //해당 아이디로 가입된 가입자가 있다.
    }

    public boolean isDuplicatedEmail(String email){
        Integer r =mapper.selectSellerByEmail(email);
        if(r==0){
            return false; //해당 이메일로 가입된 가입자가 없다.
        }
        return true; //해당 이메일로 가입된 가입자가 있다.
    }

    public List<SellerInfoVO> selectSellerList(){
        return mapper.selectSellerList();
    }
    public void sellerDelete(Integer seq){
        mapper.sellerDelete(seq);
    }
}
