package lotto;

import lotto.exception.*;
import lotto.model.InputService;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 금액이 1000으로 나누어 떨어지지 않은 경우 예외가 발생한다.")
    void 구매_금액이_1000원으로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        String purchase = "10001";
        InputService inputService = new InputService();

        assertThatThrownBy(() -> inputService.validatePurchaseValue(purchase))
                .isInstanceOf(InvalidPurchaseAmountException.class)
                .hasMessage("[ERROR] 구입금액은 1000으로 나누어 떨어져야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 1보다 작은 경우 예외가 발생한다.")
    void 로또_번호가_1보다_작은_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 3, 0, 10, 20, 30)))
                .isInstanceOf(InvalidLottoNumberException.class)
                .hasMessage("[ERROR] 로또 번호는 1이상 45이하여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 45보다 큰 경우 예외가 발생한다.")
    void 로또_번호가_45보다_큰_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(InvalidLottoNumberException.class)
                .hasMessage("[ERROR] 로또 번호는 1이상 45이하여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호가 중복된 경우 예외가 발생한다.")
    void 당첨_번호가_중복된_경우_예외가_발생한다() {
        String winningNumber = "1,2,3,4,5,5\n";
        System.setIn(new ByteArrayInputStream(winningNumber.getBytes()));
        InputService inputService = new InputService();

        assertThatThrownBy(() -> inputService.winningNumbersValue())
                .isInstanceOf(InvalidDuplicateNumberException.class)
                .hasMessage("[ERROR] 당첨 번호가 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("번호 입력값이 숫자가 아닌 경우 예외가 발생한다.")
    void 번호_입력값이_숫자가_아닌_경우_예외가_발생한다() {
        String input = "aa";
        InputService inputService = new InputService();

        assertThatThrownBy(() -> inputService.convertToInt(input))
                .isInstanceOf(InvalidNumericException.class)
                .hasMessage("[ERROR] 잘못된 입력값입니다. 입력값은 숫자여야합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1개가 아닌 경우 예외가 발생한다.")
    void 보너스_번호가_1개가_아닌_경우_예외가_발생한다() {
        String bonusNumber = "12,2";
        System.setIn(new ByteArrayInputStream(bonusNumber.getBytes()));
        InputService inputService = new InputService();

        assertThatThrownBy(() -> inputService.bonusNumberValue())
                .isInstanceOf(InvalidBonusValueException.class)
                .hasMessage("[ERROR] 보너스 번호는 반드시 1개여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1보다 작은 경우 예외가 발생한다.")
    void 보너스_번호가_1보다_작은_경우_예외가_발생한다() {
        String bonusNumber = "0";
        System.setIn(new ByteArrayInputStream(bonusNumber.getBytes()));
        InputService inputService = new InputService();

        assertThatThrownBy(() -> inputService.bonusNumberValue())
                .isInstanceOf(InvalidBonusNumberException.class)
                .hasMessage("[ERROR] 보너스 번호는 1이상 45이하여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복된 경우 예외가 발생한다.")
    void 보너스_번호가_당첨_번호와_중복된_경우_예외가_발생한다() {
        String input = "1, 2, 3, 4, 5, 6\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputService inputService = new InputService();

        // 예외가 발생하는지 테스트
        assertThatThrownBy(() -> {
            List<Integer> winningNumbers = inputService.winningNumbersValue();  // 당첨 번호 입력 처리
            inputService.bonusNumberValue();  // 보너스 번호 입력 처리
        })
                .isInstanceOf(InvalidDuplicateBonusNumberException.class)
                .hasMessage("[ERROR] 보너스 번호가 당첨 번호와 중복될 수 없습니다.");
    }
}
