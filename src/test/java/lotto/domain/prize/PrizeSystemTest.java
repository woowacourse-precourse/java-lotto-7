package lotto.domain.prize;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PrizeSystemTest {

    private PrizeSystem prizeSystem;

    @BeforeEach
    void setUp() {
        List<Integer> prizeNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        prizeSystem = new PrizeSystem(prizeNumbers, bonusNumber);
    }

    @Test
    @DisplayName("로또 번호 중 당첨 번호와 일치하는 번호 개수 반환")
    void 로또번호_당첨번호와_일치하는_번호개수_반환() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 8, 9, 10);

        // when
        int matchCount = prizeSystem.getMatchCount(lottoNumbers);

        // then
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    @DisplayName("일치하는 번호 개수를 당첨 통계에 업데이트")
    void 일치하는_번호개수_당첨통계_업데이트() {
        // given - 5등 번호
        List<Integer> lottoNumbers = List.of(1, 2, 3, 8, 9, 10);

        // when
        int matchCount = prizeSystem.getMatchCount(lottoNumbers);
        prizeSystem.updatePrizeCount(lottoNumbers, matchCount);
        PrizeCount prizeCount = prizeSystem.getPrizeCount();

        // then - 주어진 로또 번호는 5등이기 때문에 5등 개수가 1개여야 한다.
        assertThat(prizeCount.getFifthPrizeCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("보너스 번호를 비교해야 하는 경우")
    void 보너스번호_비교해야하는경우() {
        // given - 2등 번호
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);

        // when
        int matchCount = prizeSystem.getMatchCount(lottoNumbers);
        prizeSystem.updatePrizeCount(lottoNumbers, matchCount);
        PrizeCount prizeCount = prizeSystem.getPrizeCount();

        // then - 주어진 로또 번호는 2등이기 때문에 2등 개수가 1개여야 한다.
        assertThat(prizeCount.getSecondPrizeCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("총 당첨 금액 계산")
    void 총_당첨금액_계산() {
        // given - 2등
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);

        // when
        int matchCount = prizeSystem.getMatchCount(lottoNumbers);
        prizeSystem.updatePrizeCount(lottoNumbers, matchCount);
        int prizeMoney = prizeSystem.getPrizeMoney();

        // then - 주어진 로또 번호는 2등이기 때문에 당첨 금액이 30000000이어야 한다.
        assertThat(prizeMoney).isEqualTo(30000000);
    }

    @Test
    @DisplayName("수익률 계산")
    void 수익률_계산() {
        // given - 1등
        int purchaseMoney = 1000;
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        int matchCount = prizeSystem.getMatchCount(lottoNumbers);
        prizeSystem.updatePrizeCount(lottoNumbers, matchCount);
        double profit = prizeSystem.getProfit(purchaseMoney);

        // then
        assertThat(profit).isEqualTo(200000000);
    }
}