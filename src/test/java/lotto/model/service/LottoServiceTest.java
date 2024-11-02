package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoWinningNumbers;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService(new LottoGenerator());

    @Test
    void 구매금액만큼_로또_생성() {
        //given
        int lottoPurchaseAmount = 5000;

        //when
        List<Lotto> lottos = lottoService.createLottos(5000);

        //then
        assertThat(lottos).hasSize(5);
    }

    @Test
    void 당첨자_뽑기() {
        //given
        List<Integer> numbers00 = new ArrayList<>(Arrays.asList(8, 9, 10, 11, 12, 13)); //일치 0, 보너스 0
        List<Integer> numbers10 = new ArrayList<>(Arrays.asList(1, 8, 9, 10, 11, 12)); //일치 1, 보너스 0
        List<Integer> numbers20 = new ArrayList<>(Arrays.asList(1, 2, 10, 11, 12, 13)); //일치 2, 보너스 0
        List<Integer> numbers30 = new ArrayList<>(Arrays.asList(1, 2, 3, 11, 12, 13)); //일치 3, 보너스 0
        List<Integer> numbers40 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 12, 13)); //일치 4, 보너스 0
        List<Integer> numbers50 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 13)); //일치 5, 보너스 0
        List<Integer> numbers60 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)); //일치 6, 보너스 0
        List<Integer> numbers01 = new ArrayList<>(Arrays.asList(7, 9, 10, 11, 12, 13)); //일치 0, 보너스 1
        List<Integer> numbers11 = new ArrayList<>(Arrays.asList(1, 7, 9, 10, 11, 12)); //일치 1, 보너스 1
        List<Integer> numbers21 = new ArrayList<>(Arrays.asList(1, 2, 7, 11, 12, 13)); //일치 2, 보너스 1
        List<Integer> numbers31 = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 12, 13)); //일치 3, 보너스 1
        List<Integer> numbers41 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 7, 13)); //일치 4, 보너스 1
        List<Integer> numbers51 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)); //일치 5, 보너스 1


        List<Integer> winning = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        List<Lotto> lotts = new ArrayList<>();
        lotts.add(new Lotto(numbers00));
        lotts.add(new Lotto(numbers10));
        lotts.add(new Lotto(numbers20));
        lotts.add(new Lotto(numbers30));
        lotts.add(new Lotto(numbers40));
        lotts.add(new Lotto(numbers50));
        lotts.add(new Lotto(numbers60));
        lotts.add(new Lotto(numbers01));
        lotts.add(new Lotto(numbers11));
        lotts.add(new Lotto(numbers21));
        lotts.add(new Lotto(numbers31));
        lotts.add(new Lotto(numbers41));
        lotts.add(new Lotto(numbers51));

        LottoWinningNumbers winningNumbers = new LottoWinningNumbers(winning, bonusNumber);

        //when
        List<LottoPrize> lottoPrizes = lottoService.drawWinners(lotts, winningNumbers);

        //then
        assertThat(lottoPrizes).hasSize(7);
    }

    @Test
    public void 상금_수익률_계산() {
        //given
        List<LottoPrize> lottoPrizes = new ArrayList<>();
        lottoPrizes.add(LottoPrize.FIFTH);
        lottoPrizes.add(LottoPrize.FOURTH);
        int purchaseAmount = 7000;

        //when
        double profitRatio = lottoService.calculateProfitRatio(purchaseAmount, lottoPrizes);

        //then
        double expectedRatio = 785.7;
        assertThat(profitRatio).isEqualTo(expectedRatio);

    }

}