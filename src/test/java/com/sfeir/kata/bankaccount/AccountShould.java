package com.sfeir.kata.bankaccount;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static com.sfeir.kata.bankaccount.Operation.Type.DEPOSIT;
import static com.sfeir.kata.bankaccount.Operation.Type.WITHDRAWAL;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

class AccountShould {
    @Test
    void add_deposit_of_20_to_history() {
        // given
        OperationHistory mock = mock(OperationHistory.class);
        Account account = new Account(mock);
        LocalDate date = LocalDate.now();

        // when
        account.depose(new Money(20), date);

        // then
        verify(mock, only()).add(new Operation(DEPOSIT, new Money(20), date));
    }

    @Test
    void add_deposit_of_450_and_feed_it_to_the_statement_printer() {
        // given
        OperationHistory history = mock(OperationHistory.class);
        List<StatementLine> expected = asList(new StatementLine(
                new Operation(DEPOSIT, new Money(450), LocalDate.now()),
                new Money(450)
        ));
        when(history.getStatement()).thenReturn(expected);
        Account account = new Account(history);
        StatementPrinter mockPrinter = mock(StatementPrinter.class);

        // when
        account.printStatement(mockPrinter);

        // then
        verify(mockPrinter, only()).printStatement(expected);
    }

    @Test
    void add_withdrawal_of_900_to_history() {
        // given
        OperationHistory mock = mock(OperationHistory.class);
        Account account = new Account(mock);
        LocalDate date = LocalDate.now();

        // when
        account.withdraw(new Money(900), date);

        // then
        verify(mock, only()).add(new Operation(WITHDRAWAL, new Money(900), date));
    }
}
