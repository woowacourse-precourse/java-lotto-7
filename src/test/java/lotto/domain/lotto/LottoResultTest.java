package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.utility.generator.RandomIntegerListGenerator;
import lotto.domain.utility.sorting.AscendingSorter;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 랭크의_개수가_올바르게_올라야한다() {

        List<LottoNumber> numbers = new ArrayList<>(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        Lotto lotto = new Lotto(numbers);
        List<Lotto> testLottoBundle = new ArrayList<>(List.of(lotto));
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        BonusNumber bonusNumber = new BonusNumber(new LottoNumber(7));
        LottoBundle lottoBundle = new LottoBundle(testLottoBundle, new RandomIntegerListGenerator(),
                new AscendingSorter());
        LottoResult lottoResult = new LottoResult(new EnumMap<>(Rank.class), BigInteger.ZERO);

        lottoResult.calculate(lottoBundle, winningNumbers, bonusNumber);
        Map<Rank, Integer> rankCount = lottoResult.getRankCount();

        assertThat(rankCount.get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    void 수익률은_잘나와야_한다() {
        //given
        LottoResult lottoResult = new LottoResult(new HashMap<>(), BigInteger.valueOf(5000));

        //when
        Double profitRate = lottoResult.calculateReturnRate(new Investment(BigInteger.valueOf(8000)));

        //then
        assertThat(profitRate).isEqualTo(62.5);
    }

    @Test
    void 수익률_계산_반올림() {
        //given
        LottoResult lottoResult = new LottoResult(new HashMap<>(), BigInteger.valueOf(8234));

        //when
        Double profitRate = lottoResult.calculateReturnRate(new Investment(BigInteger.valueOf(10000)));

        //then
        assertThat(profitRate).isEqualTo(82.3);
    }
}
