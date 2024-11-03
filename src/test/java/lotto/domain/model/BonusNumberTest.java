package lotto.domain.model;

import lotto.domain.model.bonus.BonusNumber;
import lotto.exception.bonus.BonusErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BonusNumberTest {
    @Test
    @DisplayName("보너스 번호가 공백일 경우 예외가 발생한다.")
    void 보너스_번호가_공백일_경우_예외가_발생한다() {
        // given
        String invalidInput = " ";
        List<Integer> winningNumbers = List.of(8, 21, 15, 33, 40, 42);

        // when, then
        assertThatThrownBy(() -> new BonusNumber(invalidInput, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BonusErrorMessages.INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닐 경우 예외가 발생한다.")
    void 보너스_번호가_숫자가_아닐_경우_예외가_발생한다() {
        // given
        String invalidInput = "abc";
        List<Integer> winningNumbers = List.of(8, 21, 15, 33, 40, 42);

        // when, then
        assertThatThrownBy(() -> new BonusNumber(invalidInput, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BonusErrorMessages.INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 음수일 경우 예외가 발생한다.")
    void 보너스_번호가_음수일_경우_예외가_발생한다() {
        // given
        String invalidInput = "-5";
        List<Integer> winningNumbers = List.of(8, 21, 15, 33, 40, 42);

        // when, then
        assertThatThrownBy(() -> new BonusNumber(invalidInput, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BonusErrorMessages.INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 쉼표를 포함할 경우 예외가 발생한다.")
    void 보너스_번호가_쉼표를_포함할_경우_예외가_발생한다() {
        // given
        String invalidInput = "7,8";
        List<Integer> winningNumbers = List.of(8, 21, 15, 33, 40, 42);

        // when, then
        assertThatThrownBy(() -> new BonusNumber(invalidInput, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BonusErrorMessages.INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 1에서 45 범위를 벗어날 경우 예외가 발생한다.")
    void 보너스_번호가_범위를_벗어날_경우_예외가_발생한다() {
        // given
        String outOfRangeInput = "50";
        List<Integer> winningNumbers = List.of(8, 21, 15, 33, 40, 42);

        // when, then
        assertThatThrownBy(() -> new BonusNumber(outOfRangeInput, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BonusErrorMessages.OUT_OF_RANGE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    void 보너스_번호가_당첨_번호와_중복될_경우_예외가_발생한다() {
        // given
        String duplicateInput = "21";
        List<Integer> winningNumbers = List.of(8, 21, 15, 33, 40, 42);

        // when, then
        assertThatThrownBy(() -> new BonusNumber(duplicateInput, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BonusErrorMessages.DUPLICATE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("올바른 보너스 번호가 입력될 경우 정상적으로 생성된다.")
    void 올바른_보너스_번호가_입력될_경우_정상적으로_생성된다() {
        // given
        String validInput = "7";
        List<Integer> winningNumbers = List.of(8, 21, 15, 33, 40, 42);

        // when
        BonusNumber bonusNumber = new BonusNumber(validInput, winningNumbers);

        // then
        assertThat(bonusNumber.getNumber()).isEqualTo(7);
    }
}