package com.sfeir.kata.bankaccount;

import java.time.LocalDateTime;

public class Account {
    private final OperationHistory history;

    public Account(OperationHistory history) {
        this.history = history;
    }

    public void depose(Money amount, LocalDateTime operationDate) {
        history.add(new Operation(OperationType.DEPOSIT, amount, operationDate));
    }

    public void printStatement(StatementPrinter printer) {
        printer.print(history.getStatement());
    }
}
