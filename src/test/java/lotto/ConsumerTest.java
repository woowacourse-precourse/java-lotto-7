package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.Consumer.converToNumber;
import static lotto.Consumer.validateCount;
import static lotto.Consumer.validateDuplicate;
import static lotto.Consumer.validateRange;
import static lotto.Consumer.validateSingleNumber;
import static lotto.Exception.DONT_NOT_ZERO;
import static lotto.Exception.DUPLICATE_WINNING_NUMBER;
import static lotto.Exception.IS_NOT_1000_UNIT;
import static lotto.Exception.NUMBER_RANGE;
import static lotto.Exception.SIX_WINNING_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ConsumerTest extends NsTest {
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1001"})
    void 구입금액_천원단위_테스트(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IS_NOT_1000_UNIT.getMessage())
        );
    }

    @Test
    void 구입금액_0원_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(DONT_NOT_ZERO.getMessage())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,4,5,6,7"})
    void 당첨번호_개수_테스트(String input) {
        List<Integer> winningNumbers = converToNumber(input);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validateCount(winningNumbers))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(SIX_WINNING_NUMBER.getMessage())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1,2,3,4,5,46"})
    void 당첨번호_범위_테스트(String input) {
        List<Integer> winningNumbers = converToNumber(input);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validateRange(winningNumbers))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NUMBER_RANGE.getMessage())
        );
    }

    @Test
    void convertToNumberTest() {
        //given
        String input = "1,2,3,4,5,6";

        //when
        List<Integer> winningNumbers = converToNumber(input);

        //then
        assertThat(winningNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,2,1,3,2,3"})
    void 당첨번호_중복_테스트(String input) {
        List<Integer> winningNumbers = converToNumber(input);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validateDuplicate(winningNumbers))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(DUPLICATE_WINNING_NUMBER.getMessage())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46"})
    void 보너스번호_범위_테스트(String bonusNumber) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validateSingleNumber(Integer.parseInt(bonusNumber)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NUMBER_RANGE.getMessage())
        );
    }
}
