package com.sfeir.kata.bankaccount;

import java.util.List;

public interface OperationHistory {

    void add(Operation operation);

    List<StatementLine> getStatement();
}
