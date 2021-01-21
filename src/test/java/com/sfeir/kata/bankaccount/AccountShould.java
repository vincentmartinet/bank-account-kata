package com.sfeir.kata.bankaccount;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class AccountShould {
    @Test
    void add_deposit_of_20_to_operation_history() {
        // given
        OperationHistory operationHistory = mock(OperationHistory.class);
        Account account = new Account(operationHistory);
        LocalDateTime operationDate = LocalDateTime.now();

        // test
        account.depose(new Money(20), operationDate);

        // assert
        verify(operationHistory).add(new Operation(OperationType.DEPOSIT, new Money(20), operationDate));
    }

    @Test
    void print_statement_with_history() {
        // given
        OperationHistory operationHistory = mock(OperationHistory.class);
        List<StatementLine> statement = Arrays.asList(mock(StatementLine.class));
        when(operationHistory.getStatement()).thenReturn(statement);

        Account account = new Account(operationHistory);
        StatementPrinter printer = mock(StatementPrinter.class);

        // when
        account.printStatement(printer);

        // then
        verify(printer).print(statement);
    }
}
