package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomizerTest {
    @DisplayName("무작위로 생성한 6개의 번호를 오름차 순으로 반환한다.")
    @Test
    void 로또_번호_생성_기능_반환값_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Integer> randomNumbers = Randomizer.getRandomLottoNumbers();
                    assertEquals(List.of(1, 2, 3, 4, 5, 6), randomNumbers);
                },
                List.of(2, 1, 6, 3, 5, 4)
        );
    }
}
