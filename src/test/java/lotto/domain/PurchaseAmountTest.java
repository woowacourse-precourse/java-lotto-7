package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

  @DisplayName("정상적인 금액 입력 시 객체가 생성된다")
  @Test
  void 정상적인_금액_입력_시_객체가_생성된다() {
    BigDecimal amount = new BigDecimal("8000");
    PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
    assertEquals(amount, purchaseAmount.amount());
  }

  @DisplayName("1000원 이하 금액 입력 시 예외가 발생한다")
  @Test
  void 천원_이하_금액_입력_시_예외가_발생한다() {
    BigDecimal amount = new BigDecimal("500");
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new PurchaseAmount(amount);
    });
    assertEquals("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.", exception.getMessage());
  }

  @DisplayName("1,000원 단위로 나누어 떨어지지 않는 금액 입력 시 예외가 발생한다")
  @Test
  void 천원_단위로_나누어떨어지지_않는_금액_입력_시_예외가_발생한다() {
    BigDecimal amount = new BigDecimal("1300");
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new PurchaseAmount(amount);
    });
    assertEquals("[ERROR] 구입 금액은 1,000원 단위여야 합니다.", exception.getMessage());
  }

  @DisplayName("음수 금액 입력 시 예외가 발생한다")
  @Test
  void 음수_금액_입력_시_예외가_발생한다() {
    BigDecimal amount = new BigDecimal("-1000");
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new PurchaseAmount(amount);
    });
    assertEquals("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.", exception.getMessage());
  }
}
