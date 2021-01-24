package com.sfeir.kata.bankaccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MoneyShould {
    @Test
    void be_equals_when_the_amount_is_the_same() {
        assertTrue(new Money(80).equals(new Money(80.0)), "80 amount of money should be equal to 80.0 amount of money");
    }
}
