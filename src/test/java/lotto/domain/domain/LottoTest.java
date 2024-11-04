package lotto.domain.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    //toPrettyString
    @Test
    @DisplayName("오름차순으로 정렬되어 출력")
    void printOrderByAsc() {
        // given
        Lotto lotto = new Lotto(List.of(3,1,2,45,6,9));
        // when & then
        assertThat(lotto.toPrettyString())
                .isEqualTo("[1, 2, 3, 6, 9, 45]");
    }

    @Test
    @DisplayName("일치하는 수의 갯수를 반환")
    void countMatchingNumbers() {
        // given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> list = List.of(6, 7, 8, 9, 10, 11, 12);
        // when & then
        assertThat(lotto.matchNumbers(list)).isEqualTo(1);
    }

    @Test
    @DisplayName("보너스 숫자 일치 여부")
    void checkBonusNumberMatch() {
        // given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        // when & then
        assertThat(lotto.matchBonusNumber(1)).isTrue();
    }

    @Test
    @DisplayName("보너스 숫자 불일치")
    void noBonusNumberMatch() {
        // given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        // when & then
        assertThat(lotto.matchBonusNumber(7)).isFalse();
    }
}
