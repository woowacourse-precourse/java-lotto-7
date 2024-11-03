package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UserNumbers {
    private List<UserNumber> UserNumbers;
    private int purchaseCount;

    public UserNumbers(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        makeUserNumbers();
    }

    private void initField(int purchaseAmount) {
        purchaseCount = purchaseAmount / 1000;
        UserNumbers = new ArrayList<>();
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("로또 한 장 가격은 1000원 입니다. 올바른 금액을 입력해주세요.");
        }
    }

    private void makeUserNumbers() {
        while (purchaseCount-- > 0) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            new UserNumber(lottoNumber);
        }
    }

    public List<UserNumber> getUserNumbers() {
        return UserNumbers;
    }

}
