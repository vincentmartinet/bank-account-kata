package acceptance;

import com.sfeir.kata.bankaccount.Account;
import com.sfeir.kata.bankaccount.InMemoryOperationHistory;
import com.sfeir.kata.bankaccount.Money;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;

import java.time.LocalDate;

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
    public void iShouldSeeAFinalBalanceOfSUnitOfMoney(int arg0) {
        throw new PendingException();
    }
}
