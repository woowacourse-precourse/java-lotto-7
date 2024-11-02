package lotto.model;

public class LottoAmount {
    private int lottoAmount;

    public LottoAmount(String purchaseAmountInput) {
        int purchaseAmount = transferToInteger(purchaseAmountInput);
        validate(purchaseAmount);
        this.lottoAmount = calculateLottoAmount(purchaseAmount);
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위의 금액을 입력해주세요.");
        }
    }

    private int transferToInteger(String purchaseAmountInput) {
        try {
            //앞서 양의정수를 점검했는데, 또 해야할까? -> 보험용. 그러니 validate 안에 없어도 된다
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
