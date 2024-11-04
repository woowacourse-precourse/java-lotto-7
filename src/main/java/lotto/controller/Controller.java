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
        validateDependencies(inputView, outputView, inputValidator, lottoFactory);
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.lottoFactory = lottoFactory;
    }

    private void validateDependencies(InputView inputView, OutputView outputView,
                                      InputValidator inputValidator, LottoFactory lottoFactory) {
        if (inputView == null || outputView == null ||
                inputValidator == null || lottoFactory == null) {
            throw new IllegalStateException("필수 의존성이 초기화되지 않았습니다.");
        }
    }

    private Money getMoney() {
        while (true) {
            try {
                String input = inputView.readMoney();
                return new Money(input, inputValidator);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                String input = inputView.readWinningNumbers();
                return new WinningNumbers(input, inputValidator);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String input = inputView.readBonusNumber();
                return new BonusNumber(input, winningNumbers, inputValidator);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    public void run() {
        try {
            Money money = getMoney();
            List<Lotto> lottos = lottoFactory.createLottos(money);
            validateLottos(lottos);

            outputView.printPurchaseAmount(lottos.size());
            outputView.printLottos(lottos);

            WinningNumbers winningNumbers = getWinningNumbers();
            BonusNumber bonusNumber = getBonusNumber(winningNumbers);

            LottoResult result = calculateResult(lottos, winningNumbers, bonusNumber);
            outputView.printResult(result);
            outputView.printProfit(result.calculateProfit(money));
        } catch (IllegalStateException e) {
            outputView.printError(e.getMessage());
        }
    }

    private void validateLottos(List<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new IllegalStateException("로또 생성에 실패했습니다.");
        }
        lottos.forEach(lotto -> inputValidator.validateLottoNumbers(lotto.getNumbers()));
    }

    private LottoResult calculateResult(List<Lotto> lottos, WinningNumbers winningNumbers,
                                        BonusNumber bonusNumber) {
        if (lottos == null || winningNumbers == null || bonusNumber == null) {
            throw new IllegalStateException("당첨 결과 계산에 필요한 데이터가 없습니다.");
        }
        return new LottoResult(lottos, winningNumbers, bonusNumber);
    }
}