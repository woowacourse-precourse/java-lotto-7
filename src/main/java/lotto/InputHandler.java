package lotto;

public class InputHandler {
    public static void validateLottoBudget(int budget) {
        if (budget <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0원 이상이어야 합니다.");
        }
    }
}
