package com.shopping.vo;

import lombok.Data;

@Data
public class SellerInfoVO {
    private Integer si_seq;
    private String si_id;
    private String si_pwd;
    private String si_name;
    private String si_email;
    private String si_phone;
    private Integer si_grade;

}
