package com.sfeir.kata.bankaccount;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

import static com.sfeir.kata.bankaccount.Operation.Type.DEPOSIT;
import static com.sfeir.kata.bankaccount.Operation.Type.WITHDRAWAL;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class PrintStreamStatementPrinterShould {

    @Test
    void print_a_statement_of_a_deposit_of_400_and_a_withdrawal_of_40() {
        // given
        PrintStream printStream = Mockito.mock(PrintStream.class);
        PrintStreamStatementPrinter statementPrinter = new PrintStreamStatementPrinter(printStream);
        List<StatementLine> statement = asList(
                new StatementLine(new Operation(DEPOSIT, new Money(400), LocalDate.of(2020, 12, 24)), new Money(400)),
                new StatementLine(new Operation(WITHDRAWAL, new Money(40), LocalDate.of(2021, 1, 7)), new Money(360))
        );

        // when
        statementPrinter.printStatement(statement);

        // then
        InOrder inOrder = inOrder(printStream);
        inOrder.verify(printStream).println("OPERATION,DATE,AMOUNT,BALANCE");
        inOrder.verify(printStream).println("DEPOSIT,2020-12-24,400,400");
        inOrder.verify(printStream).println("WITHDRAWAL,2021-01-07,40,360");
        verifyNoMoreInteractions(printStream);
    }
}
