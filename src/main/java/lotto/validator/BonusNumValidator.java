package lotto.validator;

import java.util.List;
import lotto.enums.LottoConfig;

public class BonusNumValidator {

    public static void bonusNumIsNum(String bonusNum) {
        try {
            Integer.parseInt(bonusNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 가능 합니다.");
        }
    }

    public static void bonusNumDup(List<Integer> winNum, Integer bonusNum) {
        if (winNum.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호에 존재합니다.");
        }
    }

    public static void bonusNumRange(Integer bonusNum) {
        if (bonusNum < LottoConfig.LOTTO_NUM_START.getValue() || bonusNum > LottoConfig.LOTTO_NUM_END.getValue()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45까지만 가능합니다.");
        }
    }
}
