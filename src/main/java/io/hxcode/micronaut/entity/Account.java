package io.hxcode.micronaut.entity;

import io.micronaut.core.annotation.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    @Nullable
    @ManyToOne
    private Customer customer; // is null for admin and sadmin

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var account = (Account) o;
        if (!Objects.equals(id, account.id)) return false;
        return username.equals(account.username);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + username.hashCode();
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Nullable
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(@Nullable Customer customer) {
        this.customer = customer;
    }
}
