package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UserNumbers {
    private final static int LOTTO_PRICE = 1000;

    private List<UserNumber> userNumbers;
    private int purchaseCount;

    public UserNumbers(int purchaseAmount) {
        validate(purchaseAmount);
        initField(purchaseAmount);
        makeUserNumbers();
    }

    private void validate(int num) {
        if (num % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 한 장 가격은" + LOTTO_PRICE + "원 입니다. 올바른 금액을 입력해주세요.");
        }
    }

    private void initField(int purchaseAmount) {
        purchaseCount = purchaseAmount / LOTTO_PRICE;
        userNumbers = new ArrayList<>();
    }

    private void makeUserNumbers() {
        int count = purchaseCount;
        while (count-- > 0) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userNumbers.add(new UserNumber(lottoNumber));
        }
    }

    public List<UserNumber> getUserNumbers() {
        return userNumbers;
    }

    public int getPurchaseAmount() {
        return purchaseCount * LOTTO_PRICE;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
