package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserNumbers {
    private List<UserNumber> userNumbers;
    private int purchaseCount;

    public UserNumbers(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        initField(purchaseAmount);
        makeUserNumbers();
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 한 장 가격은 1000원 입니다. 올바른 금액을 입력해주세요.");
        }
    }

    private void initField(int purchaseAmount) {
        purchaseCount = purchaseAmount / 1000;
        userNumbers = new ArrayList<>();
    }

    private void makeUserNumbers() {
        int count = purchaseCount;
        while (count-- > 0) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumber.sort(Comparator.naturalOrder());
            userNumbers.add(new UserNumber(lottoNumber));
        }
    }

    public List<UserNumber> getUserNumbers() {
        return userNumbers;
    }

    public int getPurchaseAmount() {
        return purchaseCount * 1000;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
