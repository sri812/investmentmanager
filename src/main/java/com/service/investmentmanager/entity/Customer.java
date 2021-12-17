package com.service.investmentmanager.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {

    @Id
    private Long customerId;
    private String customerName;
    private String password;

}
