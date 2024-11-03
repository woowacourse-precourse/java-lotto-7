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
}