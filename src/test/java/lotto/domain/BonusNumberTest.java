package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"\n", "", "\t", "\r\n"})
    @DisplayName("보너스 번호가 비어있으면 예외가 발생한다.")
    void validateWinningNumbersIsNotEmpty(String condition) {
        assertThatThrownBy(() -> BonusNumber.of(Collections.emptyList(), condition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 비어있을 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "-", ";"})
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    void validateBonusNumberIsNumeric(String condition) {
        assertThatThrownBy(() -> BonusNumber.of(Collections.emptyList(), condition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46"})
    @DisplayName("보너스 번호가 1~45 사이가 아니면 예외가 발생한다.")
    void validateBonusNumberInRange(String condition) {
        assertThatThrownBy(() -> BonusNumber.of(Collections.emptyList(), condition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1~45 사이의 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    void validateUniqueBonusAndWinningNumbers() {
        List<Integer> winningNumbers = WinningNumbers.from("1,2,3,4,5,6").getNumbers();
        assertThatThrownBy(() -> BonusNumber.of(winningNumbers, "6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
    }

    @Test
    void 보너스_번호가_정상적인_경우_테스트는_통과한다() {
        List<Integer> winningNumbers = WinningNumbers.from("1,2,3,4,5,6").getNumbers();
        int bonusNumber = BonusNumber.of(winningNumbers, "7").getBonusNumber();
        assertThat(bonusNumber).isEqualTo(7);
    }

}