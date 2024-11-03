package lotto;

public class PurchaseCalculator {
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    public PurchaseCalculator(String input) {
        this.purchaseAmount = convertInputToAmount(input);
        validateAmount(purchaseAmount);
    }

    // 문자열->정수 변환
    private int convertInputToAmount(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력하세요.");
        }
    }

    // 변환 금액이 1,000원 단위인지 확인
    private void validateAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력하세요.");
        }
    }

    // 로또의 개수 반환
    public int calculateLottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }
}
