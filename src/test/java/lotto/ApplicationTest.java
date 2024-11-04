package lotto;

import InputOutput.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 랜덤() {
        List<Integer> randomNumbers = InputView.random();

        // 숫자가 6개인지 확인
        assertEquals(6, randomNumbers.size());

        // 숫자가 1에서 45 사이인지 확인
        for (Integer number : randomNumbers) {
            assertTrue(number >= 1 && number <= 45);
        }

        // 유일한 숫자인지 확인
        assertEquals(randomNumbers.size(), randomNumbers.stream().distinct().count());
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
