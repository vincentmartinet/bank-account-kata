package acceptance;

import com.sfeir.kata.bankaccount.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AccountStepdefs implements En {
    private Account account;
    private OutputStream output = new ByteArrayOutputStream();

    public AccountStepdefs() {
        Given("^my bank account has an empty balance$", () -> {
            account = new Account(new InMemoryOperationHistory());
        });

        Given("^my bank account has a balance of \"([^\"]*)\"$", (String amount) -> {
            account = new Account(new InMemoryOperationHistory());
            account.depose(new Money(new BigDecimal(amount)), LocalDateTime.now());
        });

        And("^I have a deposit of (.*) made the (.*) at (.*)$", (String amount, String date, String time) -> {
            account.depose(new Money(new BigDecimal(amount)), LocalDateTime.parse(date + "T" + time, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
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

        When("^I ask for the statement$", () -> {
            account.printStatement(new PrintStreamStatementPrinter(new PrintStream(output)));
        });

        Then("^I should see$", (DataTable table) -> {
            List<TestStatementLine> statement = table.asList(TestStatementLine.class);
            assertEquals(output.toString().trim(),
                    "operation,date,amount,balance\n" +
                            statement.stream().map(TestStatementLine::toString).collect(joining("\n")).trim());
        });

        DataTableType((Map<String, String> row) -> new TestStatementLine(
                row.get("operation"),
                row.get("date"),
                row.get("amount"),
                row.get("balance")
        ));

    }


}
