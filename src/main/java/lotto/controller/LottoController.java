package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.UserMoney;
import lotto.domain.WinningNumbers;
import lotto.service.LottoMachine;
import lotto.service.InputHandler;
import lotto.service.PrizeCalculator;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        // 구매 금액 입력
        UserMoney userMoney = InputHandler.inputUserMoney();

        // 구매 금액에 따른 로또 발행
        List<Lotto> issuedLottos = LottoMachine.issueLotto(userMoney);

        // 발행된 로또 출력
        OutputView.printIssuedLottos(issuedLottos);

        // 당첨 번호 및 보너스 번호 입력
        WinningNumbers winningNumbers = InputHandler.inputWinningNumbers();

        // 등수별 당첨 로또 계산
        Map<Integer, Integer> prizeCounts = PrizeCalculator.calculatePrizes(issuedLottos, winningNumbers);

        // 등수별 당첨 개수 출력
        OutputView.printPrizeCounts(prizeCounts);

        // 수익률 계산
        double profitRate = PrizeCalculator.calculateProfitRate(prizeCounts, userMoney);

        // 수익률 출력
        OutputView.printProfitRate(profitRate);
    }
}
