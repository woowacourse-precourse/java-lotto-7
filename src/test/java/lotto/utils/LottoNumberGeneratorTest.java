package lotto.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {
    @DisplayName("로또 번호 제너레이터는 6개 숫자를 반환한다.")
    @Test
    void 로또_번호_제너레이터는_6개_숫자를_반환한다() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();
        assertThat(lottoNumbers).hasSize(6);
    }

    @DisplayName("로또 번호는 오름차순으로 정렬되어야 한다.")
    @Test
    void 로또_번호는_오름차순으로_정렬되어야_한다() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();
        List<Integer> sortedNumbers = new ArrayList<>(lottoNumbers);
        sortedNumbers.sort(Integer::compareTo);

        assertThat(lottoNumbers).isEqualTo(sortedNumbers);
    }

    @DisplayName("로또 번호는 1부터 45 사이의 숫자여야 한다.")
    @Test
    void 로또_번호는_1부터_45사이의_숫자여야_한다() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();

        for (Integer number : lottoNumbers) {
            assertThat(number).isBetween(1, 45);
        }
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}