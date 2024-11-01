package lotto.domain.factory;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.lottos.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserMainLottoFactoryTest {


    @DisplayName("6자리 숫자가 같은지 확인")
    @Test
    void Lotto_객체_생성_확인() {
        UserMainLottoFactory factory = new UserMainLottoFactory();
        List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5, 6);
        String input = "1,2,3,4,5,6";
        boolean expected = true;

        Lotto lotto = factory.make(input);
        for (Integer i : inputNumbers) {
            if (!lotto.isContainNumber(i)) {
                expected = false;
            }
        }
        assertTrue(expected);

    }
}