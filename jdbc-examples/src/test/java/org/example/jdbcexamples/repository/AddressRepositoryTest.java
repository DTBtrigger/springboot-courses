package org.example.jdbcexamples.repository;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.example.jdbcexamples.dox.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;

    @Test
    void findByUserId() {
        for (Address a : addressRepository.findByUserId("1296637492620582912")) {
            log.debug("{}", a);
        }
    }
    @Test
    void updateAddressByUserId() {
        addressRepository.updateAddressByUserId("1297102547909763072","xiamen");
        log.debug("修改成功");

    }
    @Test
    void deleteAddressByUserId() {
        addressRepository.deleteAddressByUserId("1297505111989968896");
        log.debug("删除成功");
    }
}