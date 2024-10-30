package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinnerNumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @NullSource
    void 당첨번호에_빈_값이_입력되었다면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new WinningNumber(input);
                }).withMessageContaining("빈 값은 입력하실 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"^&", "1j"})
    void 당첨번호가_숫자로_변환되지_않는다면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new WinningNumber(input);
                }).withMessageContaining("숫자를 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46"})
    void 당첨번호가_일과_사십오_사이의_수가_아니라면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new WinningNumber(input);
                }).withMessageContaining("1 ~ 45 사이의 수를 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,4,5,6,7"})
    void 당첨번호가_여섯개의_서로_다른_수가_아니라면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new WinningNumber(input);
                })
                .withMessageContaining("6개의 서로 다른 수를 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @NullSource
    void 보너스번호에_빈_값이_입력되었다면_예외가_발생한다(String input) {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    winningNumber.makeBonusNumber(input);
                }).withMessageContaining("빈 값은 입력하실 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"^&", "1j"})
    void 보너스번호가_숫자로_변환되지_않는다면_예외가_발생한다(String input) {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    winningNumber.makeBonusNumber(input);
                }).withMessageContaining("숫자를 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46"})
    void 보너스번호가_일과_사십오_사이의_수가_아니라면_예외가_발생한다(String input) {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    winningNumber.makeBonusNumber(input);
                }).withMessageContaining("1 ~ 45 사이의 수를 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void 보너스번호가_당첨번호에_있는_수라면_예외가_발생한다(String input) {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    winningNumber.makeBonusNumber(input);
                }).withMessageContaining("당첨 번호에 없는 보너스 번호를 입력하셔야 합니다.");
    }
}
