package com.service.investmentmanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAccountDto {

    private String accountName;
    private Long accountNumber;
    private Double balance;

}
