package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 자동으로 로또를 생성합니다.
 */
public class LottoGenerator {
    /**
     * 주어진 수량의 로또를 자동으로 생성합니다.
     * @param count 생성할 로또 수량
     * @return 로또 리스트
     */
    public static List<Lotto> getLottos(int count) {
        List<Lotto> result = new ArrayList<Lotto>(count);
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<Integer>();
            for (int num : Randoms.pickUniqueNumbersInRange(1, 45, 6)) {
                numbers.add(num);
            }
            numbers.sort((a, b) -> a.compareTo(b));
            result.add(new Lotto(numbers));
        }
        return result;
    }
}
