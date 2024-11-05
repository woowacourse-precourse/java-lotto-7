package lotto.policy;

import java.util.List;
import lotto.validator.Validator;

public class LottoPolicy {
    public void checkLottoPolicy(List<Integer> lotto) {
        Validator.lottoShouldBeBetweenOneAndFortyFive(lotto);
        Validator.lottoShouldNotOverlap(lotto);
        Validator.lottoNumbersShouldBeSix(lotto);
        Validator.lottoShouldBeSortedInAscendingOrder(lotto);
    }
}
