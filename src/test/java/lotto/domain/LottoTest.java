package lotto.domain;

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

    @DisplayName("로또 번호가 1이상 45이하가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호가_1이상_45이하가_아니_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨번호 일치 여부 확인.")
    @Test
    void 로또_번호와_당첨번호_일치_여부_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int one = lotto.matchNumbers(List.of(1, 12, 13, 14, 15, 16));
        int two = lotto.matchNumbers(List.of(1, 2, 13, 14, 15, 16));
        int three = lotto.matchNumbers(List.of(1, 2, 3, 14, 15, 16));
        int four = lotto.matchNumbers(List.of(1, 2, 3, 4, 15, 16));
        int five = lotto.matchNumbers(List.of(1, 2, 3, 4, 5, 16));
        int six = lotto.matchNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThat(one).isEqualTo(1);
        assertThat(two).isEqualTo(2);
        assertThat(three).isEqualTo(3);
        assertThat(four).isEqualTo(4);
        assertThat(five).isEqualTo(5);
        assertThat(six).isEqualTo(6);
    }

    @DisplayName("로또 번호와 보너스 번호 일치 여부 확인")
    @Test
    void 로또_번호와_보너스_번호_일치_여부_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.matchBonusNumber(1)).isTrue();
    }

    @DisplayName("로또 번호와 보너스 번호 불일치 여부 확인")
    @Test
    void 로또_번호와_보너스_번호_불일치_여부_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.matchBonusNumber(7)).isFalse();
    }
}
