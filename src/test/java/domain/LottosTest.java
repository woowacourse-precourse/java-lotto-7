package domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Winning;
import org.junit.jupiter.api.Test;
import lotto.util.LottoGenerator;

class LottosTest {

    @Test
    void 로또_수량_반환_테스트() {
        assertSimpleTest(
                () -> {
                    List<Lotto> numbers = LottoGenerator.getLottos(3);
                    Lottos lottos = new Lottos(numbers, 3000);
                    assertThat(lottos.getQuantity()).isEqualTo(3);
                }
        );
    }

    @Test
    void 로또_구매_금액_반환_테스트() {
        assertSimpleTest(
                () -> {
                    List<Lotto> numbers = LottoGenerator.getLottos(3);
                    Lottos lottos = new Lottos(numbers, 3000);
                    assertThat(lottos.getAmount()).isEqualTo(3000);
                }
        );
    }

    @Test
    void 로또_당첨_내역_반환_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> numbers = LottoGenerator.getLottos(4);
                    Lottos lottos = new Lottos(numbers, 4000);
                    Winning winning = new Winning(List.of(8, 21, 23, 41, 42, 5), 43);

                    assertThat(lottos.getRanks(winning)).isEqualTo(List.of(Rank.FIFTH_PLACE, Rank.SECOND_PLACE));
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42)
        );
    }

}

