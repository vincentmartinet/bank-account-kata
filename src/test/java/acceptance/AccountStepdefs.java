package acceptance;

import io.cucumber.java8.En;
import io.cucumber.java8.PendingException;

public class AccountStepdefs implements En {

    public AccountStepdefs() {
        Given("^my bank account has a balance of \"([^\"]*)\"$", (String arg0) -> {
            throw new PendingException();
        });

        When("^I depose \"([^\"]*)\"$", (String arg0) -> {
            throw new PendingException();
        });

        Then("^I should have a new balance of \"([^\"]*)\"$", (String arg0) -> {
            throw new PendingException();
        });
    }
}
