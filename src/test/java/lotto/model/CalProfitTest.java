package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalProfitRateTest {

    @DisplayName("수익률이 올바르게 계산되는지 테스트한다.")
    @Test
    void calculateProfitRate_ShouldReturnCorrectProfitRate() {
        // given: 당첨 결과와 로또 구매 개수를 설정
        Map<Rank, Integer> results = new HashMap<>();
        results.put(Rank.FIRST, 1);  // 1등 1회
        results.put(Rank.SECOND, 0); // 2등 없음
        results.put(Rank.THIRD, 2);  // 3등 2회
        results.put(Rank.FOURTH, 0); // 4등 없음
        results.put(Rank.FIFTH, 3);  // 5등 3회

        int lottoCount = 10; // 총 구매한 로또 수

        double expectedProfitRate = (Rank.FIRST.getPrize() * 1 +
                Rank.THIRD.getPrize() * 2 +
                Rank.FIFTH.getPrize() * 3) / (lottoCount * 1000.0) * 100;

        // when: 수익률 계산
        double profitRate = CalProfitRate.calculateProfitRate(results, lottoCount);

        // then: 예상 수익률과 실제 수익률이 동일한지 확인
        assertEquals(expectedProfitRate, profitRate, 0.0001); // 오차 허용범위 추가
    }

    @DisplayName("모든 Rank의 수익률이 0일 때 수익률이 0인지 테스트한다.")
    @Test
    void calculateProfitRate_ShouldReturnZeroWhenNoWinnings() {
        // given: 당첨이 없고, 로또 구매 개수만 설정된 경우
        Map<Rank, Integer> results = new HashMap<>();
        int lottoCount = 10; // 총 구매한 로또 수

        // when: 수익률 계산
        double profitRate = CalProfitRate.calculateProfitRate(results, lottoCount);

        // then: 수익률이 0인지 확인
        assertEquals(0, profitRate, 0.0001); // 오차 허용범위 추가
    }
}
