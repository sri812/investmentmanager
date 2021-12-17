package com.service.investmentmanager.controller;

import com.service.investmentmanager.dto.CustomerAccountDto;
import com.service.investmentmanager.exception.CustomerNotFoundException;
import com.service.investmentmanager.service.InvestmentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InvestmentController {

    Logger logger = LogManager.getLogger(InvestmentController.class);

    @Autowired
    private InvestmentServiceImpl service;

    @GetMapping("/customers/{customerId}/accounts")
    public ResponseEntity<List<CustomerAccountDto>> getInvestmentAccountsByCustomerId(@Valid @PathVariable Long customerId) throws CustomerNotFoundException {

        logger.info("Controller Method getInvestmentAccountsByCustomerId called with customer ID " + customerId);

        List<CustomerAccountDto> customerAccountDto = service.getInvestmentAccountsByCustomerId(customerId);

        return new ResponseEntity<>(customerAccountDto, HttpStatus.OK);

    }

}
