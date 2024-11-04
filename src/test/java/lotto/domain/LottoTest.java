package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(createLottoNumbers(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(createLottoNumbers(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private List<LottoNumber> createLottoNumbers(int... numbers) {
        return IntStream.of(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("로또 번호가 오름차순으로 정렬된다.")
    void 로또_번호_정렬() {
        Lotto lotto = new Lotto(createLottoNumbers(6, 5, 4, 3, 2, 1));
        List<Integer> sortedNumbers = lotto.getNumbers().stream()
                .map(LottoNumber::lottoNumber)
                .collect(Collectors.toList());
        assertThat(sortedNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("특정 번호가 로또에 포함되는지 확인한다.")
    void 특정_번호_포함_확인() {
        Lotto lotto = new Lotto(createLottoNumbers(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(new LottoNumber(3))).isTrue();
        assertThat(lotto.contains(new LottoNumber(7))).isFalse();
    }
}
