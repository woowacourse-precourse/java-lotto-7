package lotto.validator;

import java.util.List;
import lotto.enums.LottoConfig;

public class WinNumValidator {

    public static void winNumSize(List<String> winNum) {
        if (winNum.size() != LottoConfig.LOTTO_NUM_SIZE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력해야 합니다.");
        }
    }

    public static void winNumIsNum(List<String> winNum) {
        try {
            for (String num : winNum) {
                Integer.parseInt(num);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 가능 합니다.");
        }
    }

    public static void winNumDup(List<Integer> winNum) {
        for (int num : winNum) {
            if (winNum.indexOf(num) != winNum.lastIndexOf(num)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 번호가 있습니다.");
            }
        }
    }

    public static void winNumRange(List<Integer> winNum) {
        for (int num : winNum) {
            if (num < LottoConfig.LOTTO_NUM_START.getValue() || num > LottoConfig.LOTTO_NUM_END.getValue()) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45까지만 가능합니다.");
            }
        }
    }
}
