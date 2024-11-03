package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 구매한_로또_개수만큼_로또를_생성한다() {
        //given
        int lottoCount = 8;

        //when
        lottoService.generateLottos(lottoCount);

        //then
        List<Lotto> lottos = lottoService.getLottos();
        assertEquals(8, lottos.size());
    }

    @Test
    void 당첨_번호와_3개_번호가_일치하면_5등이다() {
        //given
        List<Lotto> lottos = lottoService.getLottos();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        List<Integer> winningNumbers = List.of(1, 2, 3, 43, 44, 45);
        int bonusNumber = 7;

        //when
        lottoService.saveLottoRanks(winningNumbers, bonusNumber);

        //then
        Map<Rank, Integer> results = lottoService.getResults();
        assertEquals(1, results.getOrDefault(Rank.FIFTH, 0));
        assertEquals(0, results.getOrDefault(Rank.FOURTH, 0));
        assertEquals(0, results.getOrDefault(Rank.THIRD, 0));
        assertEquals(0, results.getOrDefault(Rank.SECOND, 0));
        assertEquals(0, results.getOrDefault(Rank.FIRST, 0));
    }

    @Test
    void 당첨_번호와_4개_번호가_일치하면_4등이다() {
        //given
        List<Lotto> lottos = lottoService.getLottos();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 44, 45);
        int bonusNumber = 7;

        //when
        lottoService.saveLottoRanks(winningNumbers, bonusNumber);

        //then
        Map<Rank, Integer> results = lottoService.getResults();
        assertEquals(0, results.getOrDefault(Rank.FIFTH, 0));
        assertEquals(1, results.getOrDefault(Rank.FOURTH, 0));
        assertEquals(0, results.getOrDefault(Rank.THIRD, 0));
        assertEquals(0, results.getOrDefault(Rank.SECOND, 0));
        assertEquals(0, results.getOrDefault(Rank.FIRST, 0));
    }

    @Test
    void 당첨_번호와_5개_번호가_일치하면_3등이다() {
        //given
        List<Lotto> lottos = lottoService.getLottos();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
        int bonusNumber = 7;

        //when
        lottoService.saveLottoRanks(winningNumbers, bonusNumber);

        //then
        Map<Rank, Integer> results = lottoService.getResults();
        assertEquals(0, results.getOrDefault(Rank.FIFTH, 0));
        assertEquals(0, results.getOrDefault(Rank.FOURTH, 0));
        assertEquals(1, results.getOrDefault(Rank.THIRD, 0));
        assertEquals(0, results.getOrDefault(Rank.SECOND, 0));
        assertEquals(0, results.getOrDefault(Rank.FIRST, 0));
    }

    @Test
    void 당첨_번호와_5개_번호가_일치하고_보너스_번호가_일치하면_2등이다() {
        //given
        List<Lotto> lottos = lottoService.getLottos();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
        int bonusNumber = 6;

        //when
        lottoService.saveLottoRanks(winningNumbers, bonusNumber);

        //then
        Map<Rank, Integer> results = lottoService.getResults();
        assertEquals(0, results.getOrDefault(Rank.FIFTH, 0));
        assertEquals(0, results.getOrDefault(Rank.FOURTH, 0));
        assertEquals(0, results.getOrDefault(Rank.THIRD, 0));
        assertEquals(1, results.getOrDefault(Rank.SECOND, 0));
        assertEquals(0, results.getOrDefault(Rank.FIRST, 0));
    }

    @Test
    void 당첨_번호와_6개_번호가_일치하면_1등이다() {
        //given
        List<Lotto> lottos = lottoService.getLottos();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        //when
        lottoService.saveLottoRanks(winningNumbers, bonusNumber);

        //then
        Map<Rank, Integer> results = lottoService.getResults();
        assertEquals(0, results.getOrDefault(Rank.FIFTH, 0));
        assertEquals(0, results.getOrDefault(Rank.FOURTH, 0));
        assertEquals(0, results.getOrDefault(Rank.THIRD, 0));
        assertEquals(0, results.getOrDefault(Rank.SECOND, 0));
        assertEquals(1, results.getOrDefault(Rank.FIRST, 0));
    }

    @Test
    void 다섯번째_등수의_당첨금은_5천원이다() {
        //given
        List<Lotto> lottos = lottoService.getLottos();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 8, 9);
        int bonusNumber = 10;
        lottoService.saveLottoRanks(winningNumbers, bonusNumber);

        //when
        long winningAmount = lottoService.calculateWinningAmount();

        //then
        assertEquals(5_000, winningAmount);
    }

    @Test
    void 네번째_등수의_당첨금은_5만원이다() {
        //given
        List<Lotto> lottos = lottoService.getLottos();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 8, 9);
        int bonusNumber = 10;
        lottoService.saveLottoRanks(winningNumbers, bonusNumber);

        //when
        long winningAmount = lottoService.calculateWinningAmount();

        //then
        assertEquals(50_000, winningAmount);
    }

    @Test
    void 세번째_등수의_당첨금은_1백5십만원이다() {
        //given
        List<Lotto> lottos = lottoService.getLottos();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 9);
        int bonusNumber = 10;
        lottoService.saveLottoRanks(winningNumbers, bonusNumber);

        //when
        long winningAmount = lottoService.calculateWinningAmount();

        //then
        assertEquals(1_500_000, winningAmount);
    }

    @Test
    void 두번째_등수의_당첨금은_3천만원이다() {
        //given
        List<Lotto> lottos = lottoService.getLottos();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 9);
        int bonusNumber = 6;
        lottoService.saveLottoRanks(winningNumbers, bonusNumber);

        //when
        long winningAmount = lottoService.calculateWinningAmount();

        //then
        assertEquals(30_000_000, winningAmount);
    }

    @Test
    void 첫번째_등수의_당첨금은_20억원이다() {
        //given
        List<Lotto> lottos = lottoService.getLottos();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        lottoService.saveLottoRanks(winningNumbers, bonusNumber);

        //when
        long winningAmount = lottoService.calculateWinningAmount();

        //then
        assertEquals(2_000_000_000, winningAmount);
    }

    @Test
    void 수익률은_당첨금을_구입금액으로_나눈_뒤_100을_곱한다() {
        //given
        int purchaseAmount = 8_000;
        long winningAmount = 5_000;

        //when
        double profitRate = lottoService.calculateProfitRate(winningAmount, purchaseAmount);

        //then
        assertEquals(62.5, profitRate);
    }
}