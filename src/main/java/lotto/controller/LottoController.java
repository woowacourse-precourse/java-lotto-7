package lotto.controller;

import java.util.List;
import lotto.converter.StringToIntConverter;
import lotto.domain.LottoMoney;
import lotto.service.LottoResult;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningLotto;
import lotto.service.LottoWinMather;
import lotto.util.ErrorMessage;
import lotto.domain.BonusBall;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;
    private final LottoWinMather lottoWinMather;
    private final StringToIntConverter converter;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine, StringToIntConverter converter, LottoWinMather lottoWinMather) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
        this.converter = converter;
        this.lottoWinMather = lottoWinMather;
    }

    public void run() {
        LottoMoney lottoMoney = inputMoney();
        PurchasedLottos purchasedLotto = lottoMachine.issueLotto(lottoMoney);

        outputView.showHowManyLotto(purchasedLotto);
        outputView.showAllLottoNums(purchasedLotto);

        WinningLotto winningLotto = createWinningLotto();

        LottoResult lottoResult = lottoWinMather.calculateLottoWins(purchasedLotto, winningLotto);

        outputView.showWinStatus(lottoResult);
        outputView.showProfit(lottoResult, lottoMoney);
    }

    private WinningLotto createWinningLotto() {
        Lotto lotto = inputLottoNumbers();
        System.out.printf(System.lineSeparator());
        while (true) {
            try {
                BonusBall bonusBall = inputBonusNumber();
                return new WinningLotto(lotto, bonusBall);
            } catch (IllegalArgumentException e) {
                ErrorMessage.showErrorMsg(e.getMessage());
            }
        }
    }

    private BonusBall inputBonusNumber() {
        while (true) {
            try {
                String rawNumber = inputView.lottoBonusNumInput();
                int bonusNumber = converter.convertStringNumberToInteger(rawNumber);
                return new BonusBall(bonusNumber);
            } catch (IllegalArgumentException e) {
                ErrorMessage.showErrorMsg(e.getMessage());
            }
        }
    }

    private Lotto inputLottoNumbers() {
        while (true) {
            try {
                String rawNumbers = inputView.lottoNumsInput();
                List<Integer> numbers = converter.convertStringNumbersToIntegers(rawNumbers);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                ErrorMessage.showErrorMsg(e.getMessage());
            }
        }
    }

    private LottoMoney inputMoney() {
        while (true) {
            try {
                String rawMoney = inputView.lottoMoneyInput();
                return new LottoMoney(converter.convertStringNumberToInteger(rawMoney));
            } catch (IllegalArgumentException e) {
                ErrorMessage.showErrorMsg(e.getMessage());
            }
        }
    }
}
