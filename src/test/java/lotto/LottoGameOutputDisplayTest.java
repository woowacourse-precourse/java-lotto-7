package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashMap;
import java.util.List;
import lotto.display.LottoGameOutputDisplay;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoGameOutputDisplayTest extends NsTest {

    LottoGameOutputDisplay lottoGameOutputDisplay;

    @BeforeEach
    void initField() {
        lottoGameOutputDisplay = new LottoGameOutputDisplay();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 로또_출력() {
        // given
        Lotto lotto = new Lotto(List.of(34, 23, 22, 45, 1, 2));

        // when
        lottoGameOutputDisplay.printLotto(lotto);

        // then
        assertThat(output())
                .isEqualTo("[1, 2, 22, 23, 34, 45]");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0.0", "12.34:12.3", "98.76:98.8", "100:100.0"}, delimiter = ':')
    void 수익률_출력(double rateOfResult, String expect) {
        // when
        lottoGameOutputDisplay.printWinStatistics(new HashMap<>(), rateOfResult);

        // then
        assertThat(output())
                .contains(expect);
    }

    @Override
    protected void runMain() {
        // not use
    }
}
