package com.sfeir.kata.bankaccount;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

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
        verify(mock, only()).add(new Operation(Operation.Type.DEPOSIT, new Money(20), date));
    }
}
