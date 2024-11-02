package lotto.models;

import java.util.List;

public class PreIssueModel {
    private final int amount; // 구매 금액을 저장할 필드
    public PreIssueModel(String amountInput) {
        this.amount = calculateAmount(amountInput); // 구매 금액 계산
    }
    private int calculateAmount(String amountInput) {
        try {
            int amount = Integer.parseInt(amountInput);
            if (amount < 0) {
                throw new IllegalArgumentException("[ERROR] 구매 금액은 양수로 입력해야 합니다.");
            }
            return (amount / 1000);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 정수로 입력해야 합니다.");
        }
    }

    public int getAmount() {
        return amount;
    }
}
