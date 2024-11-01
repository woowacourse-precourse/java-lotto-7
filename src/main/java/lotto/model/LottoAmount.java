package lotto.model;

public class LottoAmount {
    private int lottoAmount;

    public LottoAmount(String purchaseAmountInput) {
        int purchaseAmount = validate(purchaseAmountInput);
        this.lottoAmount = calculateLottoAmount(purchaseAmount);
    }

    private int validate(String purchaseAmountInput) {
        //앞서 양의정수를 점검했는데, 또 해야할까?
        try {
            if (!purchaseAmountInput.endsWith("000")) {
                throw new IllegalArgumentException("[ERROR] 1000 단위의 금액을 입력해주세요.");
            }
            return Integer.parseInt(purchaseAmountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 1000 단위의 금액을 입력해주세요.");
        }

    }

    private int calculateLottoAmount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }
}
