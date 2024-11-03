package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UserLottos {
    private final static int LOTTO_PRICE = 1000;

    private List<UserLotto> userLottos;
    private int purchaseCount;

    public UserLottos(int purchaseAmount) {
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
        userLottos = new ArrayList<>();
    }

    private void makeUserNumbers() {
        int count = purchaseCount;
        while (count-- > 0) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userLottos.add(new UserLotto(lottoNumber));
        }
    }

    public List<UserLotto> getUserNumbers() {
        return userLottos;
    }

    public int getPurchaseAmount() {
        return purchaseCount * LOTTO_PRICE;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
