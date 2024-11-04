package lotto;

import lotto.controller.LottoPurchase;
import lotto.validation.Validation;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

class PurchaseTest {

    Validation validation = new Validation();

    @DisplayName("1000원 단위의 금액을 입력할 때 예외가 발생하지 않는다.")
    @Test
    void 금액이_1000원_단위일_때_예외가_발생하지_않는다() {
        assertThatCode(() -> validation.purchase("5000")).doesNotThrowAnyException();
        assertThatCode(() -> validation.purchase("1000")).doesNotThrowAnyException();
    }

    @DisplayName("금액이 1000원 단위가 아닐 때 예외가 발생한다.")
    @Test
    void 금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> validation.purchase("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 1000원 단위여야 합니다.");
        assertThatThrownBy(() -> validation.purchase("2500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 1000원 단위여야 합니다.");
    }

    @DisplayName("금액이 숫자가 아닌 형식일 때 예외가 발생한다.")
    @Test
    void 금액이_숫자가_아닌_형식이면_예외가_발생한다() {
        assertThatThrownBy(() -> validation.purchase("ABC"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 숫자 형식으로 입력해야 합니다.");
        assertThatThrownBy(() -> validation.purchase("1000원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 숫자 형식으로 입력해야 합니다.");
    }

    @DisplayName("로또 번호가 1~45 사이의 정수가 아닐 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> validation.number("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1부터 45 사이의 정수만 입력할 수 있습니다.");
        assertThatThrownBy(() -> validation.number("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1부터 45 사이의 정수만 입력할 수 있습니다.");
    }

    @DisplayName("로또 번호에 숫자가 아닌 값이 포함될 경우 예외가 발생한다.")
    @Test
    void 로또_번호에_숫자가_아닌_값이_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> validation.number("1, a, 3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력할 수 있습니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨번호와_중복되면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> validation.duplicatedBonous("3", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨번호와 중복입니다: 3");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않으면 예외가 발생하지 않는다.")
    @Test
    void 보너스_번호가_당첨번호와_중복되지_않으면_예외가_발생하지_않는다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> validation.duplicatedBonous("7", winningNumbers)).doesNotThrowAnyException();
    }
}
