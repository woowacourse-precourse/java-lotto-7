package policy;

import java.util.Collections;
import java.util.List;

public class LottoPolicyImpl implements LottoPolicy {

    @Override
    public void checkLottoPolicy(List<Integer> lotto) {
        // 로또의 숫자는 1에서 45 사이의 숫자여야한다.
        lottoShouldBeBetweenOneAndFortyFive(lotto);
        // 로또의 숫자는 중복 되어선 안된다.
        lottoShouldNotOverlap(lotto);
        // 로또의 숫자 개수는 6개여야 한다.
        lottoNumbersShouldBeSix(lotto);
        // 로또는 오름차순 정렬이 되어 있어야 한다.
        lottoShouldBeSortedInAscendingOrder(lotto);

    }

    private void lottoShouldBeBetweenOneAndFortyFive(List<Integer> lotto) {
        for (Integer lottoNumber : lotto) {
            if (!(1 <= lottoNumber && lottoNumber <= 45)) {
                throw new IllegalArgumentException("[ERROR] 로또 숫자의 범위가 1에서 45 사이를 초과 했습니다."); // TODO: 에러 메세지 작성
            }
        }
    }

    private void lottoShouldNotOverlap(List<Integer> lotto) {
        for (Integer lottoNumber : lotto) {
            if (Collections.frequency(lotto, lottoNumber) > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 숫자가 중복되었습니다."); // TODO: 에러 메세지 작성
            }
        }
    }

    private void lottoNumbersShouldBeSix(List<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 숫자가 6개를 초과했습니다."); // TODO: 에러 메세지 작성
        }
    }

    private void lottoShouldBeSortedInAscendingOrder(List<Integer> lotto) {
        Integer value = 0;
        for (Integer lottoNumber : lotto) {
            if (lottoNumber <= value) {
                throw new IllegalArgumentException("[ERROR] 로또가 오름차순 정렬이 되어있지 않습니다."); // TODO: 에러 메세지 작성
            }
        }
    }
}
