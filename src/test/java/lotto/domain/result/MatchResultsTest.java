package lotto.domain.result;

import static lotto.constants.LottoRank.FIFTH;
import static lotto.constants.LottoRank.FIRST;
import static lotto.constants.LottoRank.FOURTH;
import static lotto.constants.LottoRank.NO_LUCK;
import static lotto.constants.LottoRank.SECOND;
import static lotto.constants.LottoRank.THIRD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lotto.dto.FinalResultsDto;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("[Domain] MatchResults")
public class MatchResultsTest {
    private final LottosDto lottosDto;
    private final WinningLotto winningLotto;


    public MatchResultsTest() {
        List<LottoDto> lottoDtos = new ArrayList<>();
        lottoDtos.add(new LottoDto(Set.of(1, 2, 3, 4, 5, 6))); // 모든 번호 일치
        lottoDtos.add(new LottoDto(Set.of(1, 2, 3, 4, 5, 7))); // 번호 5개 일치 + 보너스 번호 일치
        lottoDtos.add(new LottoDto(Set.of(1, 2, 3, 8, 9, 10))); // 번호 3개 일치
        lottoDtos.add(new LottoDto(Set.of(7, 8, 9, 10, 11, 12))); // 번호 일치 없음

        this.lottosDto = new LottosDto(lottoDtos);
        this.winningLotto = WinningLotto.create(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    @Nested
    @DisplayName("[createMatchResults] 로또 결과 생성 기능")
    class CreateMatchResultsTest {

        @Test
        @DisplayName("[return] 주어진 로또와 당첨 번호에 따라 결과를 생성한다")
        public void testCreateMatchResults() {
            MatchResults matchResults = MatchResults.createMatchResults(lottosDto, winningLotto);
            assertEquals(4, matchResults.buildFinalResultsDto().rankResultsDto().rankResults().size());
        }
    }

    @Nested
    @DisplayName("[buildFinalResultsDto] 최종 결과 DTO 생성 기능")
    class BuildFinalResultsDtoTest {

        @Test
        @DisplayName("[return] 매치 결과에 따라 FinalResultsDto를 올바르게 생성한다")
        public void testBuildFinalResultsDto() {
            MatchResults results = MatchResults.createMatchResults(lottosDto, winningLotto);

            FinalResultsDto finalResults = results.buildFinalResultsDto();

            assertEquals(1, finalResults.rankResultsDto().rankResults().get(FIRST.getRank()));
            assertEquals(1, finalResults.rankResultsDto().rankResults().get(SECOND.getRank()));
            assertNull(finalResults.rankResultsDto().rankResults().get(THIRD.getRank()));
            assertNull(finalResults.rankResultsDto().rankResults().get(FOURTH.getRank()));
            assertEquals(1, finalResults.rankResultsDto().rankResults().get(FIFTH.getRank()));
            assertEquals(1, finalResults.rankResultsDto().rankResults().get(NO_LUCK.getRank()));
        }
    }
}
