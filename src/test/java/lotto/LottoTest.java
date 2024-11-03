package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @DisplayName("로또 번호가 정상적으로 생성되는지 확인한다.")
    @Test
    void 로또_번호가_정상적으로_생성된다() {
        Lotto lotto = new Lotto();
        List<Integer> numbers = lotto.getNumbers();
        // 1부터 45 사이의 숫자여야 하며, 6개의 숫자가 있어야 한다.
        assertEquals(6, numbers.size());
        for (int number : numbers) {
            assertThatThrownBy(() -> {
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
            }).doesNotThrowAnyException();
        }
    }

    @DisplayName("당첨 번호 입력시 유효성 검사")
    @Test
    void 당첨번호_입력시_유효성_검사() {
        assertThatThrownBy(() -> {
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5); // 중복된 번호
            Lotto.validateWinningNumbers(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 중복된 당첨 번호가 있습니다.");
        
        assertThatThrownBy(() -> {
            List<Integer> winningNumbers = List.of(1, 2, 3); // 6개가 아닌 경우
            Lotto.validateWinningNumbers(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 당첨 번호는 6개여야 합니다.");
    }
}
