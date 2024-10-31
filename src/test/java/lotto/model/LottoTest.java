package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("로또 번호에 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void crateLottoFromUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호가 지정 범위의 최댓값을 넘어가면 예외가 발생한다.")
    @Test
    void createLottoFromOutOfMaxRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 번호는 1부터 45사이여야 합니다.");
    }

    @DisplayName("로또 번호가 지정 범위의 최솟값을 넘어가면 예외가 발생한다.")
    @Test
    void createLottoFromOutOfMinRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 번호는 1부터 45사이여야 합니다.");
    }

    @DisplayName("로또 번호의 정렬 결과를 확인한다.")
    @Test
    void getSortedNumbersByAscending() {
        //given
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        //when
        List<Integer> sortedNumbers = lotto.getSortedNumbersByAscending();
        //then
        assertThat(sortedNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("해당 숫자가 로또 번호에 포함되어 있는지 확인한다.")
    @Test
    void isContainNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        boolean result = lotto.isContain(1);
        //then
        assertThat(result).isTrue();
    }

    @DisplayName("해당 숫자가 로또 번호에 포함되어 있는지 확인한다.")
    @Test
    void isNotContainNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        boolean result = lotto.isContain(7);
        //then
        assertThat(result).isFalse();
    }

}
