package lotto;

import java.util.List;
import lotto.service.LottoService;
import lotto.service.UserInputService;

public class MainProgram {
    private final UserInputService userInputService = new UserInputService();
    private final LottoService lottoService = new LottoService();

    public void run() {
        int amount = getAmount();
        int count = amount / 1000;
        List<Lotto> purchasedLotto = lottoService.getPurchasedLotto(count);
        View.showLottoNumbers(count, purchasedLotto);
        Lotto WinningNumber = getWinningNumber();
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

    }
}
