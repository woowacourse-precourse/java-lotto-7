package lotto.domain;

import lotto.policy.RankingPolicy;
import lotto.service.LottoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class LottoServiceTest {

    @Test
    void getLottoList() {
        int lottoTickets = 5;
        List<Lotto> lottos = LottoService.generateLottoList(lottoTickets);
        Assertions.assertEquals(lottos.size(), 5);
    }
    @Test
    void printResult() {
        //given
        int bonusNumber = 7;
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new ArrayList<>(List.of(3, 4, 5, 6, 7, 1)));

        Lotto lotto1 = new Lotto(lottoNumbers.get(0));
        Set<Integer> lottoNumbersSet = lotto1.getNumbers();
        lottoNumbersSet.retainAll(winningNumbers);
        

        int matchCount = lottoNumbersSet.size();
        boolean bonusMatch = lotto1.hasBonusNumber(bonusNumber);

        RankingPolicy policy = RankingPolicy.getPolicy(matchCount, bonusMatch);
        int prize = policy.getPrize();
        System.out.println(prize);
        Assertions.assertEquals(30000000, prize);
        Assertions.assertEquals(RankingPolicy.getPolicy(
                matchCount, bonusMatch), RankingPolicy.SECOND
        );
    }
    @Test
    void printBenefitTest() {
        //given
        int investment = 8000;
        int prize = 3000;

        // when
        double value = ((double) investment - prize) / investment * 100;
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal.setScale(2, RoundingMode.HALF_UP);

        //then
        Assertions.assertEquals(62.5, bigDecimal.doubleValue());
    }
}
