package com.sfeir.kata.bankaccount;

import java.util.Objects;
import java.util.StringJoiner;

public class StatementLine {

    private final Operation operation;
    private final Money balance;

    public StatementLine(Operation operation, Money balance) {
        this.operation = operation;
        this.balance = balance;
    }

    public Operation getOperation() {
        return operation;
    }

    public Money getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatementLine that = (StatementLine) o;
        return operation.equals(that.operation) && balance.equals(that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, balance);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StatementLine.class.getSimpleName() + "[", "]")
                .add("operation=" + operation)
                .add("balance=" + balance)
                .toString();
    }
}
