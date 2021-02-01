package com.sfeir.kata.bankaccount;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private final BigDecimal amount;

    public Money(Number amount) {
        this.amount = new BigDecimal(amount.toString());
    }

    public Money add(Money other) {
        return new Money(this.amount.add(other.amount));
    }

    public Money negate() {
        return new Money(amount.negate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return amount.toString();
    }
}
