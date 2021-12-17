package com.service.investmentmanager.service;

import com.service.investmentmanager.dto.CustomerAccountDto;
import com.service.investmentmanager.entity.CustomerAccount;
import com.service.investmentmanager.exception.CustomerNotFoundException;
import com.service.investmentmanager.repository.CustomerAccountRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static com.service.investmentmanager.ApplicationConstants.*;

@Service
public class InvestmentService {

    Logger logger = LogManager.getLogger(InvestmentService.class);

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<CustomerAccountDto> getInvestmentAccountsByCustomerId(Long customerId) throws CustomerNotFoundException {

        List<CustomerAccount> customerAccountList =  customerAccountRepository.findAllByCustomerId(customerId);
        logger.info("Investment Service Method getInvestmentAccountsByCustomerId called with customer ID " + customerId);

        if(customerAccountList.isEmpty()) throw new CustomerNotFoundException(CUSTOMER_NOT_FOUND);

        return Arrays.asList(modelMapper.map(customerAccountList, CustomerAccountDto[].class));
    }
}
