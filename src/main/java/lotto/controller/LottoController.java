package lotto.controller;

import java.util.List;
import lotto.dto.BonusDTO;
import lotto.dto.BuyLottosDTO;
import lotto.dto.MoneyDTO;
import lotto.dto.WinningLottoDTO;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoBank;
import lotto.model.LottoResult;
import lotto.model.LottoSeller;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Lotto> myLottos = buyLottos();
        printMyLottos(myLottos);

        WinningLotto winningLotto = readWinningLotto();
        outputView.printNewLine();

        BonusNumber bonusNumber = readBonusNumber();
        outputView.printNewLine();

        LottoBank lottoBank = new LottoBank();
        LottoResult lottoResult = lottoBank.evaluate(winningLotto, myLottos, bonusNumber);

        printLottoResult(lottoResult);
        double profitRate = lottoBank.calculateProfitRate(lottoResult);
        printProfitRate(profitRate);
    }


    private List<Lotto> buyLottos() {
        try {
            MoneyDTO moneyDTO = inputView.readMoney();
            LottoSeller seller = new LottoSeller();
            return seller.sell(moneyDTO);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return buyLottos();
        }
    }

    private void printMyLottos(List<Lotto> myLottos) {
        outputView.printNewLine();
        outputView.printLotto(myLottos.size());
        outputView.printLottoDetail(BuyLottosDTO.from(myLottos));
        outputView.printNewLine();
    }

    private WinningLotto readWinningLotto() {
        try {
            WinningLottoDTO winningLottoDTO = inputView.readWinningLottoNumbers();
            WinningLotto winningLotto = new WinningLotto(winningLottoDTO.numbers());
            return winningLotto;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return readWinningLotto();
        }
    }

    private BonusNumber readBonusNumber() {
        try {
            BonusDTO bonusDTO = inputView.readBonus();
            BonusNumber bonusNumber = new BonusNumber(bonusDTO.number());
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return readBonusNumber();
        }
    }

    private void printLottoResult(LottoResult lottoResult) {
        outputView.printLottoResult(lottoResult);
    }

    private void printProfitRate(double profitRate) {
        outputView.printProfitRate(profitRate);
    }
}
