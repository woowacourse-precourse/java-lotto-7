package lotto.controller;

import lotto.model.*;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final LottoFactory lottoFactory;

    public Controller(InputView inputView, OutputView outputView,
                      InputValidator inputValidator, LottoFactory lottoFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.lottoFactory = lottoFactory;
    }

    public void run() {
        try {
            // 구입 금액 입력
            Money money = getMoney();
            List<Lotto> lottos = lottoFactory.createLottos(money);
            outputView.printPurchaseAmount(lottos.size());
            outputView.printLottos(lottos);

            // 당첨 번호 입력
            WinningNumbers winningNumbers = getWinningNumbers();
            // 보너스 번호 입력
            BonusNumber bonusNumber = getBonusNumber(winningNumbers);

            // 당첨 결과 계산
            LottoResult result = calculateResult(lottos, winningNumbers, bonusNumber);
            // 결과 출력
            outputView.printResult(result);
            outputView.printProfit(result.calculateProfit(money));

        } catch (Exception e) {
            outputView.printError(e.getMessage());
        }
    }

    private Money getMoney() {
        while (true) {
            try {
                String input = inputView.readMoney();
                return new Money(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                String input = inputView.readWinningNumbers();
                return new WinningNumbers(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String input = inputView.readBonusNumber();
                return new BonusNumber(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private LottoResult calculateResult(List<Lotto> lottos, WinningNumbers winningNumbers,
                                        BonusNumber bonusNumber) {
        return new LottoResult(lottos, winningNumbers, bonusNumber);
    }
}
