package com.sfeir.kata.bankaccount;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.sfeir.kata.bankaccount.Operation.Type.DEPOSIT;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryOperationHistoryShould {

    @Test
    void add_deposit_of_80_to_operation_list() {
        // given
        InMemoryOperationHistory operationHistory = new InMemoryOperationHistory();
        Operation operation = new Operation(DEPOSIT, new Money(80), LocalDate.now());

        // when
        operationHistory.add(operation);

        // then
        assertEquals(new InMemoryOperationHistory(asList(operation)), operationHistory);
    }

}
