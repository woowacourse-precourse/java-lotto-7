package lotto.model;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void 숫자_6개를_뽑아_로또를_한장_발행한다(int lottoNumbersIndex) {
        List<Integer> testNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(testNumbers);

        assertThat(lotto.getNumbers()).contains(testNumbers.get(lottoNumbersIndex));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void 숫자를_뽑을_때_오름차순으로_정렬한다(int lottoNumbersIndex) {
        List<Integer> randomNumbers = RandomNumberPicker.pickAscendingNumbers();

        Lotto lotto = new Lotto(randomNumbers);

        assertThat(lotto.getNumbers().get(lottoNumbersIndex))
                .isLessThan(lotto.getNumbers().get(lottoNumbersIndex + 1));
    }
}
