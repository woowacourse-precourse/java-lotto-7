package lotto.view;

import lotto.Lotto;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void 숫자가_아닌_값을_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효한 숫자를 입력해 주세요.");
    }

    @DisplayName("유효한 구입 금액을 입력하면 해당 금액을 반환한다.")
    @Test
    void 유효한_구입_금액을_입력하면_해당_금액을_반환한다() {
        int amount = InputValidator.validatePurchaseAmount("3000");
        assertThat(amount).isEqualTo(3000);
    }

    @DisplayName("올바른 당첨 번호를 입력하면 당첨 번호 리스트를 반환한다.")
    @Test
    void 올바른_당첨_번호를_입력하면_리스트를_반환한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 번호가 1미만 또는 45초과일 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_1미만_또는_45초과일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 0, 3, 4, 5, 100)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호는 1부터 45 사이어야 합니다.");
    }

    @DisplayName("보너스 번호가 1미만 또는 45초과일 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_1미만_또는_45초과일_경우_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(0, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이어야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(1, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("빈 당첨 번호를 입력하면 예외가 발생한다.")
    @Test
    void 빈_당첨_번호를_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbersInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 비어 있을 수 없습니다. 올바른 번호를 입력해 주세요.");
    }

    @Test
    @DisplayName("잘못된 형식의 당첨 번호 입력 시 예외가 발생한다.")
    void testInvalidFormatWinningNumbers() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbersInput("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 형식이 잘못되었습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    void 보너스_번호가_숫자가_아니면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String input = "문자";
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 여러 개 입력되면 예외가 발생한다.")
    void 보너스_번호가_여러_개_입력되면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String input = "7,8";
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 하나의 숫자여야 합니다.");
    }
}