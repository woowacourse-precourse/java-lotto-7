package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCheckerTest {


    LottoChecker lottoChecker;

    Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
    Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
    Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
    Lotto lotto4 = new Lotto(List.of(1, 8, 11, 31, 41, 42));
    Lotto lotto5 = new Lotto(List.of(13, 14, 16, 38, 42, 45));
    Lotto lotto6 = new Lotto(List.of(7, 11, 30, 40, 42, 43));
    Lotto lotto7 = new Lotto(List.of(2, 13, 22, 32, 38, 45));
    Lotto lotto8 = new Lotto(List.of(1, 3, 5, 14, 22, 45));

    List<Lotto> lottoes = new ArrayList<>();

    Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    int bonusNumber = 7;

    @BeforeEach
    void setup() {
        Map<Integer, Integer> winningPrice = new HashMap<>();
        Map<Integer, Integer> bonusWinningPrice = new HashMap<>();
        winningPrice.put(3, 5000);
        winningPrice.put(4, 50000);
        winningPrice.put(5, 1500000);
        winningPrice.put(6, 2000000000);
        bonusWinningPrice.put(5, 30000000);

        lottoChecker = new LottoChecker(winningPrice, bonusWinningPrice);

        lottoes.add(lotto1);
        lottoes.add(lotto2);
        lottoes.add(lotto3);
        lottoes.add(lotto4);
        lottoes.add(lotto5);
        lottoes.add(lotto6);
        lottoes.add(lotto7);
        lottoes.add(lotto8);
    }

    @Test
    @DisplayName("로또 당첨번호와 매치 테스트")
    void 로또_매치_테스트() {
        lottoChecker.match(winningLotto, lottoes, bonusNumber);

        Assertions.assertThat(lottoChecker.matchingCount[3]).isEqualTo(1);
        Assertions.assertThat(lottoChecker.matchingCount[4]).isEqualTo(0);
        Assertions.assertThat(lottoChecker.matchingCount[5]).isEqualTo(0);
        Assertions.assertThat(lottoChecker.bonusMatchingCount[5]).isEqualTo(1);
        Assertions.assertThat(lottoChecker.matchingCount[6]).isEqualTo(0);
    }

    @Test
    @DisplayName("총 당첨 금액 계산 테스트")
    void 총_당첨_금액_계산() {
        lottoChecker.match(winningLotto, lottoes, bonusNumber);
        Assertions.assertThat(
                lottoChecker.calculateTotalWinningPrizeMoney())
                .isEqualTo(lottoChecker.prizeMoney.get(3)
                + lottoChecker.bonusPrizeMoney.get(5));
    }

    @Test
    @DisplayName("총 수익률 계산 테스트")
    void 총_수익률_계산() {
        lottoChecker.match(winningLotto, lottoes, bonusNumber);
        Assertions.assertThat(
                lottoChecker.calculateProfitRate(lottoes.size(), lottoChecker.calculateTotalWinningPrizeMoney()))
                .isEqualTo("375062.5");
    }
}
