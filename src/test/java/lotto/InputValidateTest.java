package lotto;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.view.input.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class InputValidateTest {

    @DisplayName("입력값이 정상적으로 들어가는지 확인하는 테스트 코드")
    @Test
    void 입력값_테스트(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThat(lotto.getNumbers()).containsExactlyElementsOf(expectedNumbers);
    }

    @DisplayName("구입 금액이 유효한 경우 예외가 발생하지 않아야 한다.")
    @Test
    void 유효한_구입_금액_입력() {
        int amount = InputValidator.validatePurchaseAmount("1000");
        assertThat(amount).isEqualTo(1000);
    }

    @DisplayName("구입 금액이 1000원 미만일 경우 예외가 발생해야 한다.")
    @Test
    void 구입_금액_1000원_미만_예외() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생해야 한다.")
    @Test
    void 구입_금액_1000으로_나누어떨어지지_않음_예외() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자가 아닐 경우 예외가 발생해야 한다.")
    @Test
    void 구입_금액_숫자가_아님_예외() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("보너스 번호 입력이 정수로 들어오지 않으면 예외가 발생")
    @Test
    void 유효하지_않은_보너스_번호_입력() {
        assertThatThrownBy(() -> InputValidator.validateNumber("ab"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}