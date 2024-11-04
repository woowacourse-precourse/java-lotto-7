package lotto.service;

import lotto.enums.Ranking;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.enums.Ranking.*;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @DisplayName("로또 번호 비교후 맵에 결과값 저장")
    @Test
    void compareLottoWithWinningTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)),new BonusNumber(7,lotto));
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        Map<Ranking, Integer> result = lottoService.compareLottosWithWinning(lottos, winningNumber);
        Assertions.assertThat(result.get(FIRST)).isEqualTo(1);
        Assertions.assertThat(result.get(SECOND)).isEqualTo(1);
        Assertions.assertThat(result.get(THIRD)).isEqualTo(0);
        Assertions.assertThat(result.get(FIFTH)).isEqualTo(1);
    }


    @DisplayName("수익률 계산")
    @Test
    void calculateReturnRateTest() {
        Money money = new Money(2000);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)),new BonusNumber(7,lotto));
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 9, 10));
        lottos.add(lotto1);
        lottos.add(lotto2);
        Map<Ranking, Integer> result = lottoService.compareLottosWithWinning(lottos, winningNumber);
        double returnMoney = 55000;
        Assertions.assertThat(lottoService.calculateReturnRate(result, money))
                .isEqualTo(returnMoney / money.getMoney() * 100);


    }

}