package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;


class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    private final int LOTTO_PRICE = 1000;

    @Test
    @DisplayName("로또_생성_테스트")
    void generateLottoTest() {
        // given
        int amount = 10000;

        // when
        List<Lotto> lottos = lottoMachine.generateLotto(amount);

        // then
        assertThat(lottos.size()).isEqualTo(amount/LOTTO_PRICE);
    }

    @Test
    @DisplayName("당첨_통계_계산_테스트")
    void calculateStatsTest() {
        // given
        List<Lotto> lottos = lottoMachine.generateLotto(10000);
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;

        // when
        Map<Integer, Integer> resultMap = lottoMachine.calculateStats(lottos, winningNumber, bonusNumber);

        // then
        assertThat(resultMap.size()).isBetween(1,8);
    }
}