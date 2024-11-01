package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.common.Winning;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {
    private static LottoService lottoService;
    private static LottoResultService lottoResultService;

    @BeforeAll
    static void init() {
        lottoService = new LottoService();
        lottoResultService = new LottoResultService();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void issueLottos(int payCount) {
        // given

        // when
        List<Lotto> lottos = lottoService.issueLottos(payCount);
        List<Lotto> distintLottos = lottos.stream().distinct().toList();

        // then
        assertThat(lottos).isEqualTo(distintLottos);
    }

    @Test
    void getWinnings() {
        //given
        List<Integer> lotto = List.of(7, 8, 9, 10, 11, 12);
        List<Lotto> lottos = List.of(new Lotto(lotto));
        List<Integer> winningNumbers = List.of(4, 5, 6, 7, 8, 9);
        int bonus = 10;

        // when
        Map<Winning, Integer> countWinnings = lottoResultService.getWinnings(lottos, winningNumbers, bonus);

        // then
        assertThat(countWinnings).isEqualTo(Map.of(
                Winning.THREE, 1
        ));
    }

    @Test
    void calculateYield() {
        //given
        int payment = 5000;
        Map<Winning, Integer> winnings = Map.of(
            Winning.THREE, 1
        );
        int totalWinnings = 5000;

        // when
        double yield = lottoResultService.calculateYield(payment, totalWinnings);

        // then
        assertThat(yield).isEqualTo(100.0);
    }
}