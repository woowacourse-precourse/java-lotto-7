package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 번호를 생성하는 클래스
 */
public class LottoGenerator {

    /**
     * 지정된 수량만큼의 로또 번호를 생성
     *
     * @param count 생성할 로또 수량
     * @return 생성된 로또 목록
     */
    public List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    /**
     * 하나의 로또 번호를 생성
     *
     * @return 생성된 로또 인스턴스
     */
    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}