package lotto.model;

import utils.ValidationManager;

public class Bonus {
    private final int bonusNumber;
    private static final  String REQUEST_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public Bonus(String bonusInput) {
        ValidationManager.isNumber(bonusInput);
        ValidationManager.isNotEmptyInput(bonusInput);
        this.bonusNumber = isRangeValid(Integer.parseInt(bonusInput));
    }

    private int isRangeValid(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 안에서 정할 수 있습니다.");
        }
        return number;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public static String getRequestMessage() {
        return REQUEST_BONUS_MESSAGE;
    }
}
