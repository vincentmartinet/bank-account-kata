package com.sfeir.kata.bankaccount;

import java.util.List;

public interface StatementPrinter {
    void printStatement(List<StatementLine> lines);
}
