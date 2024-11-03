package lotto.models;

import lotto.models.constants.RewardTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("각 일치 번호 갯수에 해당하는 당첨금액을 반환한다.")
    @ParameterizedTest
    @CsvSource({"3,5000", "4,50000", "5,1500000", "6,30000000", "7,2000000000"})
    void 당첨금_계산_기능_테스트(int matchValue, int expectedValue) {
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
