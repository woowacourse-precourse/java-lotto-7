package lotto;

import java.util.List;

public class BonusNumberValidator extends LottoNumber {
    private static int parsedBonusNumber;

    BonusNumberValidator(String bonusNumber, List<Integer> winningNumbers) {
        validate(bonusNumber, winningNumbers);
    }

    public static void validate(String bonusNumber, List<Integer> winningNumbers) {
        int parsedBonusNumber;
        try {
            parsedBonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] int 범위 숫자만 입력해 주세요.(원 단위)");
        }
        validateNumberRange(parsedBonusNumber);
        for (int num : winningNumbers) {
            if (parsedBonusNumber == num) {
                throw new IllegalArgumentException("[ERROR] bonus 숫자는 당첨 번호와 달라야합니다.");
            }
        }
    }

    public static int getBonusNumber() {
        return parsedBonusNumber;
    }

}
