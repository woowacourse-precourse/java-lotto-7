package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {
    @DisplayName("당첨 번호와 보너스 번호에 중복이 없을 때 객체 생성에 성공한다")
    @Test
    void 당첨_번호와_보너스_번호에_중복이_없을_때_객체_생성에_성공한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        new WinningNumbers(winningNumbers, bonusNumber);
    }

    @DisplayName("당첨 번호와 보너스 번호 사이에 중복이 있다면 예외가 발생한다")
    @Test
    void 당첨_번호와_보너스_번호_사이에_중복이_있다면_예외가_발생한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복이 있다면 예외가 발생한다")
    @Test
    void 당첨_번호에_중복이_있다면_예외가_발생한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 6, 6);
        int bonusNumber = 7;

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
