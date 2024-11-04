package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatcherTest {
    private final LottoMatcher lottoMatcher = new LottoMatcher();

    @DisplayName("구매한 로또 번호와 당첨 번호가 3개 매칭될 때, 매칭 개수가 3이다.")
    @Test
    void 로또_번호와_당첨번호가_매칭될_때_매칭_개수_반환() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 8, 9);

        int matches = lottoMatcher.countMatches(winningNumbers, lotto);

        assertThat(matches).isEqualTo(3); // 매칭 개수가 3인지 확인
    }

    @DisplayName("구매한 로또 번호와 당첨 번호가 매칭되지 않을 때, 매칭 개수가 0이다.")
    @Test
    void 로또_번호와_당첨번호가_매칭되지_않을_때_매칭_개수_0반환() {
        Lotto lotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        List<Integer> winningNumbers = List.of(1, 2, 3, 10, 11, 12);

        int matches = lottoMatcher.countMatches(winningNumbers, lotto);

        assertThat(matches).isEqualTo(0); // 매칭 개수가 0인지 확인
    }

    @DisplayName("보너스 번호가 구매한 로또 번호와 매칭될 때, true를 반환한다.")
    @Test
    void 보너스_번호가_매칭되면_true를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 5;

        boolean isBonusMatched = lottoMatcher.bonusMatch(bonusNumber, lotto);

        assertThat(isBonusMatched).isTrue(); // 보너스 번호가 매칭되므로 true인지 확인
    }

    @DisplayName("보너스 번호가 구매한 로또 번호와 매칭되지 않을 때, false를 반환한다.")
    @Test
    void 보너스_번호가_매칭되지_않으면_false를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        boolean isBonusMatched = lottoMatcher.bonusMatch(bonusNumber, lotto);

        assertThat(isBonusMatched).isFalse(); // 보너스 번호가 매칭되지 않으므로 false인지 확인
    }
}
