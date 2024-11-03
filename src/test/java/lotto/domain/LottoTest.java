package lotto.domain;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 1에서 45 사이의 수인지 검사")
    void verifyLottoNumberIsBetween1To45() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 100)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @RepeatedTest(100)
    @DisplayName("로또 번호가 오름차순으로 정렬되는지 검사")
    void verifyLottoNumbersAreIncreasing() {
        LottoStore lottoStore = new LottoStore();
        List<Integer> lottoNumbers = lottoStore.sell(1_000).getLottos().getFirst().getNumbers();
        // then
        List<Integer> sortedNumbers = new ArrayList<>(lottoNumbers);
        sortedNumbers.sort(Integer::compareTo);

        assertThat(lottoNumbers).isEqualTo(sortedNumbers);
    }
}
