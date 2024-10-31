package lotto.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;

public class LottoValidator {

    //구매 금액에 숫자가 아닌 다른 것이 들어갈 때.
    public void purchaseAmountTypeValidator(String purchaseAmount) {
        for (char num : purchaseAmount.toCharArray()) {
            if(!Character.isDigit(num)) {
                throw new IllegalArgumentException("[ERROR] 구입 금액에는 문자가 들어갈 수 없습니다.");
            }
        }
    }
    //음수인지 검증
    public void purchaseAmountPositiveValidator(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 음수가 될 수 없습니다.");
        }

    }

    //1000원 단위인지 검증
    public void purchaseAmountUnitValidator (int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    //중복 값 검증
    public void duplicateNumValidator(Lotto lotto) {
        ArrayList<Integer> lottoNums = new ArrayList<>(lotto.getNumbers());
        Set<Integer> uniqueNumbers = new HashSet<>(lottoNums);

        if (uniqueNumbers.size() != lottoNums.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 값이 있습니다.");
        }
    }

    //로또 1~45 범위 검증
    public void lottoNumRangeValidator (Lotto lotto) {
        ArrayList<Integer> lottoNums = new ArrayList<>(lotto.getNumbers());
        for (Integer lottoNum : lottoNums) {
            if (lottoNum > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45의 범위만 가능합니다.");
            }
        }
    }

    //보너스 번호 1~45 범위 검증
    public void bonusNumRangeValidator (int bonusNum) {
        if (bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45의 범위만 가능합니다.");
        }
    }

    //로또 번호, 보너스 번호 타입 검증
}
