package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.display.LottoGameInputDisplay;
import lotto.display.LottoGameOutputDisplay;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameInputDisplayTest extends NsTest {

    LottoGameInputDisplay lottoGameInputDisplay;

    @BeforeEach
    void initField() {
        lottoGameInputDisplay = new LottoGameInputDisplay(
                new LottoGameOutputDisplay()
        );
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 구입_금액_입력() {
        // given
        String input = "1000";

        // when
        run(input);
        int money = lottoGameInputDisplay.inputMoney();

        // then
        assertThat(money)
                .isEqualTo(1000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2,3 , 4 ,  5,6  "})
    void 당첨번호_입력(String input) {
        // when
        run(input);
        List<Integer> winNumbers = lottoGameInputDisplay.inputWinnerNumbers();

        // then
        assertThat(winNumbers)
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 보너스번호_입력() {
        // given
        String input = "7";
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        run(input);
        int bonus = lottoGameInputDisplay.inputBonusNumber(winNumbers);

        // then
        assertThat(bonus)
                .isEqualTo(7);
    }

    @Override
    protected void runMain() {
        // not use
    }
}
