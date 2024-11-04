package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.util.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoBonusNumberTest {

    private Lotto lotto;
    private InputValidator inputValidator;


    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), inputValidator);

    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2", "1,2,3"})
    void 보너스_번호에_한_개의_숫자를_입력하지_않으면_예외가_발생한다(String input) {
        예외_실행(input, lotto);
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "2000", "-2000", "999.9"})
    void 보너스_번호에_범위_외의_숫자를_입력하면_예외가_발생한다(String input) {
        예외_실행(input, lotto);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void 보너스_번호에_당첨_번호와_중복되는_숫자를_입력하면_예외가_발생한다(String input) {
        예외_실행(input, lotto);

    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\n"})
    void 보너스_번호를_입력할_때_비어있으면_예외가_발생한다(String input) {
        예외_실행(input, lotto);
    }


    void 예외_실행(String input, Lotto lotto) {
        assertThatThrownBy(() -> new LottoBonusNumber(input, lotto, inputValidator))
                .isInstanceOf(IllegalArgumentException.class);
    }

}