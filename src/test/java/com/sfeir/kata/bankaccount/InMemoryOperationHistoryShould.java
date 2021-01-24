package com.sfeir.kata.bankaccount;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryOperationHistoryShould {
    @Test
    void add_deposit_of_40_to_the_operation_list() {
        // given
        InMemoryOperationHistory operationHistory = new InMemoryOperationHistory();
        Operation operation = new Operation(OperationType.DEPOSIT, new Money(40), LocalDateTime.now());

        // when
        operationHistory.add(operation);

        // then
        assertEquals(operationHistory.getOperations(), Arrays.asList(operation));
    }

    @Test
    void give_statement_of_two_deposits() {
        // given
        InMemoryOperationHistory operationHistory = new InMemoryOperationHistory();
        Operation operation1 = new Operation(OperationType.DEPOSIT, new Money(10), LocalDateTime.now());
        Operation operation2 = new Operation(OperationType.DEPOSIT, new Money(10), LocalDateTime.now());
        operationHistory.add(operation1);
        operationHistory.add(operation2);

        // when
        List<StatementLine> statement = operationHistory.getStatement();

        // then
        assertEquals(statement, Arrays.asList(
                new StatementLine(operation1, new Money(10)),
                new StatementLine(operation2, new Money(20))
        ));
    }

    @Test
    void give_statement_of_one_deposit_and_one_withdrawal() {
        // given
        InMemoryOperationHistory operationHistory = new InMemoryOperationHistory();
        Operation deposit = new Operation(OperationType.DEPOSIT, new Money(100), LocalDateTime.now());
        Operation withdrawal = new Operation(OperationType.WITHDRAWAL, new Money(20), LocalDateTime.now());
        operationHistory.add(deposit);
        operationHistory.add(withdrawal);

        // when
        List<StatementLine> statement = operationHistory.getStatement();

        // then
        assertEquals(statement, Arrays.asList(
                new StatementLine(deposit, new Money(100)),
                new StatementLine(withdrawal, new Money(80))
        ));
    }
}
