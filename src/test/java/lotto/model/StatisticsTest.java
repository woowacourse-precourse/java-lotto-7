package lotto.model;

import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class StatisticsTest {
    private Statistics statistics;
    @Test
    void 당첨_번호와_보너스_번호가_겹치면_예외를_발생한다(){
        assertThatThrownBy(() -> new Statistics(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호의_크기가_6이_아니면_예외를_발생한다(){
        assertThatThrownBy(()-> new Statistics(List.of(1,2,3,4,5,7,8), 12))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_중복이면_예외를_발생한다(){
        assertThatThrownBy(()-> new Statistics(List.of(1,2,3,4,5,5), 9))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_1과_45사이_수가_아니면_예외를_발생한다(){
        assertThatThrownBy(()-> new Statistics(List.of(1,2,3,4,5,77), 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 여섯개의_로또를_구매하고_그에_대한_결과를_출력한다(){
        statistics = new Statistics(List.of(5,13,15,31,2,20), 33);
        List<Lotto> issuedLotteries = List.of(
                new Lotto(List.of(5, 13, 15, 31, 33, 41)),
                new Lotto(List.of(11, 14, 15, 30, 37, 42)),
                new Lotto(List.of(10, 11, 14, 32, 36, 38)),
                new Lotto(List.of(7, 16, 20, 33, 40, 41)),
                new Lotto(List.of(14, 20, 27, 33, 38, 40)),
                new Lotto(List.of(2, 16, 28, 33, 41, 44)));
        Map<LottoResult, Integer> testLottoResult = Stream.of(new Object[][]{
                {LottoResult.FIRST, 0},
                {LottoResult.SECOND, 0},
                {LottoResult.THIRD, 0},
                {LottoResult.FOURTH, 0},
                {LottoResult.FIFTH, 0},
                {LottoResult.NONE, 0}
        }).collect(toMap(data -> (LottoResult) data[0], data -> (Integer) data[1]));

        testLottoResult.replace(LottoResult.FOURTH, 1);
        testLottoResult.replace(LottoResult.NONE, 5);


        Map<LottoResult, Integer> lottoResults = statistics.getResult(issuedLotteries);


        assertEquals(lottoResults, testLottoResult);
    }
    @Test
    void 당첨_결과를_보고_수익률을_계산할_수_있다(){
        statistics = new Statistics(List.of(5,13,15,31,2,20), 33);
        Float expectedRateOfReturn = 833.3333F;
        List<Lotto> issuedLotteries = List.of(
                new Lotto(List.of(5, 13, 15, 31, 33, 41)),
                new Lotto(List.of(11, 14, 15, 30, 37, 42)),
                new Lotto(List.of(10, 11, 14, 32, 36, 38)),
                new Lotto(List.of(7, 16, 20, 33, 40, 41)),
                new Lotto(List.of(14, 20, 27, 33, 38, 40)),
                new Lotto(List.of(2, 16, 28, 33, 41, 44)));
        Map<LottoResult, Integer> testLottoResult = Stream.of(new Object[][]{
                {LottoResult.FIRST, 0},
                {LottoResult.SECOND, 0},
                {LottoResult.THIRD, 0},
                {LottoResult.FOURTH, 0},
                {LottoResult.FIFTH, 0},
                {LottoResult.NONE, 0}
        }).collect(toMap(data -> (LottoResult) data[0], data -> (Integer) data[1]));
        testLottoResult.replace(LottoResult.FOURTH, 1);
        testLottoResult.replace(LottoResult.NONE, 5);

        Float returnRate = statistics.getRateOfReturn(testLottoResult);

        assertEquals(returnRate, expectedRateOfReturn);
    }
}
