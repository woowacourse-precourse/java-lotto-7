package lotto;

import convert.SingleStringToNumConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validate.LottoPurchaseAmountValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaseAmountTest {
    private String lottoPurchaseAmount;
    private SingleStringToNumConverter stringToIntConverter;
    private LottoPurchaseAmountValidator lottoPurchaseAmountValidator;

    @DisplayName("로또 구입 금액이 숫자 형식이 아니라면 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_숫자_형식이_아니라면_예외가_발생한다() {
        // Given
        lottoPurchaseAmount = "one thousand";
        stringToIntConverter = new SingleStringToNumConverter(lottoPurchaseAmount);

        // When
        lottoPurchaseAmountValidator = new LottoPurchaseAmountValidator(lottoPurchaseAmount);

        // Then
        assertThatThrownBy(() -> lottoPurchaseAmountValidator.validateAllThing())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 오만원을 초과한다면 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_오만원을_초과한다면_예외가_발생한다() {
        // Given
        lottoPurchaseAmount = "100000";
        stringToIntConverter = new SingleStringToNumConverter(lottoPurchaseAmount);

        // When
        lottoPurchaseAmountValidator = new LottoPurchaseAmountValidator(lottoPurchaseAmount);

        // Then
        assertThatThrownBy(() -> lottoPurchaseAmountValidator.validateAllThing())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 천원단위가 아니라면 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_천원단위가_아니라면_예외가_발생한다() {
        // Given
        lottoPurchaseAmount = "5500";
        stringToIntConverter = new SingleStringToNumConverter(lottoPurchaseAmount);

        // When
        lottoPurchaseAmountValidator = new LottoPurchaseAmountValidator(lottoPurchaseAmount);

        // Then
        assertThatThrownBy(() -> lottoPurchaseAmountValidator.validateAllThing())
                .isInstanceOf(IllegalArgumentException.class);
    }

}
