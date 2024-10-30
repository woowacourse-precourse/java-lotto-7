package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinnerNumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @NullSource
    void 빈_값이_입력되었다면_예외가_발생한다(String input){
        assertThatIllegalArgumentException()
                .isThrownBy(()->{
                    new WinningNumber(input);
                }).withMessageContaining("빈 값은 입력하실 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"^&", "1j"})
    void 숫자로_변환되지_않는다면_예외가_발생한다(String input){
        assertThatIllegalArgumentException()
                .isThrownBy(()->{
                    new WinningNumber(input);
                }).withMessageContaining("숫자를 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46"})
    void 일과_사십오_사이의_수가_아니라면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new WinningNumber(input);
                }).withMessageContaining("1 ~ 45 사이의 수를 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,4,5,6,7"})
    void 여섯개의_서로_다른_수가_아니라면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new WinningNumber(input);
                })
                .withMessageContaining("6개의 서로 다른 수를 입력하셔야 합니다.");
    }
}
