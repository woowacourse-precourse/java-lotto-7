package lotto.Model;

public class PurchaseCost {
    private int purchaseCost;

    public PurchaseCost(int inputtedCost) {
        validateUnderZero(inputtedCost);
        this.purchaseCost = inputtedCost;
    }

    private void validateUnderZero(int inputtedCost) {
        if (inputtedCost <= 0) {
            throw new IllegalArgumentException("[ERROR] 0 이하의 수는 입력하실 수 없습니다.");
        }
    }
}
