package lotto;

public class InputHandler {
    public static void validateLottoBudget(int budget) {
        if (budget <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0원 이상이어야 합니다.");
        }
        if (budget % 1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
