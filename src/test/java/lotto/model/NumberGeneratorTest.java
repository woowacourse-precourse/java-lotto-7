package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.model.winningNumber.NumberGenerator;
import lotto.model.winningNumber.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberGeneratorTest {
    private final WinningNumber defaultWinningNumber = new WinningNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "2:3", "3:4", "4:5", "5:6"}, delimiter = ':')
    void 당첨번호를_split해_순서대로_저장한다_1(int lottoNumbersIndex, int lottoNumber) {
        String testNumber = "1,2,3,4,5,6";
        WinningNumber winningNumber = NumberGenerator.registerWinningNumber(testNumber);

        assertThat(winningNumber.getNumbers().get(lottoNumbersIndex)).isEqualTo(lottoNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 5", "55$5", "$5 5", "5$5 ", "5 $ 5"})
    void 하나의_번호_중간에_다른_문자가_있으면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> NumberGenerator.registerWinningNumber(testNumber))
                .withMessage("[ERROR] 숫자값만 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" 45", "45 ", "    45", "45   "})
    void 번호와_번호_사이_띄어쓰기는_허용(String testNumber) {
        String defaultNumbers = "1,2,3,4,5,";
        assertThatCode(() -> NumberGenerator.registerWinningNumber(defaultNumbers + testNumber))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("여기서부턴 보너스번호에 관한 것")
    void 보너스번호를_저장한다() {
        String testNumber = "7";

        assertThatCode(() -> NumberGenerator.registerBonusNumber(testNumber, defaultWinningNumber))
                .doesNotThrowAnyException();
    }

    @Test
    void 보너스번호_당첨번호와_중복되면_예외() {
        String testNumber = "1";

        assertThatIllegalArgumentException().isThrownBy(
                        () -> NumberGenerator.registerBonusNumber(testNumber, defaultWinningNumber))
                .withMessage("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 값입니다.");
    }
}
