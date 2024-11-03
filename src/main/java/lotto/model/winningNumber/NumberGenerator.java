package lotto.model.winningNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGenerator {
    public static WinningNumber registerWinningNumber(String winningNumberInput) {
        try {
            List<Integer> winningNumber = Arrays.stream(winningNumberInput.split(",", -1))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new WinningNumber(winningNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자값만 입력해주세요.");
        }
    }

    public static BonusNumber registerBonusNumber(String bonusNumberInput, WinningNumber winningNumber) {
        try {
            int bonusNumber = Integer.parseInt(bonusNumberInput);
            if (winningNumber.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 값입니다.");
            }
            return new BonusNumber(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자값만 입력해주세요.");
        }
    }
}
