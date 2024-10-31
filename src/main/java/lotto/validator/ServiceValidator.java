package lotto.validator;

import java.util.List;
import lotto.enums.LottoConfig;

public class ServiceValidator {

    public void amountDivide(Integer amount) {
        if ((amount % LottoConfig.LOTTO_PRICE.getValue()) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    public void winNumDup(List<Integer> winNum) {
        for (int num : winNum) {
            if (winNum.indexOf(num) != winNum.lastIndexOf(num)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 번호가 있습니다.");
            }
        }
    }

    public void bonusNumDup(List<Integer> winNum, Integer bonusNum) {
        if (winNum.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호에 존재합니다.");
        }
    }
}
