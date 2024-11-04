package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 1. 구입 금액 입력 및 검증
        int amount = readValidPurchaseAmount(inputView, outputView);

        // 2. 로또 구매
        Purchase purchase = new Purchase(amount);
        LottoGame lottoGame = new LottoGame();
        lottoGame.buyLottos(purchase.getLottoCount());
        outputView.printLottos(lottoGame.getLottos());

        // 3. 당첨 번호 입력 및 검증
        WinningNumbers winningNumbers = readWinningNumbers(inputView, outputView);

        // 4. 보너스 번호 입력 및 검증
        BonusNumber bonusNumber = readBonusNumber(inputView, outputView, winningNumbers);

        // 5. 당첨 결과 계산
        Statistics statistics = new Statistics(lottoGame.getLottos(), winningNumbers, bonusNumber, purchase);

        // 6. 당첨 내역 및 수익률 출력
        outputView.printStatistics(statistics.getResults(), statistics.calculateYield());
    }

    private static int readValidPurchaseAmount(InputView inputView, OutputView outputView) {
        while (true) {
            try {
                int amount = inputView.readPurchaseAmount();
                return new Purchase(amount).getAmount();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private static WinningNumbers readWinningNumbers(InputView inputView, OutputView outputView) {
        while (true) {
            try {
                String input = inputView.readWinningNumbers();
                return new WinningNumbers(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private static BonusNumber readBonusNumber(InputView inputView, OutputView outputView,
                                               WinningNumbers winningNumbers) {
        while (true) {
            try {
                int number = inputView.readBonusNumber();
                return new BonusNumber(number, winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
