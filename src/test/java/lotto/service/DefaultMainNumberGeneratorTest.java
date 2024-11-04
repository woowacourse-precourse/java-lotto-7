package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import lotto.common.Exceptions;
import lotto.model.winningNumber.MainNumber;
import lotto.service.winningNumber.DefaultNumberGenerator;
import lotto.service.winningNumber.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DefaultMainNumberGeneratorTest {
    private final NumberGenerator numberGenerator = new DefaultNumberGenerator();

    @Test
    @DisplayName("[success] 당첨번호를 split해 순서대로 저장하여 MainNumber를 생성한다.")
    void splitAndcreateMainNumber() {
        String testNumbers = "1,2,3,4,5,6";

        MainNumber mainNumber = numberGenerator.registerMainNumber(testNumbers);
        List<Integer> mainNumberList = mainNumber.numbers();

        for (int i = 0; i < 6; i++) {
            int expectedMainNumber = i + 1;
            assertThat(mainNumberList.get(i)).isEqualTo(expectedMainNumber);
        }
    }

    @ParameterizedTest
    @DisplayName("[success] 당첨번호와 번호 사이의 띄어쓰기는 무시한다.")
    @ValueSource(strings = {" 45", "45 ", "    45", "45   "})
    void success_WhenBlankExistsBetweenNumberAndNumber(String numberWithBlank) {
        String testNumber = "1,2,3,4,5," + numberWithBlank;
        assertThatCode(() -> numberGenerator.registerMainNumber(testNumber))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("[fail] 하나의 번호 중간에 띄어쓰기 또는 숫자가 아닌 문자가 있으면 예외가 발생한다.")
    @ValueSource(strings = {"3 3", "33 3", "3   3", "3@3", "33@3", "3 @ 3"})
    void fail_IfNonIntegerExistsInsideNumber(String numberWithNonInteger) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> numberGenerator.registerMainNumber(numberWithNonInteger))
                .withMessage(Exceptions.NOT_POSITIVE_INTEGER.getMessage());
    }
}
