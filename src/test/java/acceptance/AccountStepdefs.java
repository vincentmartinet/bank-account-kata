package acceptance;

import com.sfeir.kata.bankaccount.Account;
import com.sfeir.kata.bankaccount.InMemoryOperationHistory;
import com.sfeir.kata.bankaccount.Money;
import com.sfeir.kata.bankaccount.StatementLine;
import io.cucumber.java.en.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountStepdefs {
    private Account account;

    @Given("I have an empty bank account")
    public void iHaveAnEmptyBankAccount() {
        this.account = new Account(new InMemoryOperationHistory());
    }

    @When("I depose {int} units of money")
    public void iDeposeUnitsOfMoney(int amount) {
        account.depose(new Money(amount), LocalDate.now());
    }

    @Then("I should see a final balance of {int} unit of money")
    public void iShouldSeeAFinalBalanceOfSUnitOfMoney(int balance) {
        account.printStatement(lines -> {
            StatementLine last = lines.get(lines.size() - 1);
            assertEquals(new Money(balance), last.getBalance());
        });
    }
}
