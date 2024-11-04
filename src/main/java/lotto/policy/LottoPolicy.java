package lotto.policy;

import java.util.List;
import lotto.validator.Validator;

public class LottoPolicy {

    public void checkLottoPolicy(List<Integer> lotto) {
        // 로또의 숫자는 1에서 45 사이의 숫자여야한다.
        Validator.lottoShouldBeBetweenOneAndFortyFive(lotto);
        // 로또의 숫자는 중복 되어선 안된다.
        Validator.lottoShouldNotOverlap(lotto);
        // 로또의 숫자 개수는 6개여야 한다.
        Validator.lottoNumbersShouldBeSix(lotto);
        // 로또는 오름차순 정렬이 되어 있어야 한다.
        Validator.lottoShouldBeSortedInAscendingOrder(lotto);
    }
}
