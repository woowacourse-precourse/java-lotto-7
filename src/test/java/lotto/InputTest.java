package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;


class InputTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void duplicate_winning_numbers() {
        runException("1000", "1,2,3,4,5,5");
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
