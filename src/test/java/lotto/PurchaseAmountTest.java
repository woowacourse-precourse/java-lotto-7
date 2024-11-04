package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.validation.PurchaseAmountValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
  private final PurchaseAmountValidation purchaseAmount = new PurchaseAmountValidation();


  @DisplayName("정상적인 값을 넣었을시")
  @Test
  void 구입_금액이_올바르면_예외가_발생하지않는다() {
    purchaseAmount.validatePurchaseAmount("2000"); // 예외가 발생하지 않으면 테스트 통과
  }
  @DisplayName("구매금액에 음수가 있을시 예외발생한다")
  @Test
  void 구매금맥에_음수가_있을시_예외발생() {
    boolean isValid = purchaseAmount.validatePurchaseAmount("-1");
    assertThat(isValid).isFalse(); // 예외 발생, 유효하지 않으므로 false 반환
  }
  @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
  @Test
  void 구매금액이_1000단위가_아닐시_예외발생() {
    boolean isValid = purchaseAmount.validatePurchaseAmount("1500");
    assertThat(isValid).isFalse(); // 예외 발생, 유효하지 않으므로 false 반환
  }
}
