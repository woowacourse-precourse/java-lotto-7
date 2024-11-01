package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.prizelotto.FifthPrizeLotto;
import lotto.domain.prizelotto.FourthPrizeLotto;
import lotto.domain.prizelotto.PrizeLotto;
import org.junit.jupiter.api.Test;

class PrizeNumberTest {

    WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
    List<Integer> lottoNumbers = List.of(1, 2, 3, 7, 8, 9);
    FifthPrizeLotto fifthPrizeLotto = new FifthPrizeLotto();
    FourthPrizeLotto fourthPrizeLotto = new FourthPrizeLotto();
    PrizeNumber prizeNumber = new PrizeNumber(List.of(fourthPrizeLotto, fifthPrizeLotto));

    @Test
    void countMatchNumber() {
        prizeNumber.countMatchNumber(lottoNumbers, winNumbers);
        assertThat(fifthPrizeLotto.getCount()).isEqualTo(1);
    }

    @Test
    void calculateTotalPrize() {
        countMatchNumber();
        assertThat(prizeNumber.calculateTotalPrize()).isEqualTo(5000);
    }

    @Test
    void sortByRank() {
        List<PrizeLotto> prizeLottos = prizeNumber.sortByRank();
        assertThat(prizeLottos).isEqualTo(List.of(fifthPrizeLotto, fourthPrizeLotto));
    }
}