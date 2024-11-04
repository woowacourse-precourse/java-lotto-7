package lotto;

import lotto.model.Lotto;
import lotto.service.MatchCheck;
import lotto.view.MatchLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchCheckTest {
    private final MatchCheck matchCheck = new MatchCheck();;

    @Test
    @DisplayName("로또 번호와 당첨 번호 일치 개수 테스트")
    void matchLottoTest() {
        List<Integer> paper = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winNumber = List.of(1, 2, 3, 7, 8, 9);

        int matchCount = matchCheck.matchLotto(paper, winNumber);

        assertThat(matchCount).isEqualTo(3); // 3개의 번호가 일치하는지 확인
    }

    @Test
    @DisplayName("보너스 번호 일치 여부 테스트")
    void matchBonusNumberTest() {
        List<Integer> paper = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 5;

        boolean bonusMatch = matchCheck.matchBonusNumber(paper, bonusNumber);

        assertThat(bonusMatch).isTrue(); // 보너스 번호가 일치하는지 확인
    }

    @Test
    @DisplayName("winPapers 메서드가 올바른 등수와 상금을 반환하는지 테스트")
    void winPapersTest() {
        Lotto[] lottoPapers = {
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 6개 일치
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 5개 + 보너스 일치
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 5개 일치
                new Lotto(List.of(1, 2, 3, 4, 10, 11)), // 4개 일치
                new Lotto(List.of(1, 2, 3, 7, 8, 9))  // 3개 일치
        };

        List<Integer> winNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        HashMap<Lotto, MatchLotto> result = matchCheck.winPapers(lottoPapers, winNumber, bonusNumber);


        // 결과 검증
        assertThat(result.get(lottoPapers[0])).isEqualTo(MatchLotto.FIRST);     // 6개 일치 - 1등
        assertThat(result.get(lottoPapers[1])).isEqualTo(MatchLotto.SECOND);    // 5개 + 보너스 - 2등
        assertThat(result.get(lottoPapers[2])).isEqualTo(MatchLotto.THIRD);     // 5개 일치 - 3등
        assertThat(result.get(lottoPapers[3])).isEqualTo(MatchLotto.FOURTH);    // 4개 일치 - 4등
        assertThat(result.get(lottoPapers[4])).isEqualTo(MatchLotto.FIFTH);     // 3개 일치 - 5등
    }
}
