package com.service.investmentmanager.service;

import com.service.investmentmanager.dto.CustomerAccountDto;
import com.service.investmentmanager.entity.CustomerAccount;
import com.service.investmentmanager.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvestmentService {
    List<CustomerAccountDto> getInvestmentAccountsByCustomerId(Long customerId) throws CustomerNotFoundException;

}
