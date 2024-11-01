package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningNumbersTest {
    @Test
    @DisplayName("당첨 번호가 6개가 아닐 경우 예외가 발생한다.")
    void 당첨_번호_6개_아닐_경우_예외가_발생한다() {
        // given
        String invalidNumbers = "1,2,3,4,5"; /

        // when, then
        assertThatThrownBy(() -> new WinningNumbers(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호가 양수가 아닐 경우 예외가 발생한다.")
    void 당첨_번호_양수_아닐_경우_예외가_발생한다() {
        // given
        String negativeNumbers = "-1,2,3,4,5,6"; // -1은 양수가 아님

        // when, then
        assertThatThrownBy(() -> new WinningNumbers(negativeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있을 경우 예외가 발생한다.")
    void 당첨_번호_중복_숫자_예외가_발생한다() {
        // given
        String duplicateNumbers = "1,2,3,4,5,5";

        // when, then
        assertThatThrownBy(() -> new WinningNumbers(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("당첨 번호 범위가 벗어날 경우 예외가 발생한다.")
    void 당첨_번호_범위가_벗어날_경우_예외가_발생한다() {
        // given
        String outOfRangeNumbers = "0,2,3,4,5,6";

        // when, then
        assertThatThrownBy(() -> new WinningNumbers(outOfRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호의 구분자가 쉼표(,)가 아닐 경우 예외가 발생한다.")
    void 당첨_번호_구분자가_쉼표_아닐_경우_예외가_발생한다() {
        // given
        String invalidDelimiter = "1;2;3;4;5;6"; // 세미콜론(;) 사용

        // when, then
        assertThatThrownBy(() -> new WinningNumbers(invalidDelimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 쉼표(,)로 구분되어야 합니다.");
    }

    @Test
    @DisplayName("입력된 문자열에 공백이 있을 경우 예외가 발생한다.")
    void 입력된_문자열에_공백이_있을_경우_예외가_발생한다() {
        // given
        String numbersWithWhitespace = "1, 2,3,4,5,6"; // "1, 2"에 공백 있음

        // when, then
        assertThatThrownBy(() -> new WinningNumbers(numbersWithWhitespace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호에 공백이 없어야 합니다.");
    }

    @Test
    @DisplayName("올바른 형식의 당첨 번호가 입력될 경우 정상적으로 생성된다.")
    void 당첨_번호_정상_생성() {
        // given
        String correctNumbers = "8,21,15,33,40,42";

        // when
        WinningNumbers winningNumbers = new WinningNumbers(correctNumbers);

        // then
        assertThat(winningNumbers.getNumbers()).containsExactlyInAnyOrder(8, 21, 15, 33, 40, 42);
    }
}