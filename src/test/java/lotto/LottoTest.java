package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호에 양수가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_양수가_아닌_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위에 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_범위에_벗어난_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void 로또_구매_금액이_1000원_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoGenerator().generateLottos(500))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("로또 구매 금액이 음수로 입력되면 예외 발생")
    @Test
    void 로또_구매_금액이_음수인_경우_예외발생() {
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.testValidateAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 음수로 입력되면 예외 발생")
    @Test
    void 로또_구매_금액이_천원_단위가_아닌_경우_예외발생() {
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.testValidateAmount("2500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 문자로 입력되면 예외 발생")
    @Test
    void 로또_구매_금액이_문자인_경우_예외발생() {
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.testValidateAmount("m"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 음수인 경우 예외 발생")
    @Test
    void 당첨_번호가_음수인_경우_예외발생() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, -6);
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.testValidateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 범위에 벗어난 경우 예외 발생")
    @Test
    void 당첨_번호가_범위에_벗어난_경우_예외발생() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.testValidateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 6자리를 초과하는 경우 예외 발생")
    @Test
    void 당첨_번호가_6자리를_초과하는_경우_예외발생() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.testValidateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 숫자가 아닌 문자를 입력하는 경우 예외 발생")
    @Test
    void 당첨_번호에_숫자가_아닌_문자를_입력하는_경우_예외발생() {
        InputView inputView = new InputView();
        String invalidInput = "1,2,3,a,5,6";

        assertThatThrownBy(() -> inputView.testParseWinningNumbers(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외 발생")
    @Test
    void 보너스_번호가_중복되는_경우_예외발생() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.testValidateBonusNumber("1", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 음수인 경우 예외 발생")
    @Test
    void 보너스_번호가_음수인_경우_예외발생() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.testValidateBonusNumber("-1", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45보다 큰 경우 예외 발생")
    @Test
    void 보너스_번호가_45보다_큰_경우_예외발생() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.testValidateBonusNumber("46", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 적절하지 않은 경우 예외 발생")
    @Test
    void 보너스_번호가_적절하지_않은_경우_예외발생() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.testValidateBonusNumber("b", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
