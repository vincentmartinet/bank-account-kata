package acceptance;

import com.sfeir.kata.bankaccount.*;
import io.cucumber.java.DataTableType;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

    @When("I withdraw {int} units of money")
    public void iWithdrawUnitsOfMoney(int amount) {
        account.withdraw(new Money(amount), LocalDate.now());
    }

    @Then("I should see a final balance of {int} unit of money")
    public void iShouldSeeAFinalBalanceOfSUnitOfMoney(int balance) {
        account.printStatement(lines -> {
            StatementLine last = lines.get(lines.size() - 1);
            assertEquals(new Money(balance), last.getBalance());
        });
    }

    @DataTableType
    public Operation newOperation(Map<String, String> entry) {
        return new Operation(
                Operation.Type.valueOf(entry.get("TYPE")),
                new Money(new BigDecimal(entry.get("AMOUNT"))),
                LocalDate.parse(entry.get("DATE"))
        );
    }

    @Given("I have a bank account with the following operations made")
    public void iHaveABankAccountWithTheFollowingOperationsMade(List<Operation> operations) {
        this.account = new Account(new InMemoryOperationHistory(operations));
    }

    @When("I ask to see the history of my operations")
    public void iAskToSeeTheHistoryOfMyOperations() {
        throw new PendingException();
    }

    @Then("I have the following statement printed")
    public void iHaveTheFollowingStatementPrinted() {
        throw new PendingException();
    }
}
