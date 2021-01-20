package com.sfeir.kata.bankaccount;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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
}
