package lotto;

import java.util.List;
import lotto.service.LottoService;
import lotto.service.UserInputService;
import lotto.service.WinningService;

public class MainProgram {
    private final UserInputService userInputService = new UserInputService();
    private final LottoService lottoService = new LottoService();
    private final WinningService winningService = new WinningService();

    public void run() {
        int amount = getAmount();
        int count = amount / 1000;
        List<Lotto> purchasedLotto = lottoService.getPurchasedLotto(count);
        View.showLottoNumbers(count, purchasedLotto);
        Lotto winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber();
        List<Integer> result = winningService.getResult(purchasedLotto, winningNumber, bonusNumber);
        String increase = getIncrease(result, amount);
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

    private String getIncrease(List<Integer> result, int amount) {
        double increase = 5000 * result.get(0) + 50000 * result.get(1) +
                1500000 * result.get(2) + 30000000 * result.get(3) + 2000000000 * result.get(4);

        if(increase == 0) {
            return "0.0";
        }

        increase = increase / amount * 100;
        return String.format("%.1f", increase);
    }
}
