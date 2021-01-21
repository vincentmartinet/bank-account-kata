package com.sfeir.kata.bankaccount;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOperationHistory implements OperationHistory {
    private final List<Operation> history = new ArrayList<>();

    @Override
    public void add(Operation operation) {
        this.history.add(operation);
    }

    @Override
    public List<StatementLine> getStatement() {
        Money balance = new Money(0);
        List<StatementLine> statement = new ArrayList<>();
        for (Operation operation : history) {
            balance = balance.add(operation.getAmount());
            statement.add(new StatementLine(operation, balance));
        }
        return statement;
    }

    List<Operation> getOperations() {
        return new ArrayList<>(history);
    }
}
