package com.service.investmentmanager.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "customer_account")
@Getter
@Setter
public class CustomerAccount {

    @Id
    @GeneratedValue
    private Long accountId;

//    @NotBlank(message = "Enter a valid customer ID")
    private Long customerId;
    private String accountName;
    private Long accountNumber;
    private Double balance;
}
