package lotto;

public class LottoMachine {
    private static final long LOTTO_PRICE = 1000;

    public void run() {
        long purchaseCount = getPurchaseCountFromUser();
    }

    private long getPurchaseCountFromUser() {
        long amount = InputView.getAmountFromUser();

        if (!(amount > 0))
            throw new IllegalArgumentException("[ERROR] 양수가 아닙니다.");
        if (amount % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 입력이 1000으로 나누어 떨어지지 않습니다.");

        return amount / LOTTO_PRICE;
    }
}
