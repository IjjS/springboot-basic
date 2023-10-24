package com.programmers.vouchermanagement.customer.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.programmers.vouchermanagement.customer.domain.Customer;
import com.programmers.vouchermanagement.customer.dto.CustomerResponse;
import com.programmers.vouchermanagement.customer.repository.CustomerRepository;
import com.programmers.vouchermanagement.voucher.service.VoucherService;

class CustomerServiceTest {
    static CustomerRepository customerRepository;
    static CustomerService customerService;

    @BeforeAll
    static void setUp() {
        customerRepository = mock();
        customerService = new CustomerService(customerRepository);
    }

    @Test
    @DisplayName("저장된 블랙리스트가 없을 때 블랙리스트 조회 시 빈 리스트를 반환한다.")
    void testReadBlacklistSuccessful_ReturnEmptyList() {
        //given
        doReturn(Collections.emptyList()).when(customerRepository).findBlackCustomers();

        //when
        List<CustomerResponse> blacklist = customerService.readBlacklist();

        //then
        assertThat(blacklist.isEmpty(), is(true));
    }
}
