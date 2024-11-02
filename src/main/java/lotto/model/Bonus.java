package lotto.model;

import java.util.List;

public class Bonus {
    private final int bonusNumber;
    private static final  String REQUEST_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public Bonus(int bonusNumber) {
        isRangeValid(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private boolean isRangeValid(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 안에서 정할 수 있습니다.");
        }
        return true;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public static String getRequestMessage() {
        return REQUEST_BONUS_MESSAGE;
    }
}
