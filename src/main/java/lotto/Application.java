package lotto;

import lotto.constant.LottoConfig;
import lotto.util.InputHandler;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // 우승 번호 입력 받기
        Purchase purchase = InputHandler.repeatInputOrderPrice();
        Lotto lotto = InputHandler.repeatInputLottoNumber();
        Bonus bonus = InputHandler.repeatInputBonusNumber(lotto);

        // 로또 발권
        LottoTicketing lottoTicketing = new LottoTicketing();
        Lottos lottos = lottoTicketing.issueTickets(purchase);

        // 로또 결과
        LottoPrize lottoPrize = new LottoPrize(lotto, bonus);
        Map<LottoConfig.Rank, Integer> result = lottoPrize.determineLottoPrizes(lottos);
        Double rateOfReturn = lottoPrize.calculateRateOfReturn(result, purchase);
    }
}
