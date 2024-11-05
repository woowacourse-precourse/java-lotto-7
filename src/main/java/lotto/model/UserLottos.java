package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enumMessage.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.USER_LOTTO_PRICE.getMessage());
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

    public Result countMatchingNumber(Lotto lotto, BonusNumber bonusNumber) {
        Result result = new Result();
        for (UserLotto userLotto : userLottos) {
            long matchingLottoCount = userLotto.getUserNumber().stream()
                    .filter(lotto.getNumbers()::contains)
                    .count();
            boolean hasBonusNumber = userLotto.getUserNumber().stream()
                    .anyMatch(num -> num.equals(bonusNumber.getNumber()));
            result.put(matchingLottoCount, hasBonusNumber);
        }
        return result;
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
