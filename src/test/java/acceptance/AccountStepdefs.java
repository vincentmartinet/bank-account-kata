package acceptance;

import com.sfeir.kata.bankaccount.Account;
import com.sfeir.kata.bankaccount.InMemoryOperationHistory;
import com.sfeir.kata.bankaccount.Money;
import com.sfeir.kata.bankaccount.StatementLine;
import io.cucumber.java8.En;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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

        When("^I withdraw \"([^\"]*)\"$", (String amount) -> {
            account.withdraw(new Money(new BigDecimal(amount)), LocalDateTime.now());
        });

        Then("^I should have a new balance of \"([^\"]*)\"$", (String balance) -> {
            account.printStatement(lines -> {
                Optional<StatementLine> lastLine = lines.stream().reduce((sl1, sl2) -> sl2);
                if (!lastLine.isPresent()) {
                    fail("no statement, when at least one is expected");
                }
                assertEquals(lastLine.get().getBalance(), new Money(new BigDecimal(balance)));
            });
        });
    }
}
