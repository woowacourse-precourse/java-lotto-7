package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoControllerTest {
	private final LottoPurchaseController lottoPurchaseController = new LottoPurchaseController();

	@Test
	@DisplayName("유효한 구매 금액이 입력된 경우 예외가 발생하지 않고 구매 금액이 반환된다.")
	void should_ReturnPurchasePrice_When_ValidPriceInput() {
		int purchasePrice = lottoPurchaseController.getValidatedPurchasePrice("5000");

		assertThat(purchasePrice).isEqualTo(5000);
	}

	@Test
	@DisplayName("구매 금액이 정수가 아닌 경우 예외가 발생한다.")
	void should_ThrowException_When_PurchasePriceIsNotInteger() {
		assertThatThrownBy(() -> lottoPurchaseController.getValidatedPurchasePrice("abc"))
				.isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 입력한 값이 정수가 아닙니다.");
	}

	@Test
	@DisplayName("구매 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
	void should_ThrowException_When_PurchasePriceNotDivisibleByThousand() {
		assertThatThrownBy(() -> lottoPurchaseController.getValidatedPurchasePrice("5500"))
				.isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
	}
}