package com.sfeir.kata.bankaccount;

import java.io.PrintStream;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;

public class PrintStreamStatementPrinter implements StatementPrinter {
    private final PrintStream outputStream;
    private static final DateTimeFormatter dateFormatter = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .append(ISO_LOCAL_DATE)
            .appendLiteral(' ')
            .append(ISO_LOCAL_TIME)
            .toFormatter();

    public PrintStreamStatementPrinter(PrintStream printStream) {
        this.outputStream = printStream;
    }

    @Override
    public void print(List<StatementLine> lines) {
        outputStream.println("operation,date,amount,balance");
        for (StatementLine line : lines) {
            outputStream.print(line.getOperation().getType().name().toLowerCase());
            outputStream.print(",");
            outputStream.print(line.getOperation().getCreation().format(dateFormatter));
            outputStream.print(",");
            outputStream.print(line.getOperation().getAmount());
            outputStream.print(",");
            outputStream.print(line.getBalance());
            outputStream.println("");
        }
        outputStream.close();
    }
}
