package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class UserInputConverterTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void negativeNumberException() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void undividedByThousand() {
        assertSimpleTest(() -> {
            runException("1234");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void notNumberInWinningNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "a|2,,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void notNumberInWinningNumbers2() {
        assertSimpleTest(() -> {
            runException("1000", ",,,,,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void notInRangeNumberInWinningNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "-2,1,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void notEnoughWinningNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "1,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void notUniqueNumbersInWinningNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "1,1,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void winningNumbersOverflowed() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7,8,9,10");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void winningNumbersOverflowed2() {
        assertSimpleTest(() -> {
            runException("1000", "1,1,1,1,1,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void winningNumbersAreNotSix() {
        assertSimpleTest(() -> {
            runException("1000", "1,1,1,1,1,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void winningNumberContainsBonusNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}