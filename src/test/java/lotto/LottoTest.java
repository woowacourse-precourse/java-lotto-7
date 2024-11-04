package lotto;

import lotto.domain.number.LottoNumber;
import lotto.domain.ticket.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자가 있습니다.");
    }

    @DisplayName("로또 번호가 6개 미만이면 예외가 발생한다")
    @Test
    void 로또_번호가_6개_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또_번호_범위_검증(int invalidNumber) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        numbers.add(invalidNumber);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되어야 한다")
    @Test
    void 로또_번호_정렬() {
        Lotto lotto = new Lotto(List.of(6, 3, 5, 1, 2, 4));
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        assertThat(lotto.getNumbers()).isEqualTo(expected);
    }

    @DisplayName("로또 번호가 포함되어 있는지 확인한다")
    @Test
    void 로또_번호_포함_여부_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.contains(LottoNumber.of(1))).isTrue();
        assertThat(lotto.contains(LottoNumber.of(7))).isFalse();
    }

    @DisplayName("일치하는 번호의 개수를 반환한다")
    @Test
    void 일치하는_번호_개수_확인() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        assertThat(lotto1.countMatch(lotto2)).isEqualTo(3);
    }

    @DisplayName("로또 번호 목록이 null이면 예외가 발생한다")
    @Test
    void 로또_번호_null_검증() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 null일 수 없습니다.");
    }
}