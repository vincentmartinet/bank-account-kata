package com.sfeir.kata.bankaccount;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOperationHistory implements OperationHistory{
    private final List<Operation> history = new ArrayList<>();

    @Override
    public void add(Operation operation) {
        this.history.add(operation);
    }

    List<Operation> getOperations() {
        return new ArrayList<>(history);
    }
}
