package lotto.model;

import lotto.enums.LottoRank;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @Test
    void 로또_생성_개수_테스트() {
        int numOfTickets = 8;

        List<Lotto> lottos = lottoService.getLottos(numOfTickets);

        assertEquals(numOfTickets, lottos.size());
    }

    @Test
    void 로또_번호_범위_및_중복_테스트() {
        List<Integer> lotto = lottoService.generateLottoNumbers();

        for (Integer number : lotto) {
            assertEquals(6, lotto.size(), "로또 번호는 6개여야 합니다");
            assertTrue(lotto.stream().allMatch(num -> num >= 1 && num <= 45), "로또 번호는 1에서 45 사이여야 합니다");
            assertEquals(lotto.size(), lotto.stream().distinct().count(), "로또 번호는 중복되지 않아야 합니다");
        }
    }

    @Test
    void 로또_개수와_순위_개수_확인_테스트() {
        List<Lotto> lottos = lottoService.getLottos(8);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        List<LottoRank> ranks = lottoService.getRanks(lottos, winningNumbers, bonusNumber);

        assertEquals(8, ranks.size());
    }

    @Test
    void 당첨_내역_출력_테스트() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<LottoRank> ranks = lottoService.getRanks(lottos, winningNumbers, bonusNumber);

        String result = lottoService.getPrizeResult(ranks);
        assertThat(result).contains("3개 일치 (5,000원) - 0개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 1개");
    }

    @Test
    void 수익률_출력_테스트() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<LottoRank> ranks = lottoService.getRanks(lottos, winningNumbers, bonusNumber);
        int purchaseAmount = 1000;

        String profitRateResult = lottoService.getProfitRateResult(ranks, purchaseAmount);
        assertThat(profitRateResult).contains("총 수익률은 200000000.0%입니다.");
    }
}