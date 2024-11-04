package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.InputValidator;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String DELIMITER = ",";
    @Test
    void 당첨_번호_목록에_쉼표도_아니고_숫자도_아닌_문자가_포함된_경우() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_로또_번호의_숫자_범위를_벗어나는_경우() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_중복된_경우() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(13, 13, 20, 24, 27, 41));
        assertThatThrownBy(() -> InputValidator.validateUniqueWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_6개가_아닌_경우() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_목록에_쉼표가_연속해서_등장하는_경우() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1,,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_당첨_번호들은_예외를_발생시키지_않는다() {
        assertSimpleTest(() -> {
            // given
            List<Integer> uniqueNumbersInRange = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
            WinningNumbers winningNumbers = WinningNumbers.from(uniqueNumbersInRange);

            // 당첨 번호들이 포함된 문자열은 2자리 이하의 숫자 6개를 ,로 연결한 형태인지
            StringJoiner sj = new StringJoiner(DELIMITER);
            uniqueNumbersInRange.forEach(lotto -> sj.add(lotto.toString()));
            assertThatCode(() -> InputValidator.validateWinningNumbers(sj.toString())).doesNotThrowAnyException();

            // 중복된 당첨 번호가 없는지
            assertThatCode(() -> InputValidator.validateUniqueWinningNumbers(uniqueNumbersInRange)).doesNotThrowAnyException();

            // 당첨 번호들이 범위 내에 있는지
            assertThatCode(() -> InputValidator.validateWinningNumber(winningNumbers.get(0))).doesNotThrowAnyException();
            assertThatCode(() -> InputValidator.validateWinningNumber(winningNumbers.get(1))).doesNotThrowAnyException();
            assertThatCode(() -> InputValidator.validateWinningNumber(winningNumbers.get(2))).doesNotThrowAnyException();
            assertThatCode(() -> InputValidator.validateWinningNumber(winningNumbers.get(3))).doesNotThrowAnyException();
            assertThatCode(() -> InputValidator.validateWinningNumber(winningNumbers.get(4))).doesNotThrowAnyException();
            assertThatCode(() -> InputValidator.validateWinningNumber(winningNumbers.get(5))).doesNotThrowAnyException();
        });
    }
}
