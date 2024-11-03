package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class MatchCounterTest {

    @DisplayName("로또_번호_일치_개수_확인")
    @Test
    void shouldCountMatchingNumbers() {
        // 주어진 로또 티켓과 당첨 번호를 생성
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        // 일치하는 번호 개수를 확인
        int matchCount = MatchCounter.getMatchCount(ticket, winningNumbers);

        assertThat(matchCount).isEqualTo(3); // 4, 5, 6이 일치하므로 3개 일치해야 함
    }

    @DisplayName("보너스번호_일치_확인_실패")
    @Test
    void shouldNotMatchBonusNumber() {
        // 로또 티켓과 보너스 번호를 생성
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // 보너스 번호가 포함되어 있는지 확인
        boolean hasBonus = MatchCounter.checkBonus(ticket, bonusNumber);

        assertThat(hasBonus).isFalse(); // 보너스 번호 7은 티켓에 포함되어 있지 않아야 함
    }

    @DisplayName("보너스번호_일치_확인_성공")
    @Test
    void 보너스번호_일치_확인2() {
        // 로또 티켓과 보너스 번호를 생성
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        // 보너스 번호가 포함되어 있는지 확인
        boolean hasBonus = MatchCounter.checkBonus(ticket, bonusNumber);

        assertThat(hasBonus).isTrue(); // 보너스 번호 6은 티켓에 포함되어 있어야 함
    }

}