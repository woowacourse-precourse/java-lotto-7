package lotto.models;

public class PreIssueModel {

    public int calculateAmount(String amountInput) {
        int amount = Integer.parseInt(amountInput);
        return (amount / 1000);
    }
}
