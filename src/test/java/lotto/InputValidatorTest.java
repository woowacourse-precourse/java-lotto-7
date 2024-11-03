package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Nested
    class 로또_구입_금액_검증 {
        @Test
        void 천원_단위의_올바른_금액이_입력되면_성공한다() {
            //given
            String amount = "2000";

            //when & then
            assertThatCode(() -> inputValidator.validateBuyLotto(amount))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = {"1500", "999", "0", "-1000"})
        void 천원_단위가_아닌_금액이_입력되면_예외가_발생한다(String amount) {
            assertThatThrownBy(() -> inputValidator.validateBuyLotto(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 구입 금액은 1000원 단위로 입력해주세요.");
        }

        @Test
        void 숫자가_아닌_문자가_입력되면_예외가_발생한다() {
            assertThatThrownBy(() -> inputValidator.validateBuyLotto("abc"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 문자가 아닌 숫자를 입력해주세요.");
        }
    }

}