package lotto.util.validator;

import lotto.exception.MoneyError;
import lotto.exception.MoneyException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

class MoneyValidatorTest {

    @ParameterizedTest(name = "({index}) {0}")
    @ValueSource(longs = {
            1000L, 12345000L
    })
    @DisplayName("<Success Test>")
    void 올바른_금액이_입력될_경우_정상_종료된다(
            // given
            long givenMoneyAmount
    ) {
        // when & then
        assertThatCode(() -> MoneyValidator.validate(givenMoneyAmount))
                .doesNotThrowAnyException();
    }

    @Nested
    @DisplayName("<Fail Test>")
    class 실패_테스트 {
        @ParameterizedTest(name = "({index}) {0}")
        @ValueSource(longs = {
                1001, 123001, 999, 1, 10, 100
        })
        @DisplayName("1000원으로 나누어 떨어지지 않을 경우, 예외가 발생한다.")
        void 잘못된_단위의_금액이_입력될_경우_예외가_발생된다(
                // given
                long givenNumber
        ) {
            // when & then
            assertThatCode(() -> MoneyValidator.validate(givenNumber))
                    .isInstanceOf(MoneyException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageStartingWith("[ERROR]")
                    .hasMessageContaining(MoneyError.NOT_DIVISIBLE_TO_THOUSAND.getMessage());
        }

    }
}