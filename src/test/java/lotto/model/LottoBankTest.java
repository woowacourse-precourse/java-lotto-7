package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBankTest {

    @DisplayName("로또 5개가 전부 3등에 당첨되었을 경우")
    @Test
    void 로또가_당첨되었을_경우_1() {
        List<Lotto> myLottos = new ArrayList<>();
        myLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        myLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        myLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        myLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        myLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        myLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 6, 8));
        BonusNumber bonusNumber = new BonusNumber(12);
        LottoBank lottoBank = new LottoBank();
        LottoResult lottoResult = lottoBank.evaluate(winningLotto, myLottos, bonusNumber);
        assertThat(lottoResult).extracting("prizes")
                .isEqualTo(List.of(Prize.THIRD_PRIZE, Prize.THIRD_PRIZE, Prize.THIRD_PRIZE, Prize.THIRD_PRIZE,
                        Prize.THIRD_PRIZE, Prize.THIRD_PRIZE));
    }

    @DisplayName("로또 5개 중 1개가 1등에 당첨되고 나머지는 당첨이 안 될 경우")
    @Test
    void 로또가_당첨되었을_경우_2() {
        List<Lotto> myLottos = new ArrayList<>();
        myLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        myLottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        myLottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        myLottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        myLottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        myLottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(12);
        LottoBank lottoBank = new LottoBank();
        LottoResult lottoResult = lottoBank.evaluate(winningLotto, myLottos, bonusNumber);
        assertThat(lottoResult)
                .extracting("prizes")
                .isEqualTo(
                        List.of(Prize.FIRST_PRIZE,
                                Prize.NO_PRIZE,
                                Prize.NO_PRIZE,
                                Prize.NO_PRIZE,
                                Prize.NO_PRIZE,
                                Prize.NO_PRIZE)
                );
    }

    @DisplayName("복권 5개 중 1개가 1등에 당첨됬을 경우")
    @Test
    void 복권_5개중_1개가_1등에_당첨됬을_경우() {
        LottoResult lottoResult = new LottoResult(
                List.of(Prize.FIRST_PRIZE, Prize.NO_PRIZE, Prize.NO_PRIZE, Prize.NO_PRIZE, Prize.NO_PRIZE));
        LottoBank lottoBank = new LottoBank();
        double actualProfitRate = lottoBank.calculateProfitRate(lottoResult);
        double expectedProfitRate =
                (Prize.FIRST_PRIZE.getMoney() / (Lotto.getLottoPrice() * lottoResult.getLottoCount())) * 100;
        double roundedExpectedProfitRate = Math.round(expectedProfitRate * 100) / 100.0;
        assertThat(actualProfitRate).isEqualTo(roundedExpectedProfitRate);
    }
}