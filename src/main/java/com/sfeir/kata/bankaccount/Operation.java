package com.sfeir.kata.bankaccount;

import java.time.LocalDate;
import java.util.Objects;

public class Operation {
    private final Type type;
    private final Money amount;
    private final LocalDate date;

    public Operation(Type type, Money amount, LocalDate date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public Type getType() {
        return type;
    }

    public Money getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return type == operation.type && amount.equals(operation.amount) && date.equals(operation.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, amount, date);
    }

    @Override
    public String toString() {
        return "Operation{" +
                "type=" + type +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

    public enum Type {
        DEPOSIT, WITHDRAWAL
    }
}
