package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    public static void main(String[] args) {
        int money = getPurchaseAmount();
        int lottoCount = LottoService.calculateLottoCount(money);
        List<Lotto> lottoTickets = LottoService.generateLottos(lottoCount);
        OutputView.printLottos(lottoTickets);
        Lotto WinningLotto = getWinningLotto();
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

    private static Lotto getWinningLotto() {
        while (true) {
            try {
                String input = InputView.readWinningNumbers();
                Lotto lotto = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
                return lotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}