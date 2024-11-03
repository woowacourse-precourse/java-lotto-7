package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lottoPurchaseAmount.LottoPurchaseAmountValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaseAmountTest {
    private String lottoPurchaseAmount;
    private LottoPurchaseAmountValidator lottoPurchaseAmountValidator;

    @BeforeEach
    void setUp() {
        lottoPurchaseAmountValidator = new LottoPurchaseAmountValidator();
    }

    @DisplayName("로또 구입 금액이 숫자 형식이 아니라면 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_숫자_형식이_아니라면_예외가_발생한다() {
        // Given&When
        lottoPurchaseAmount = "one thousand";

        // Then
        assertThatThrownBy(() -> lottoPurchaseAmountValidator.validateAllThing(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 오만원을 초과한다면 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_오만원을_초과한다면_예외가_발생한다() {
        // Given&When
        lottoPurchaseAmount = "100000";

        // Then
        assertThatThrownBy(() -> lottoPurchaseAmountValidator.validateAllThing(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 천원단위가 아니라면 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_천원단위가_아니라면_예외가_발생한다() {
        // Given&When
        lottoPurchaseAmount = "5500";

        // Then
        assertThatThrownBy(() -> lottoPurchaseAmountValidator.validateAllThing(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
