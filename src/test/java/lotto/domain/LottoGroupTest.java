package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGroupTest {

    private LottoGroup lottoGroup;

    @BeforeEach
    void setUp() {
        lottoGroup = new LottoGroup(List.of());  // 빈 로또 리스트로 초기화
    }

    @Test
    void 총_수익률_계산_테스트() {
        lottoGroup.updateWinningStatistics(Winning.THIRD); // 예: 3개 일치
        lottoGroup.addToTotalPrize(Winning.THIRD.getPrice()); // 당첨금 5,000원 추가

        int purchaseAmount = 10000;

        double expectedYield = (double) Winning.THIRD.getPrice() / purchaseAmount * 100;

        assertThat(lottoGroup.calculateYield(purchaseAmount)).isEqualTo(50.0);
    }
}