package lotto.validator;

import java.util.List;
import lotto.enums.LottoConfig;

public class ControllerValidator {

    public void amountIsNum(String inputAmount) {
        try {
            Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 가능 합니다.");
        }
    }

    public void winNumSize(List<String> winNum) {
        if (winNum.size() != LottoConfig.LOTTO_NUM_SIZE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력해야 합니다.");
        }
    }

    public void winNumIsNum(List<String> winNum) {
        try {
            for(String num : winNum) {
                Integer.parseInt(num);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 가능 합니다.");
        }
    }

    public void bonusNumIsNum(String bonusNum) {
        try {
            Integer.parseInt(bonusNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 가능 합니다.");
        }
    }
}
