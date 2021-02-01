package com.sfeir.kata.bankaccount;

import java.time.LocalDate;

public class Account {
    private final OperationHistory operationHistory;

    public Account(OperationHistory operationHistory) {
        this.operationHistory = operationHistory;
    }

    public void depose(Money amount, LocalDate date) {
        operationHistory.add(new Operation(Operation.Type.DEPOSIT, amount, date));
    }

    public void withdraw(Money amount, LocalDate date) {
        operationHistory.add(new Operation(Operation.Type.WITHDRAWAL, amount, date));
    }

    public void printStatement(StatementPrinter printer) {
        printer.printStatement(operationHistory.getStatement());
    }
}
