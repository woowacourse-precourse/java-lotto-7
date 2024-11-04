package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.validator.InputBonusWinningNumberValidator.validateBonusWinningNumber;
import static lotto.validator.InputBonusWinningNumberValidator.validateDuplicateBonusWinningNumber;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputBonusWinningNumberValidatorTest {

    @DisplayName("로또 번호 기준보다 낮은 번호를 입력 시 예외가 발생한다.")
    @Test
    void validateBonusWinningNumberWithLowNumber() {

        // given
        String inputBonusNumber = "0";

        // when, then
        assertThatThrownBy(() -> validateBonusWinningNumber(inputBonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호 기준보다 높은 번호를 입력 시 예외가 발생한다.")
    @Test
    void validateBonusWinningNumberWithHighNumber() {

        // given
        String inputBonusNumber = "46";

        // when, then
        assertThatThrownBy(() -> validateBonusWinningNumber(inputBonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("숫자 하나 이외의 입력이 들어왔을 경우, 예외가 발생한다.")
    @Test
    void validateBonusWinningNumberContainsCharacter() {

        // given
        String inputBonusNumber = "1d";

        // when, then
        assertThatThrownBy(() -> validateBonusWinningNumber(inputBonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 보너스 번호는 숫자 하나만 입력해 주세요.");
    }


    @DisplayName("기존 번호와 보너스 번호가 중복인경우, 예외를 발생한다.")
    @Test
    void validateDuplicateBonusWinningNumbers() {

        // given
        Set<Integer> inputWinningNumbers = new HashSet<>(List.of(1, 2, 3, 4, 5, 6));
        String inputBonusNumber = "1";

        // when, then
        assertThatThrownBy(() -> validateDuplicateBonusWinningNumber(inputBonusNumber, inputWinningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 보너스 번호는 기존의 당첨 번호들과 중복일 수 없습니다.");
    }
}