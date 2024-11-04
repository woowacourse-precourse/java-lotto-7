package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"\n", "", "\t", "\r\n"})
    @DisplayName("당첨 번호가 비어있으면 예외가 발생한다.")
    void validateWinningNumbersIsNotEmpty(String condition) {
        assertThatThrownBy(() -> WinningNumbers.from(condition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 비어있을 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1;2;3", "1a2a3", "1.2.3"})
    @DisplayName("당첨 번호의 구분자가 쉼표가 아니면 예외가 발생한다.")
    void validateWinningNumbersDelimiter(String condition) {
        assertThatThrownBy(() -> WinningNumbers.from(condition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1,2,3", "1,2,3,4,5,6,7"})
    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    void validateWinningNumbersCount(String condition) {
        assertThatThrownBy(() -> WinningNumbers.from(condition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,1,2,3", "1,2,a,3,4,5", "0,1,5,7,8,||"})
    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    void validatePositiveWinningNumbers(String condition) {
        assertThatThrownBy(() -> WinningNumbers.from(condition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "1,2,3,50,100,500", "-1,2,3,4,5,6"})
    @DisplayName("당첨 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    void validateWinningNumbersInRange(String condition) {
        assertThatThrownBy(() -> WinningNumbers.from(condition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1~45 사이의 숫자만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,3,4,5", "1,1,1,1,2,2"})
    @DisplayName("당첨 번호가 중복되면 예외가 발생한다.")
    void validateUniqueWinningNumbers(String condition) {
        assertThatThrownBy(() -> WinningNumbers.from(condition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 중복될 수 없습니다.");
    }

    @Test
    void 당첨_번호가_정상적인_경우_테스트는_통과한다() {
        List<Integer> numbers = WinningNumbers.from("3,2,1,6,5,4").getNumbers();
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

}