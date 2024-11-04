package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

public class RankingTest {
    @ParameterizedTest(name = "numberOfHits: {0}, bonusNumberHit: {1} => expectedRankingName: {2}")
    @CsvSource({
        "6, true, FIRST_PLACE",
        "6, false, FIRST_PLACE",
        "5, true, SECOND_PLACE",
        "5, false, THIRD_PLACE",
        "4, true, FOURTH_PLACE",
        "4, false, FOURTH_PLACE",
        "3, true, FIFTH_PLACE",
        "3, false, FIFTH_PLACE",
        "2, false, LOSE",
        "0, false, LOSE"
    })
    @DisplayName("일치하는 번호 수와 보너스 번호 일치 여부에 따른 등수 계산")
    void 랭크_계산(int numberOfHits, boolean bonusNumberHit, String expectedRankingName) {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        DrawnLotto drawnLottoMock = new DrawnLotto("1, 2, 3, 4, 5, 6", "7") {
            @Override
            public int countHits(Lotto lotto) {
                return numberOfHits;
            }

            @Override
            public boolean isBonusNumberHit(Lotto lotto) {
                return bonusNumberHit;
            }
        };

        Ranking ranking = Ranking.calculate(drawnLottoMock, lotto);

        Ranking expectedRanking = Ranking.valueOf(expectedRankingName);
        assertThat(ranking).isEqualTo(expectedRanking);
    }
}
