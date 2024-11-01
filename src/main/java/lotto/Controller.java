package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {

    public static void run() {
        int money = getPurchaseAmount();
        int lottoCount = LottoService.calculateLottoCount(money);
        List<Lotto> lottoTickets = LottoService.generateLottos(lottoCount);
        OutputView.printLottos(lottoTickets);

        Lotto winningLotto = getWinningLotto();
        int BonusLottoNumber = getBonusNumber(winningLotto);

        Map<LottoRank, Integer> LottoStatistics = LottoService.calculateStatistics(lottoTickets, winningLotto, BonusLottoNumber);
        OutputView.printWinningStatistics(LottoStatistics);

        long totalPrize = LottoService.calculateTotalPrize(LottoStatistics);
        double rateOfReturn = LottoService.calculateRateOfReturn(totalPrize,money);
        OutputView.printRateOfReturn(rateOfReturn);
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
            String input = InputView.readWinningNumbers();
            try {
                List<Integer> winningNumbers = parseWinningNumbers(input);
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String input = InputView.readBonusNumber();
                return InputValidator.validateBonusNumber(input, winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}