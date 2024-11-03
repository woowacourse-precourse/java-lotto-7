package lotto.controller;

import static lotto.common.AppConstant.SPLIT_DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import lotto.model.InputValidator;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoStatistic;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView,
                           OutputView outputView,
                           InputValidator inputValidator,
                           LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        List<Lotto> boughtLottoList = attempt(this::buyLottoByPrice);
        outputView.printBoughtLottoList(boughtLottoList);

        WinningLotto winningLotto = attempt(this::generateWinningLotto);
        LottoStatistic lottoStatistic = lottoMachine.generateLottoStatistic(winningLotto, boughtLottoList);
        outputView.printLottoStatistic(lottoStatistic);
    }

    private List<Lotto> buyLottoByPrice() {
        Integer money = inputMoney();

        return lottoMachine.buyLottoByPrice(money);
    }

    private Integer inputMoney() {
        String rawMoney = inputView.inputMoney();
        inputValidator.validateInputNumber(rawMoney);

        return Integer.parseInt(rawMoney);
    }

    private WinningLotto generateWinningLotto() {
        Lotto lotto = attempt(this::generateLotto);
        Integer bonusNumber = attempt(this::inputWinningBonusNumber);

        return lottoMachine.generateWinningLotto(lotto, bonusNumber);
    }

    private Lotto generateLotto() {
        String rawWinningNumber = inputView.inputWinningNumber();
        inputValidator.validateInputWinningNumber(rawWinningNumber);
        String[] splitWinningNumber = rawWinningNumber.split(SPLIT_DELIMITER);
        List<Integer> numberList = Arrays.stream(splitWinningNumber).map(Integer::parseInt).toList();

        return new Lotto(numberList);
    }

    private Integer inputWinningBonusNumber() {
        String rawWinningBonusNumber = inputView.inputWinningBonusNumber();
        inputValidator.validateInputNumber(rawWinningBonusNumber);

        return Integer.parseInt(rawWinningBonusNumber);
    }

    private <T> T attempt(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());
            return attempt(supplier);
        }
    }
}
