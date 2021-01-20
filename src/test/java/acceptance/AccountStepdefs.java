package acceptance;

import com.sfeir.kata.bankaccount.Account;
import com.sfeir.kata.bankaccount.InMemoryOperationHistory;
import com.sfeir.kata.bankaccount.Money;
import io.cucumber.java8.En;
import io.cucumber.java8.PendingException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountStepdefs implements En {
    private Account account;

    public AccountStepdefs() {
        Given("^my bank account has a balance of \"([^\"]*)\"$", (String amount) -> {
            account = new Account(new InMemoryOperationHistory());
            account.depose(new Money(new BigDecimal(amount)), LocalDateTime.now());
        });

        When("^I depose \"([^\"]*)\"$", (String amount) -> {
            account.depose(new Money(new BigDecimal(amount)), LocalDateTime.now());
        });

        Then("^I should have a new balance of \"([^\"]*)\"$", (String balance) -> {
            throw new PendingException();
        });
    }
}
