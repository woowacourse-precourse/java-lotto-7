package lotto;

import lotto.service.InputService;
import lotto.service.Separator;

import java.util.List;

public class Application {
    private static final int TICKET_PRICE = 1000;
    private static final InputService inputService = new InputService();
    private static final Separator separator = new Separator();

    public static void main(String[] args) {
        int purchaseAmount = inputService.inputPurchaseAmount(TICKET_PRICE);
        int purchaseCount = purchaseAmount / TICKET_PRICE;

        String winningNumbers = inputService.inputWinningNumbers();
        List<Integer> separatedNumbers = separator.separate(winningNumbers);

        int bonusNumber = inputService.inputBonusNumber();
    }
}
