package com.sfeir.kata.bankaccount;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintStreamStatementPrinterShould {

    @Test
    void print_statement_to_a_given_output_stream() {
        // given
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStreamStatementPrinter printer = new PrintStreamStatementPrinter(new PrintStream(output));
        Operation deposit = new Operation(OperationType.DEPOSIT, new Money(1000), LocalDateTime.of(2020, 12, 31, 18, 45));
        Operation withdrawal = new Operation(OperationType.WITHDRAWAL, new Money(200), LocalDateTime.of(2021, 1, 1, 8, 10));

        // when
        printer.print(Arrays.asList(
                new StatementLine(deposit, new Money(1000)),
                new StatementLine(withdrawal, new Money(800))
        ));

        // then
        assertEquals(
                output.toString(),
                "operation,date,amount,balance\n" +
                        "deposit,2020-12-31 18:45:00,1000,1000\n" +
                        "withdrawal,2021-01-01 08:10:00,200,800\n");
    }

}
