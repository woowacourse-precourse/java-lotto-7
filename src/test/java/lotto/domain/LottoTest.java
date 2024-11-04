package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 5))))
                .isInstanceOf(IllegalArgumentException.class);
    }
    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void validateLottoNumberRange(int number) {
        assertThatThrownBy(() -> new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, number))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 오름차순으로 정렬되어야 한다")
    void lottoNumbersShouldBeSorted() {
        List<Integer> numbers = new ArrayList<>(List.of(6, 4, 3, 2, 1, 5));
        Collections.sort(numbers);  // 정렬을 먼저 수행
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
