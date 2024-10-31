package lotto;

import java.util.List;

public class Controller {

    public static void main(String[] args) {
int money = getPurchaseAmount();
        int lottoCount = LottoService.calculateLottoCount(money);
        List<Lotto> lottoTickets = LottoService.generateLottos(lottoCount);
        OutputView.printLottos(lottoTickets);
    }

    private static int getPurchaseAmount() {
        while (true) {
            String input = InputView.readPurchaseAmount();
            try {
                InputValidator.validatePurchaseAmount(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}