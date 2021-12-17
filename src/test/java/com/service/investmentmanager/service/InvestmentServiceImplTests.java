package com.service.investmentmanager.service;

import com.service.investmentmanager.dto.CustomerAccountDto;
import com.service.investmentmanager.entity.CustomerAccount;
import com.service.investmentmanager.exception.CustomerNotFoundException;
import com.service.investmentmanager.repository.CustomerAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static com.service.investmentmanager.ApplicationConstants.CUSTOMER_NOT_FOUND;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class InvestmentServiceImplTests {

    private List<CustomerAccount> customerAccountList;
    private List<CustomerAccountDto> customerAccountDtoList;

    @InjectMocks
    private InvestmentServiceImpl investmentService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private CustomerAccountRepository customerAccountRepository;

    @BeforeEach
    void setup() {
        customerAccountList = new ArrayList<>();
        CustomerAccount accountOne = new CustomerAccount();
        accountOne.setAccountId(1L);
        accountOne.setAccountNumber(1L);
        accountOne.setAccountName("first dummy");
        accountOne.setBalance(100.0);
        accountOne.setCustomerId(1L);
        customerAccountList.add(accountOne);

        customerAccountDtoList = new ArrayList<>();
        CustomerAccountDto dtoOne = new CustomerAccountDto();
        dtoOne.setAccountNumber(1L);
        dtoOne.setAccountName("first dummy");
        dtoOne.setBalance(100.0);
        customerAccountDtoList.add(dtoOne);
    }


    @Test
    void testSuccessGetInvestmentAccountsByCustomerID() throws CustomerNotFoundException {

        Mockito.when(this.customerAccountRepository.findAllByCustomerId(1L)).thenReturn(customerAccountList);

        CustomerAccountDto[] accountArrayDto = customerAccountDtoList.toArray(new CustomerAccountDto[0]);
        Mockito.when(modelMapper.map(customerAccountList, CustomerAccountDto[].class)).thenReturn(accountArrayDto);

        assertThat(this.investmentService.getInvestmentAccountsByCustomerId(1L)).isEqualTo(customerAccountDtoList);
    }

    @Test
    void testFailureGetInvestmentAccountsByCustomerID() {

        Mockito.when(this.customerAccountRepository.findAllByCustomerId(3L)).thenReturn(Collections.emptyList());
        Throwable ex = assertThrows(CustomerNotFoundException.class, () -> this.investmentService.getInvestmentAccountsByCustomerId(3L));
        assertThat(ex.getMessage().contains(CUSTOMER_NOT_FOUND));
    }

}
