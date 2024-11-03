package lotto.domain.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.exception.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseTotalPriceTest {

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @ParameterizedTest
        @ValueSource(strings = {"1000", "2000", "3000", "15000"})
        @DisplayName("유효한 문자열이 주어질 경우 PurchaseAmount 객체를 생성한다.")
        public void 유효한_입력으로_PurchaseAmount_생성(String input) {
            PurchaseTotalPrice purchaseTotalPrice = PurchaseTotalPrice.from(input);
            assertThat(purchaseTotalPrice.totalPrice()).isEqualTo(Integer.parseInt(input));
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @Test
        @DisplayName("한도를 초과하는 금액이 주어질 경우 예외를 발생시킨다.")
        public void 한도초과입력() {
            String input = "100000001";
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> PurchaseTotalPrice.from(input))
                    .withMessage(EXCEEDS_LIMIT.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"-1000"})
        @DisplayName("음수가 주어질 경우 예외를 발생시킨다.")
        public void 음수입력(String input) {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> PurchaseTotalPrice.from(input))
                    .withMessage(NOT_NEGATIVE.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"0"})
        @DisplayName("0이 주어질 경우 예외를 발생시킨다.")
        public void 제로입력(String input) {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> PurchaseTotalPrice.from(input))
                    .withMessage(NOT_ZERO.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1500", "2500", "3500", "4500"})
        @DisplayName("단위의 배수가 아닌 금액이 주어질 경우 예외를 발생시킨다.")
        public void 단위배수가_아닌_입력(String input) {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> PurchaseTotalPrice.from(input))
                    .withMessage(NOT_MULTIPLE_OF_UNIT.getMessage());
        }
    }
}
