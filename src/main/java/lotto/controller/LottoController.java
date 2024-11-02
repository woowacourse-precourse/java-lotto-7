package lotto.controller;

import java.util.List;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;
import lotto.domain.ProfitCalculator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void start() {
        Money money = getMoney();
        outputView.showTicket(money.getTicket());

        List<Lotto> lottos = getLottos(money);
        outputView.showLottos(lottos);

        WinningLotto winningLotto = getWinningLotto();

        double profitRatio = calculateResult(money, lottos, winningLotto);
        outputView.showProfitRate(profitRatio);
    }

    private Money getMoney() {
        while (true) {
            try {
                int moneyInput = inputView.inputMoney();
                return new Money(moneyInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> getLottos(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();

        while (true) {
            try {
                return lottoGenerator.generateLottoGroup(money.getTicket());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningLotto getWinningLotto() {
        while (true) {
            List<Integer> winningNumbers = inputView.inputWinningNumber();
            int bonusNumber = inputView.inputBonusNumber();

            try {
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private double calculateResult(Money money, List<Lotto> lottos, WinningLotto winningLotto) {
        PrizeResult prizeResult = new PrizeResult(lottos, winningLotto);

        System.out.println("당첨 통계\n---");
        for (Prize prize : Prize.values()) {
            if (prize == Prize.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n",
                        prize.getCount(),
                        prize.getPrize(),
                        prizeResult.getPrizeCount().get(prize));
            }else{
                System.out.printf("%d개 일치 (%,d원) - %d개\n",
                        prize.getCount(),
                        prize.getPrize(),
                        prizeResult.getPrizeCount().get(prize));
            }
        }
        ProfitCalculator profitCalculator = new ProfitCalculator(money, prizeResult);
        return profitCalculator.calculateProfitRatio();
    }
}
