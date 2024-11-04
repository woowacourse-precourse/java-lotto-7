package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoResultSystemTest {

    private LottoResultSystem lottoResultSystem;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
        lottoResultSystem = new LottoResultSystem(winningNumbers, bonusNumber);
    }

    @Test
    @DisplayName("구매한 로또의 당첨 번호와 일치 개수를 계산한다")
    void 구매한_로또_당첨_번호_일치_여부() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 7, 8, 9));  // 3개 일치
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 10, 11));  // 4개 일치

        List<Lotto> purchasedLottos = List.of(lotto1, lotto2);

        Map<Integer, Integer> matchResults = lottoResultSystem.calculateMatchResults(purchasedLottos);

        assertThat(matchResults.get(3)).isEqualTo(1);  // 3개 일치한 로또가 1개
        assertThat(matchResults.get(4)).isEqualTo(1);  // 4개 일치한 로또가 1개
    }

    @Test
    @DisplayName("보너스 번호 일치 여부를 확인한다")
    void 보너스_번호_일치_여부() {
        Lotto lottoWithBonus = new Lotto(List.of(1, 2, 3, 4, 5, bonusNumber));  // 5개 + 보너스 일치
        Lotto lottoWithoutBonus = new Lotto(List.of(1, 2, 3, 4, 5, 8));  // 5개 일치, 보너스 없음

        int matchCountWithBonus = lottoWithBonus.countMatches(winningNumbers);
        int matchCountWithoutBonus = lottoWithoutBonus.countMatches(winningNumbers);

        assertThat(lottoResultSystem.isBonusMatch(matchCountWithBonus, lottoWithBonus)).isTrue();
        assertThat(lottoResultSystem.isBonusMatch(matchCountWithoutBonus, lottoWithoutBonus)).isFalse();
    }
}
