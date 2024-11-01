package lotto.exception;

public class CheckInput {

    public static void checkInputMoney(int inputMoney) {
        if (inputMoney < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 이상이어야 합니다.");
        }

        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원단위어야 합니다.");
        }
    }

}
