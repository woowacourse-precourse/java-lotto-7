package lotto;

import lotto.constant.LottoConfig;
import lotto.util.InputHandler;
import lotto.util.OutputHandler;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // 구입 금액 입력
        Purchase purchase = InputHandler.repeatInputOrderPrice();

        // 로또 발권
        LottoTicketing lottoTicketing = new LottoTicketing();
        Lottos lottos = lottoTicketing.issueTickets(purchase);
        OutputHandler.printCount(purchase.getCost() / 1000);
        OutputHandler.printTicket(lottos);

        // 당첨 번호 입력
        Lotto lotto = InputHandler.repeatInputLottoNumber();
        Bonus bonus = InputHandler.repeatInputBonusNumber(lotto);

        // 로또 결과 계산
        LottoPrize lottoPrize = new LottoPrize(lotto, bonus);
        Map<LottoConfig.Rank, Integer> result = lottoPrize.determineLottoPrizes(lottos);
        Double rateOfReturn = lottoPrize.calculateRateOfReturn(result, purchase);

        OutputHandler.printLottoResult(result);
        OutputHandler.printRateOfReturn(rateOfReturn);
    }
}
