package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {
    @Test
    void createLotto() {
        String expected = new Lotto(List.of(8, 21, 23, 41, 42, 43)).numbersToString();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoController lottoController = new LottoController();
                    assertThat(lottoController.createLotto().numbersToString()).isEqualTo(expected);
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }
}