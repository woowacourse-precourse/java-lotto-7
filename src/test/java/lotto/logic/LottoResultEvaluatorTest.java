package lotto.logic;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.input.Bonus;
import lotto.input.Lotto;
import lotto.input.Purchase;
import org.junit.jupiter.api.Test;

class LottoResultEvaluatorTest {

    @Test
    void 당첨_결과_맵_검증_테스트() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        Bonus bonus = new Bonus(winningLotto, 7);
        Purchase purchase = new Purchase(6000);

        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        List<Lotto> lottos = generateLotto();
        lottoNumbersGenerator.setLottos(lottos);

        //when
        LottoResultEvaluator evaluator = new LottoResultEvaluator();
        evaluator.evaluateLottoResults(winningLotto, lottoNumbersGenerator, bonus, purchase);

        //then
        Map<Integer, Integer> result = evaluator.getResult();
        assertThat(result.get(1)).isEqualTo(1); // 1등 1개
        assertThat(result.get(2)).isEqualTo(1); // 2등 1개
        assertThat(result.get(3)).isEqualTo(1); // 3등 1개
        assertThat(result.get(4)).isEqualTo(1); // 4등 1개
        assertThat(result.get(5)).isEqualTo(1); // 5등 1개
    }

    @Test
    void 당첨내역_수익_계산_테스트() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        Bonus bonus = new Bonus(winningLotto, 7);
        Purchase purchase = new Purchase(6000);

        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        List<Lotto> lottos = generateLotto();
        lottoNumbersGenerator.setLottos(lottos);

        //when
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator();
        lottoResultEvaluator.evaluateLottoResults(winningLotto, lottoNumbersGenerator, bonus, purchase);


        //then
        assertThat(2031555000).isEqualTo(lottoResultEvaluator.getProfit());
    }

    @Test
    void 당첨내역_작은_수익률_계산_테스트() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        Bonus bonus = new Bonus(winningLotto, 7);
        Purchase purchase = new Purchase(6000);

        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        List<Lotto> lottos = generateLottoLittleProfit();
        lottoNumbersGenerator.setLottos(lottos);

        //when
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator();
        lottoResultEvaluator.evaluateLottoResults(winningLotto, lottoNumbersGenerator, bonus, purchase);


        //then
        assertThat(String.valueOf(166.7)).isEqualTo(lottoResultEvaluator.getReturnRate().toPlainString());
    }

    @Test
    void 당첨내역_큰_수익률_계산_테스트() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        Bonus bonus = new Bonus(winningLotto, 7);
        Purchase purchase = new Purchase(6000);

        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        List<Lotto> lottos = generateLotto();
        lottoNumbersGenerator.setLottos(lottos);

        //when
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator();
        lottoResultEvaluator.evaluateLottoResults(winningLotto, lottoNumbersGenerator, bonus, purchase);

        //then
        BigDecimal expectedRate = new BigDecimal("33859250.0");
        assertThat(expectedRate).isEqualTo(lottoResultEvaluator.getReturnRate());
    }

    private List<Lotto> generateLotto() {
        List<Integer> one = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> two = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> three = List.of(1, 2, 3, 4, 5, 8);
        List<Integer> four = List.of(1, 2, 3, 4, 8, 9);
        List<Integer> five = List.of(1, 2, 3, 8, 9, 10);
        List<Integer> six = List.of(1, 2, 8, 9, 10, 11);

        return List.of(
                new Lotto(one),
                new Lotto(two),
                new Lotto(three),
                new Lotto(four),
                new Lotto(five),
                new Lotto(six)
        );
    }

    private List<Lotto> generateLottoLittleProfit() {
        List<Integer> one = List.of(1, 2, 3, 8, 9, 10);
        List<Integer> two = List.of(1, 2, 3, 8, 9, 11);
        List<Integer> three = List.of(1, 2, 8, 9, 10, 11);
        List<Integer> four = List.of(1, 2, 8, 9, 10, 12);
        List<Integer> five = List.of(1, 2, 8, 9, 10, 13);
        List<Integer> six = List.of(1, 2, 8, 9, 10, 14);

        return List.of(
                new Lotto(one),
                new Lotto(two),
                new Lotto(three),
                new Lotto(four),
                new Lotto(five),
                new Lotto(six)
        );
    }
}