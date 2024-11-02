package lotto.models;

import lotto.models.constants.RewardTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoResultsTest {
    private LottoResults lottoResults;

    @BeforeEach
    void setInstance() {
        lottoResults = new LottoResults();
    }

    @DisplayName("일치하는 번호의 값이 3 이상일 경우 결과를 인스턴스 필드에 저장한다.")
    @Test
    void 일치_번호_저장_기능_테스트() {
        int matchValue = 3;
        RewardTable matchKey = RewardTable.THREE_MATCHES;
        int expectedValue = 1;

        lottoResults.recordMatch(matchValue);
        assertEquals(expectedValue, lottoResults.getMatchValue(matchKey));
    }

    @DisplayName("3개의 번호가 일치할 경우 5000을 반환한다.")
    @Test
    void 당첨금_5000_계산_기능_테스트() {
        int matchValue = 3;
        long expectedValue = 5000;

        lottoResults.recordMatch(matchValue);
        assertEquals(expectedValue, lottoResults.calculateRewards());
    }

    @DisplayName("4개의 번호가 일치할 경우 50000을 반환한다.")
    @Test
    void 당첨금_50000_계산_기능_테스트() {
        int matchValue = 4;
        long expectedValue = 50000;

        lottoResults.recordMatch(matchValue);
        assertEquals(expectedValue, lottoResults.calculateRewards());
    }

    @DisplayName("5개의 번호가 일치할 경우 1500000을 반환한다.")
    @Test
    void 당첨금_1500000_계산_기능_테스트() {
        int matchValue = 5;
        long expectedValue = 1500000;

        lottoResults.recordMatch(matchValue);
        assertEquals(expectedValue, lottoResults.calculateRewards());
    }

    @DisplayName("5개의 번호와 보너스 번호가 일치할 경우 30000000을 반환한다.")
    @Test
    void 당첨금_30000000_계산_기능_테스트() {
        int matchValue = 6;
        long expectedValue = 30000000;

        lottoResults.recordMatch(matchValue);
        assertEquals(expectedValue, lottoResults.calculateRewards());
    }

    @DisplayName("6개의 번호가 일치할 경우 2000000000을 반환한다.")
    @Test
    void 당첨금_2000000000_계산_기능_테스트() {
        int matchValue = 7;
        long expectedValue = 2000000000;

        lottoResults.recordMatch(matchValue);
        assertEquals(expectedValue, lottoResults.calculateRewards());
    }

    @DisplayName("당첨 단계가 여럿일 경우 최종 합계를 반환한다.")
    @Test
    void 총_당첨금_계산_기능_테스트() {
        int matchValue1 = 3;
        int matchValue2 = 5;
        long expectedValue = 5000 + 1500000;

        lottoResults.recordMatch(matchValue1);
        lottoResults.recordMatch(matchValue2);
        assertEquals(expectedValue, lottoResults.calculateRewards());
    }
}
