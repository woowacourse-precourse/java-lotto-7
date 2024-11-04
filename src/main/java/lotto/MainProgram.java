package lotto;

import java.util.List;
import lotto.model.Lotto;
import lotto.service.LottoGenerator;
import lotto.service.ProfitCalculator;
import lotto.service.UserInputService;
import lotto.service.LottoResultService;
import lotto.view.View;

public class MainProgram {
    private final UserInputService userInputService = new UserInputService();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final LottoResultService lottoResultService = new LottoResultService();
    private final ProfitCalculator profitCalculator = new ProfitCalculator();

    public void run() {
        int amount = getAmount();
        int count = amount / 1000;
        List<Lotto> purchasedLotto = lottoGenerator.getPurchasedLotto(count);
        View.showLottoNumbers(count, purchasedLotto);
        Lotto winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber();
        List<Integer> result = lottoResultService.getResult(purchasedLotto, winningNumber, bonusNumber);
        String increase = profitCalculator.calculateProfitRate(result, amount);
        View.showResult(result, increase);
    }

    public int getAmount() {
        while(true) {
            try {
                String inputAmount = View.purchaseAmountView();
                return userInputService.getPurchaseAmount(inputAmount);
            } catch (Exception e) {
                String message = e.getMessage();
                System.out.println(message);
            }
        }
    }

    public Lotto getWinningNumber() {
        while(true) {
            try {
                String inputNumber = View.winningNumberView();
                return userInputService.getWinningLotto(inputNumber);
            } catch (Exception e) {
                String message = e.getMessage();
                System.out.println(message);
            }
        }
    }

    private int getBonusNumber() {
        while(true) {
            try {
                String inputNumber = View.bonusNumberView();
                return userInputService.getBonus(inputNumber);
            } catch (Exception e) {
                String message = e.getMessage();
                System.out.println(message);
            }
        }
    }
}
