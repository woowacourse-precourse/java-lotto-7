package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinAmount;
import lotto.service.LottoService;
import org.junit.jupiter.api.Test;

public class ServiceTest {

    @Test
    void 정상_당첨번호가_입력되면_정수형_리스트로_반환한다() {
        LottoService lottoService = new LottoService();

        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> inputWinNumber = lottoService.numberSplit("1,2,3,4,5,6");  // buyLotto의 인자를 직접 지정
        assertEquals(winNumber, inputWinNumber);
    }

    @Test
    void 하나도_당첨되지_않으면_결과_내역이_모두_0이다() {
        Lotto[] lottos = {new Lotto(List.of(10, 20, 25, 30, 40, 45))};
        List<Integer> winNumbers = List.of(1, 2, 3, 25, 30, 4);
        int bonusNumber = 7;

        LottoService lottoService = new LottoService();
        EnumMap<WinAmount, Integer> result = lottoService.compare_My_Win(lottos, winNumbers, bonusNumber);

        assertEquals(0, result.getOrDefault(WinAmount.Three, 0));
        assertEquals(0, result.getOrDefault(WinAmount.Four, 0));
        assertEquals(0, result.getOrDefault(WinAmount.Five, 0));
        assertEquals(0, result.getOrDefault(WinAmount.FiveBonus, 0));
        assertEquals(0, result.getOrDefault(WinAmount.Six, 0));
    }

    @Test
    void 결과가_5개가_일치하고_보너스도_일치하면_2등_당첨이다() {
        Lotto[] myLotto = {new Lotto(List.of(10, 20, 25, 30, 40, 45))};
        List<Integer> winNumbers = List.of(10, 20, 25, 30, 40, 7);
        int bonusNumber = 45;

        LottoService lottoService = new LottoService();
        EnumMap<WinAmount, Integer> result = lottoService.compare_My_Win(myLotto, winNumbers, bonusNumber);

        assertEquals(1, result.getOrDefault(WinAmount.FiveBonus, 1));
    }

    @Test
    void 당첨금액_대비_수익률이_올바른지_점검한다() {
        Lotto[] myLotto = {new Lotto(List.of(10, 20, 25, 30, 40, 45))};
        List<Integer> winNumbers = List.of(10, 20, 25, 1, 2, 3);
        int bonusNumber = 5;
        double expectProfitPercentage = 500.0;
        double lottoAttemptCount = 1.0;

        LottoService lottoService = new LottoService();
        EnumMap<WinAmount, Integer> result = lottoService.compare_My_Win(myLotto, winNumbers, bonusNumber);
        double profitPercentage = lottoService.resultSum(result, lottoAttemptCount);
        assertEquals(expectProfitPercentage, profitPercentage);
    }


}
