package io.hxcode.micronaut;

import io.hxcode.micronaut.entity.Account;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Join(value = "customer", type = Join.Type.FETCH)
    Page<Account> list(Pageable pageable);

    @Query(value = "SELECT a FROM Account a ORDER BY a.customer.title")
    List<Account> listWithoutPageable();

    @Query(
            value = "SELECT account_ FROM Account account_ ",
            countQuery = "SELECT count(account_) FROM Account account_ "
    )
    @Join(value = "customer", type = Join.Type.FETCH)
    Page<Account> listPageable(Pageable pageable);

}
