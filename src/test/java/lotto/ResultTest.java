package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.model.Rank;
import lotto.model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    Result result;

    @BeforeEach
    void setUp() {
        result = new Result();
    }

    @DisplayName("통계가 업데이트 되면 해당 Rank의 수가 1증가한다.")
    @Test
    void 통계가_업데이트_되면_해당_Rank의_수가_1증가한다() {
        result.updateMatchedRank(Rank.FIRST);
        assertThat(result.getNumberOfThatRank(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("통계가 업데이트 되면 누적 상금이 증가한다.")
    @Test
    void 통계가_업데이트_되면_누적_상금이_증가한다() {
        result.updateMatchedRank(Rank.FIRST);
        result.updateMatchedRank(Rank.SECOND);
        assertThat(result.getTotalPrize()).isEqualTo(2030000000);
    }
}
