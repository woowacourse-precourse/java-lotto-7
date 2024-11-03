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

    @Nested
    class 당첨_번호_검증 {
        @Test
        void 올바른_형식의_당첨_번호가_입력되면_성공한다() {
            assertThatCode(() -> inputValidator.validateWinningNumber("1,2,3,4,5,6"))
                    .doesNotThrowAnyException();
        }

        @Test
        void 중복된_번호가_있으면_예외가_발생한다() {
            assertThatThrownBy(() -> inputValidator.validateWinningNumber("1,1,2,3,4,5"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 당첨 번호가 중복되지 않게 입력해주세요.");
        }

        @ParameterizedTest
        @ValueSource(strings = {"1, 2,3,4,5,6", "1,2 ,3,4,5,6", "1,2,3, 4,5,6"})
        void 공백이_포함된_번호가_있으면_예외가_발생한다(String numbers) {
            assertThatThrownBy(() -> inputValidator.validateWinningNumber(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 오직 ,로만 당첨 번호를 구분해서 입력하시고 공백을 포함하지 말아주세요.");
        }

        @Test
        void 숫자가_아닌_문자가_포함되어_있으면_예외가_발생한다() {
            assertThatThrownBy(() -> inputValidator.validateWinningNumber("1,2,a,4,5,6"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 문자가 아닌 숫자를 입력해주세요.");
        }
    }

}