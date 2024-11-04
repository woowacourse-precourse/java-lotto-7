package lotto.lottoMachine.undoPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.lottoMachine.lottoPurchaseAmount.LottoPurchaseAmountValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseAmountTest {
    private String lottoPurchaseAmount;
    private LottoPurchaseAmountValidator lottoPurchaseAmountValidator;

    @BeforeEach
    void setUp() {
        lottoPurchaseAmountValidator = new LottoPurchaseAmountValidator();
    }

    @DisplayName("로또 구입 금액이 숫자 형식이 아니라면 유효성 검사가 실패해야 한다.")
    @Test
    void 로또_구입_금액이_숫자_형식이_아니라면_유효성_검사가_실패해야_한다() {
        // Given
        lottoPurchaseAmount = "one thousand";

        // When
        boolean isValid = lottoPurchaseAmountValidator.validateAllThing(lottoPurchaseAmount);

        // Then
        assertThat(isValid).isFalse();
    }

    @DisplayName("로또 구입 금액이 오만원을 초과한다면 유효성 검사가 실패해야 한다.")
    @Test
    void 로또_구입_금액이_오만원을_초과한다면_유효성_검사가_실패해야_한다() {
        // Given
        lottoPurchaseAmount = "100000";

        // When
        boolean isValid = lottoPurchaseAmountValidator.validateAllThing(lottoPurchaseAmount);

        // Then
        assertThat(isValid).isFalse();
    }

    @DisplayName("로또 구입 금액이 천원 미만이라면 유효성 검사가 실패해야 한다.")
    @Test
    void 로또_구입_금액이_천원_미만이라면_유효성_검사가_실패해야_한다() {
        // Given
        lottoPurchaseAmount = "0";

        // When
        boolean isValid = lottoPurchaseAmountValidator.validateAllThing(lottoPurchaseAmount);

        // Then
        assertThat(isValid).isFalse();
    }

    @DisplayName("로또 구입 금액이 천원 단위가 아니라면 유효성 검사가 실패해야 한다.")
    @Test
    void 로또_구입_금액이_천원_단위가_아니라면_유효성_검사가_실패해야_한다() {
        // Given
        lottoPurchaseAmount = "5500";

        // When
        boolean isValid = lottoPurchaseAmountValidator.validateAllThing(lottoPurchaseAmount);

        // Then
        assertThat(isValid).isFalse();
    }

    @DisplayName("로또 구입 금액이 유효한 경우 유효성 검사가 성공해야 한다.")
    @Test
    void 로또_구입_금액이_유효한_경우_유효성_검사가_성공해야_한다() {
        // Given
        lottoPurchaseAmount = "5000"; // 숫자 형식, 1,000원 이상 50,000원 이하, 1,000원 단위

        // When
        boolean isValid = lottoPurchaseAmountValidator.validateAllThing(lottoPurchaseAmount);

        // Then
        assertThat(isValid).isTrue();
    }
}
