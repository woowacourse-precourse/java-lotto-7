package lotto.Model;

public class PurchaseCost {
    private int purchaseCost;

    public PurchaseCost(int inputtedCost) {
        validateUnderZero(inputtedCost);
        validateCanDivideBy1000(inputtedCost);
        this.purchaseCost = inputtedCost;
    }

    private void validateUnderZero(int inputtedCost) {
        if (inputtedCost <= 0) {
            throw new IllegalArgumentException("[ERROR] 0 이하의 수는 입력하실 수 없습니다.");
        }
    }

    private void validateCanDivideBy1000(int inputtedCost) {
        if (inputtedCost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]: 1,000으로 나누어 떨어지지 않는 수는 입력하실 수 없습니다.");
        }
    }

    public int calculateBuyableLottoCount() {
        return this.purchaseCost / 1000;
    }
}
