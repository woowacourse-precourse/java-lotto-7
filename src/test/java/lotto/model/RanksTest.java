package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RanksTest {
    @DisplayName("기능 테스트: 로또 일치 횟수별 등급 카운터 갱신 확인")
    @ParameterizedTest
    @CsvSource(value = {"6,false:000001", "5,true:000010", "5,false:000100",
            "4,false:001000", "3,false:010000", "2,false:100000"}, delimiter = ':')
    void check_ranks(String hits, String totalHits) {
        String[] splitHits = hits.split(",");
        int numbersHit = Integer.parseInt(splitHits[0]);
        boolean bonusHit = Boolean.parseBoolean(splitHits[1]);

        Ranks.checkRanks(numbersHit, bonusHit);

        StringBuilder hitCounts = new StringBuilder();
        for (Ranks rankValue : Ranks.values()) {
            int hitCount = rankValue.getCount();

            hitCounts.append(hitCount);
        }
        String resultHits = hitCounts.toString();
        assertEquals(resultHits, totalHits);
    }
}