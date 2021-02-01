package com.sfeir.kata.bankaccount;

import java.io.PrintStream;
import java.util.List;

public class PrintStreamStatementPrinter implements StatementPrinter {

    private final PrintStream printStream;

    public PrintStreamStatementPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void printStatement(List<StatementLine> lines) {
        printStream.println(printHeader());
        lines.stream()
                .map(this::printLine)
                .forEachOrdered(printStream::println);
    }

    private String printHeader() {
        return "OPERATION,DATE,AMOUNT,BALANCE";
    }

    private String printLine(StatementLine line) {
        String join = String.join(",",
                line.getOperation().getType().toString(),
                line.getOperation().getDate().toString(),
                line.getOperation().getAmount().toString(),
                line.getBalance().toString()
        );
        return join;
    }
}
