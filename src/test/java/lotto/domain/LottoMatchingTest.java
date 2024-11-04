package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchingTest {

    @DisplayName("각 로또 번호가 당첨 번호와 일치하는 개수를 출력한다.")
    @Test
    void 로또번호별_매칭개수_출력() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        int matchCount = winningLotto.countMatchingNumbers(lotto);
        boolean bonusMatch = winningLotto.isBonusMatched(lotto);

        assertThat(matchCount).isEqualTo(3);
        assertThat(bonusMatch).isTrue();
    }
}
