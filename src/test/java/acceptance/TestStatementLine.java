package acceptance;

public class TestStatementLine {
    String operation;
    String date;
    String amount;
    String balance;

    TestStatementLine(String operation, String date, String amount, String balance) {
        this.operation = operation;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public String toString() {
        return String.format("%s,%s,%s,%s", operation, date, amount, balance);
    }
}
