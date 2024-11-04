package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ErrorCode;
import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("보너스 번호가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_숫자가_아닐_경우_예외가_발생한다() {
        Lotto mainNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningNumbers(mainNumbers, "abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LOTTO_NUMBERS_NOT_A_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 메인 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_메인_번호와_중복될_경우_예외가_발생한다() {
        Lotto mainNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningNumbers(mainNumbers, "5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LOTTO_NUMBERS_DUPLICATED.getMessage());
    }

    @DisplayName("보너스 번호가 범위를 초과할 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위를_초과할_경우_예외가_발생한다() {
        Lotto mainNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningNumbers(mainNumbers, "51"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 범위 미달일 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위_미달일_경우_예외가_발생한다() {
        Lotto mainNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningNumbers(mainNumbers, "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("유효한 메인 번호와 보너스 번호로 WinningNumbers 객체를 생성한다.")
    @Test
    void 유효한_메인_번호와_보너스_번호로_WinningNumbers_객체를_생성한다() {
        Lotto mainNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(mainNumbers, "7");
        assertThat(winningNumbers.containsNumber(new Lotto(List.of(7, 8, 9, 10, 11, 12)))).isTrue();
    }

    @DisplayName("로또와 당첨 번호의 일치 수를 계산한다.")
    @Test
    void 로또와_당첨_번호의_일치_수를_계산한다() {
        Lotto mainNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(mainNumbers, "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        assertThat(winningNumbers.countMatchingNumbers(lotto)).isEqualTo(3);
    }
}
