package com.sfeir.kata.bankaccount;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class Operation {
    private final OperationType type;
    private final Money amount;
    private final LocalDateTime creation;

    public Operation(OperationType type, Money amount, LocalDateTime date) {
        this.type = type;
        this.amount = amount;
        this.creation = date;
    }

    public OperationType getType() {
        return type;
    }

    public Money getAmount() {
        return amount;
    }

    public LocalDateTime getCreation() {
        return creation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return type == operation.type && amount.equals(operation.amount) && creation.equals(operation.creation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, amount, creation);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Operation.class.getSimpleName() + "[", "]")
                .add("type=" + type)
                .add("amount=" + amount)
                .add("creation=" + creation)
                .toString();
    }
}
