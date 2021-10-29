package io.hxcode.micronaut;

import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Sort;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

@MicronautTest
class MicronautOrderByTest {

    @Inject
    public AccountRepository accountRepository;

    @Test
    void testList() {
        accountRepository.list(Pageable.from(0).order(new Sort.Order("customer.title")));
    }

    @Test
    void testWithoutPageable() {
        accountRepository.listWithoutPageable();
    }

    @Test
    void testPageableSimpleOrder() {
        accountRepository.listPageable(Pageable.from(0).order(new Sort.Order("username")));
    }

    @Test
    void testPageableJoinedOrder() {
        accountRepository.listPageable(Pageable.from(0).order(new Sort.Order("customer.title")));
    }

}
