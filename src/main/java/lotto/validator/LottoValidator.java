package lotto.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;

public class LottoValidator {

    public void purchaseAmountTypeValidator(String purchaseAmount) {
        for (char num : purchaseAmount.toCharArray()) {
            if(!Character.isDigit(num)) {
                throw new IllegalArgumentException("[ERROR] 구입 금액에는 문자가 들어갈 수 없습니다.");
            }
        }
    }

    public void purchaseAmountPositiveValidator(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 음수가 될 수 없습니다.");
        }

    }

    public void purchaseAmountUnitValidator (int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    //구매 금액에 숫자가 아닌 다른 것이 들어갈 때.

    //중복 값 검증
    public void duplicateNumValidator(Lotto lotto) {
        ArrayList<Integer> lottoNums = new ArrayList<>(lotto.getNumbers());
        Set<Integer> uniqueNumbers = new HashSet<>(lottoNums);

        System.out.println("lottoNums = " + lottoNums);
        System.out.println("uniqueNumbers.toString() = " + uniqueNumbers);
        if (uniqueNumbers.size() != lottoNums.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 값이 있습니다.");
        }
    }

    //로또 1~45 범위 검증


    //6개 이상이 되지 않도록 검증
}
