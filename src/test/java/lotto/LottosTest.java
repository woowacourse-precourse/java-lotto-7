package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @DisplayName("getSorted 테스트")
    @Test
    void getSortedTest() {
        assertSimpleTest(() -> {
            List<Integer> list = List.of(4,3,0,-3,1,2);
            List<Integer> result = lotto.Lottos.getSorted(list);

            assertThat(result).isEqualTo(List.of(-3,0,1,2,3,4));
        });
    }

    @DisplayName("parsed 테스트")
    @Test
    void parsedTest() {
        assertSimpleTest(() -> {
            String string = "6,5,3";
            List<Integer> result = lotto.Lottos.parsed(string);

            assertThat(result).isEqualTo(List.of(6,5,3));
        });
    }

    @DisplayName("countRank 테스트")
    @Test
    void countRankTest() {
        assertSimpleTest(() -> {
            List<Lotto> lottos = List.of(new Lotto(List.of(1,2,3,4,5,6)),new Lotto(List.of(1,2,3,4,5,7)));
            Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
            List<Integer> result = lotto.Lottos.countRank(lottos, winningLotto, 7);

            assertThat(result).isEqualTo(List.of(1,1,0,0,0));
        });
    }

    @DisplayName("getGainedMoney 테스트")
    @Test
    void getGainedMoneyTest() {
        assertSimpleTest(() -> {
            List<Integer> ranks = List.of(1,1,1,1,1);
            int result = lotto.Lottos.getGainedMoney(ranks);

            assertThat(result).isEqualTo(2000000000+30000000+1500000+50000+5000);
        });
    }

    @DisplayName("getRateOfReturn 테스트")
    @Test
    void getRateOfReturnTest() {
        assertSimpleTest(() -> {
            float result = lotto.Lottos.getRateOfReturn(55000,100);

            assertThat(result).isEqualTo(55.0f);
        });
    }
}

