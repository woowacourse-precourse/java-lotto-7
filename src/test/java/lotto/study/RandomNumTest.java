package lotto.study;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomNumTest {
    @Test
    void sortingTest() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(integers);
        System.out.println(lotto.getNumbers());
    }
}
