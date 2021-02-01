package acceptance;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;

public class AccountStepdefs {
    @Given("I have an empty bank account")
    public void iHaveAnEmptyBankAccount() {
        throw new PendingException();
    }

    @When("I depose {int} units of money")
    public void iDeposeUnitsOfMoney(int arg0) {
        throw new PendingException();
    }

    @Then("I should see a final balance of {int} unit of money")
    public void iShouldSeeAFinalBalanceOfSUnitOfMoney(int arg0) {
        throw new PendingException();
    }
}
