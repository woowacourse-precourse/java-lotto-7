package lotto.controller;

import java.util.List;

import lotto.dto.LottoNumberListDto;
import lotto.dto.LottoResultDto;
import lotto.model.LottoBuyer;
import lotto.model.LottoManager;
import lotto.model.LottoResult;
import lotto.util.generator.RandomLottoNumberGenerator;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoManager lottoManager;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        LottoMachine lottoMachine = new LottoMachine(new RandomLottoNumberGenerator());
        this.lottoManager = new LottoManager(lottoMachine);
    }

    public void run() {
        LottoBuyer lottoBuyer = buyLotto();
        LottoResult lottoResult = announceWinningLotto();
        confirmLottoWinning(lottoBuyer, lottoResult);
    }

    private LottoBuyer buyLotto() {
        int amount = inputView.readAmount();
        LottoBuyer lottoBuyer = new LottoBuyer(amount, lottoManager);
        List<LottoNumberListDto> lottos = lottoBuyer.getLottos();
        outputView.printLottos(lottos);

        return lottoBuyer;
    }

    private LottoResult announceWinningLotto() {
        List<Integer> inputWinningNumbers = inputView.readWinningNumbers();
        int inputBonusNumber = inputView.readBonusNumber(inputWinningNumbers);

        return new LottoResult(inputWinningNumbers, inputBonusNumber, lottoManager);
    }

    private void confirmLottoWinning(LottoBuyer lottoBuyer, LottoResult lottoResult) {
        List<LottoResultDto> lottoResults = lottoBuyer.calculateResult(lottoResult);
        double returnOnInvestment = lottoBuyer.returnOnInvestment();
        outputView.printResult(lottoResults);
        outputView.printReturnOnInvestment(returnOnInvestment);
    }
}
