package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다.")
    void createLottoWithInvalidNumberCount() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    void createLottoWithInvalidNumberRange() {
        List<Integer> invalidNumbers = Arrays.asList(0, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호는 오름차순으로 정렬된다.")
    void createLottoWithSortedNumbers() {
        List<Integer> numbers = Arrays.asList(45, 1, 33, 12, 20, 7);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).containsExactly(1, 7, 12, 20, 33, 45);
    }
}
