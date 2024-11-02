package lotto.domain.score;

import lotto.constants.collection.ScoreSystem;
import lotto.constants.collection.ScoreSystemReward;
import lotto.domain.*;
import lotto.domain.factory.NumberLottoFactory;
import lotto.dto.ScoreDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ScoreTest {

    static Lotto sampleWinningNumber;
    static BonusComponent sampleBonusComponent;

    @BeforeAll
    static void setUp() {

        sampleWinningNumber = new Lotto(Stream.of(1, 2, 3, 10, 11, 12)
                .map(ComponentNumber::new)
                .collect(Collectors.toList()));
        sampleBonusComponent = new BonusComponentNumber(sampleWinningNumber, new ComponentNumber(13));
    }

    @Test
    @DisplayName("Default ScoreSystem 기능 테스트")
    void defaultScoreTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Lottos lottos = new Lottos(3, new NumberLottoFactory(1, 45, 6));
                    Score score = new Score(ScoreSystem.DEFAULT.getInstance(), ScoreSystemReward.DEFAULT.getInstance());
                    ScoreDto result = score.printScore(lottos, sampleWinningNumber, sampleBonusComponent);

                    // 전부 1,2,3 3개의 숫자만 겹치게 됩니다. 3Match가 3번 기록되었습니다.
                    assertThat(result.scores()).isEqualTo(List.of(3, 0, 0, 0, 0));

                    // 수익률은 5배 500.0%입니다.
                    assertThat(result.rateOfReturn()).isEqualTo((float) 500.0);

                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 5, 6, 7),
                List.of(1, 2, 3, 6, 7, 8)
        );
    }

}
