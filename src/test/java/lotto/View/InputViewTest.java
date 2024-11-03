package lotto.View;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import lotto.DTO.PaymentPriceDTO;
import lotto.Util.Error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private final InputView inputView = new InputView();

    @DisplayName("구입 금액이 문자일 경우에는 NumberFormatException 예외를 발생시킨다.")
    @Test
    void 구입_금액이_문자열일_경우_예외가_발생한다() {
        String invalidInput = "예? 한장에 얼마라구요?";
        assertThatThrownBy(() -> inputView.validatePaymentPriceType(invalidInput))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_UNIT.getMessage());
    }

    @DisplayName("구입 금액이 Integer 범위를 벗어날 경우에는 IllegalArgumentException 예외를 발생시킨다.")
    @Test
    void 구입_금액이_Integer_범위를_벗어날_경우_예외가_발생한다() {
        String invalidInput = "9999999999999999";
        assertThatThrownBy(() -> inputView.validatePaymentPriceValue(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_LIMIT_REACHED.getMessage());
    }

    @DisplayName("구입 금액이 0이거나 음수일 경우에는 IllegalArgumentException 예외를 발생시킨다.")
    @Test
    void 구입_금액이_0이거나_음수일_경우_예외가_발생한다() {
        String invalidInput = "-1000";
        assertThatThrownBy(() -> inputView.validatePaymentPriceValue(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MINIMUM_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("구입 금액이 1000원 단위가 아닐 경우에는 ArithmeticException 예외를 발생시킨다.")
    @Test
    void 구입_금액이_1000원_단위가_아닐_경우_예외가_발생한다() {
        String invalidInput = "1500";
        assertThatThrownBy(() -> inputView.validatePaymentPriceValue(invalidInput))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_UNIT.getMessage());
    }

    @DisplayName("유효한 구입 금액 입력 시 PaymentPriceDTO 객체를 반환한다.")
    @Test
    void 유효한_구입_금액일_경우_PaymentPriceDTO_객체를_반환한다() {
        // Given
        String validInput = "3000\n";
        System.setIn(new ByteArrayInputStream(validInput.getBytes()));

        // When
        PaymentPriceDTO result = inputView.inputPaymentPrice();

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getPaymentPrice()).isEqualTo(3000);
    }
}
