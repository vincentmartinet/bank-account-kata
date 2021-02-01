package com.sfeir.kata.bankaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InMemoryOperationHistory implements OperationHistory {
    private final List<Operation> history;

    public InMemoryOperationHistory() {
        this(new ArrayList<>());
    }

    public InMemoryOperationHistory(List<Operation> history) {
        this.history = history;
    }

    @Override
    public void add(Operation operation) {
        this.history.add(operation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InMemoryOperationHistory that = (InMemoryOperationHistory) o;
        return Objects.equals(history, that.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(history);
    }

    @Override
    public String toString() {
        return "InMemoryOperationHistory{" +
                "history=" + history +
                '}';
    }
}
