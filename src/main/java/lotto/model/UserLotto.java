package lotto.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class UserLotto {
    private final List<List<Integer>> userLottoNumbers;

    public UserLotto(int purchaseAmount) {
        userLottoNumbers = new ArrayList<>();
        makeLottoNumber(purchaseAmount);
    }

    private void makeLottoNumber(int purchaseAmount) {
        while (purchaseAmount-- > 0) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userLottoNumbers.add(lottoNumber);
        }
    }
}
