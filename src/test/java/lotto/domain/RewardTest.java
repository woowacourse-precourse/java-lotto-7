package lotto.domain;

import static lotto.utils.Reward.FIFTH;
import static lotto.utils.Reward.FIRST;
import static lotto.utils.Reward.FOURTH;
import static lotto.utils.Reward.NO_REWARD;
import static lotto.utils.Reward.SECOND;
import static lotto.utils.Reward.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.utils.Reward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RewardTest {

    @Test
    @DisplayName("상금 반환 테스트 + 보너스 미당첨")
    void test1() {
        // given

        int allCorrectCnt = 6;
        List<Integer> prizeList = List.of(FIRST.getPrize(), THIRD.getPrize(), FOURTH.getPrize(), FIFTH.getPrize());

        for (int i = 0; i < prizeList.size(); i++) {
            // when
            Reward result = Reward.forMatch(allCorrectCnt - i, false);

            // then
            Integer expected = prizeList.get(i);
            assertThat(result.getPrize()).isEqualTo(expected);
        }
    }

    @Test
    @DisplayName("상금 미반환 테스트 + 보너스 미당첨")
    void test2() {
        //given
        for (int correct = 0; correct < 3; correct++) {
            // when
            Reward result = Reward.forMatch(correct, false);

            // then
            assertThat(result).isEqualTo(NO_REWARD);
        }
    }

    @Test
    @DisplayName("상금 1등 테스트")
    void test3() {
        Reward reward = Reward.forMatch(6, true);
        assertThat(reward).isEqualTo(FIRST);

        reward = Reward.forMatch(6, false);
        assertThat(reward).isEqualTo(FIRST);
    }

    @Test
    @DisplayName("상금 3등 테스트")
    void test4() {
        Reward reward = Reward.forMatch(5, false);
        assertThat(reward).isEqualTo(THIRD);
    }

    @Test
    @DisplayName("상금 2등 테스트")
    void test5() {
        Reward reward = Reward.forMatch(5, true);
        assertThat(reward).isEqualTo(SECOND);
    }

    @Test
    @DisplayName("보너스 당첨이여도 등수 검증 테스트")
    void test6() {
        List<Reward> result = List.of(FIFTH, FOURTH, SECOND);
        for (int matchCount = 3; matchCount <= 5; matchCount++) {
            Reward reward = Reward.forMatch(matchCount, true);

            assertThat(reward).isEqualTo(result.get(matchCount - 3));
        }
    }

}
