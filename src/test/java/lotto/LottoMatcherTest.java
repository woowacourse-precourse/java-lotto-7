package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import model.Lotto;
import model.LottoMatcher;

class LottoMatcherTest {

    @Test
    @DisplayName("당첨 번호와 일치하는 번호 개수를 반환한다")
    void 당첨_번호_매칭() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        assertThat(LottoMatcher.compareNumbers(userLotto, winningLotto)).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 번호 일치 여부를 확인한다")
    void 보너스_번호_매칭() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(LottoMatcher.compareBonusNumber(userLotto, 6)).isTrue();
        assertThat(LottoMatcher.compareBonusNumber(userLotto, 7)).isFalse();
    }
}

