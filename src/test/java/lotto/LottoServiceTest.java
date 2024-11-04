package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.utils.LottoPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("getSeveralLotto - 로또 생성 테스트")
    void getSeveralLottoTest() {
        int amount = 3;
        List<Lotto> lottoList = lottoService.getSeveralLotto(amount);

        assertThat(lottoList).hasSize(amount);
        lottoList.forEach(lotto -> {
            assertThat(lotto.getNumbers()).hasSize(6);
            assertThat(lotto.getNumbers()).doesNotHaveDuplicates();
        });
    }

    @Test
    @DisplayName("countPrize - 당첨 개수 계산 테스트")
    void countPrizeTest() {
        List<Lotto> lottoBundle = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        Map<String, Integer> result = lottoService.countPrize(lottoBundle, winningNumbers, bonus);
        assertThat(result.get(LottoPrize.MATCH_SIX.name())).isEqualTo(1);
        assertThat(result.get(LottoPrize.MATCH_FOUR.name())).isEqualTo(1);
    }

    @Test
    @DisplayName("getReturnRate - 수익률 계산 테스트")
    void getReturnRateTest() {
        Map<String, Integer> countMap = Map.of(
                LottoPrize.MATCH_SIX.name(), 1,
                LottoPrize.MATCH_THREE.name(), 2
        );
        int price = 3000;

        float returnRate = lottoService.getReturnRate(countMap, price);
        assertThat(returnRate).isGreaterThan(0);
    }
}
