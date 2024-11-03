package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.prizelotto.FifthPrizeLotto;
import lotto.domain.prizelotto.FourthPrizeLotto;
import lotto.domain.prizelotto.PrizeLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("상금에 관한 기능을 확인한다.")
class PrizeNumberTest {

    WinNumbers winNumbers;
    List<Integer> lottoNumbers;
    FifthPrizeLotto fifthPrizeLotto;
    FourthPrizeLotto fourthPrizeLotto;
    PrizeNumber prizeNumber;

    @BeforeEach
    void setUp() {
        winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        lottoNumbers = List.of(1, 2, 3, 7, 8, 9);
        fifthPrizeLotto = new FifthPrizeLotto();
        fourthPrizeLotto = new FourthPrizeLotto();
        prizeNumber = new PrizeNumber(List.of(fourthPrizeLotto, fifthPrizeLotto));
    }

    @Test
    @DisplayName("일치하는 숫자를 세는 기능을 확인한다.")
    void countMatchNumber() {
        prizeNumber.countMatchNumber(lottoNumbers, winNumbers);
        assertThat(fifthPrizeLotto.getCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("총 금액 계산 기능을 확인한다.")
    void calculateTotalPrize() {
        countMatchNumber();
        assertThat(prizeNumber.calculateTotalPrize()).isEqualTo(5000);
    }

    @Test
    @DisplayName("내림차순 정렬을 확인한다.")
    void sortByRank() {
        List<PrizeLotto> prizeLottos = prizeNumber.sortByRank();
        assertThat(prizeLottos).isEqualTo(List.of(fifthPrizeLotto, fourthPrizeLotto));
    }
}