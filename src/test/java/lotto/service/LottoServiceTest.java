package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.Lotto;
import lotto.common.Winning;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {
    private static LottoService lottoService;

    @BeforeAll
    static void init() {
        lottoService = new LottoService();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void initLotto(int payCount) {
        // given

        // when
        List<Lotto> lottos = lottoService.initLotto(payCount);
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
        Map<Winning, Integer> countWinnings = lottoService.getWinnings(lottos, winningNumbers, bonus);

        // then
        assertThat(countWinnings).isEqualTo(Map.of(
                Winning.THREE, 1
        ));
    }
}