package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.utils.ConstantValue;
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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    @DisplayName("pickLotto - 랜덤 로또 생성 테스트")
    void pickLottoTest() {
        Lotto randomLotto = Lotto.pickLotto();
        assertThat(randomLotto.getNumbers()).hasSize(6);
        assertThat(randomLotto.getNumbers()).doesNotHaveDuplicates();
        randomLotto.getNumbers().forEach(number ->
                assertThat(number).isBetween(ConstantValue.LOTTO_MIN_VALUE, ConstantValue.LOTTO_MAX_VALUE)
        );
    }

    @Test
    @DisplayName("countMatch - 당첨 번호 매칭 개수 테스트")
    void countMatchTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 8, 9);
        int matchCount = lotto.countMatch(winningNumbers);
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    @DisplayName("hasBonus - 보너스 번호 포함 여부 테스트")
    void hasBonusTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.hasBonus(3)).isTrue();
        assertThat(lotto.hasBonus(7)).isFalse();
    }
}
