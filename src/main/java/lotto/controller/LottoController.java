package lotto.controller;

import lotto.domain.Lottos;
import lotto.dto.BonusLottoNumber;
import lotto.dto.LottoPurchaseAmount;
import lotto.dto.MatchLottoResult;
import lotto.dto.RateOfReturn;
import lotto.dto.WinningLottoNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = inputLottoPurchaseAmount();
        Lottos lottos = buyLottos(lottoPurchaseAmount);
        outputView.printLottos(lottos);
        WinningLottoNumbers winningLottoNumbers = makeWinningLottoNumbers();
        BonusLottoNumber bonusLottoNumber = makeBonusLottoNumber(winningLottoNumbers);
        MatchLottoResult matchLottoResult = lottoService.matchLottoNumber(lottos, winningLottoNumbers, bonusLottoNumber);
        RateOfReturn rateOfReturn = lottoService.calcRateOfReturn(lottoPurchaseAmount, matchLottoResult);
        outputView.printResult(matchLottoResult, rateOfReturn);
    }

    private LottoPurchaseAmount inputLottoPurchaseAmount() {
        outputView.printLottoPurchaseAmountMessage();
        return LottoPurchaseAmount.from(inputView.InputLottoPurchaseAmount());
    }

    private Lottos buyLottos(LottoPurchaseAmount lottoPurchaseAmount) {
        return lottoService.buyLottos(lottoPurchaseAmount);
    }

    private WinningLottoNumbers makeWinningLottoNumbers() {
        outputView.printInputLottoWinningNumbersMessage();
        return WinningLottoNumbers.from(inputView.InputLottoWinningNumbers());
    }

    private BonusLottoNumber makeBonusLottoNumber(WinningLottoNumbers winningLottoNumbers) {
        outputView.printInputLottoBonusNumberMessage();
        return BonusLottoNumber.from(inputView.InputLottoBonusNumber(), winningLottoNumbers);
    }
}
