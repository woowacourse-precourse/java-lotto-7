package lotto.controller;

import java.util.List;
import lotto.repository.Lotto;
import lotto.service.LottoBonusService;
import lotto.service.LottoInputDrawNumberService;
import lotto.service.LottoNumberCompareService;
import lotto.service.LottoPublishService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    LottoInputDrawNumberService lottoInputDrawNumberService = LottoInputDrawNumberService.getInstance();
    LottoPublishService lottoPublishService = LottoPublishService.getInstance();
    LottoBonusService lottoBonusService = LottoBonusService.getInstance();
    private LottoNumberCompareService lottoNumberCompareService = LottoNumberCompareService.getInstance();


    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startLottoGame() {
        buyLotto();
        lottoPublish();
        saveDrawNumbers();
        saveBonusNumbers();
        processDrawResult();
        printResult();
    }

    private void printResult() {
        outputView.printResultMessage();
        outputView.printRewardResult(lottoNumberCompareService.getMatchResult());
        outputView.printEarnings(lottoNumberCompareService.getEarnings());
    }

    private void processDrawResult() {
        lottoNumberCompareService.inputNumber(lottoPublishService.getPublishedLottoNumbers(),
                lottoInputDrawNumberService.getLottoDrawNumber(), lottoBonusService.getLottoBonusNumber(),
                lottoPublishService.getLottoPrice());

        lottoNumberCompareService.initMatchResult();
        lottoNumberCompareService.calcResult();
    }

    private void saveBonusNumbers() {
        try {
            lottoBonusService.setLottoBonusNumber(inputView.requestInputBonusNumbers(),
                    lottoInputDrawNumberService.getLottoDrawNumber());
        } catch (IllegalArgumentException e) {
            inputView.printMessage(e.getMessage());
            this.saveBonusNumbers();
        }
    }

    private void saveDrawNumbers() {
        try {
            lottoInputDrawNumberService.saveDrawNumber(inputView.requestInputDrawNumbers());
        } catch (IllegalArgumentException e) {
            inputView.printMessage(e.getMessage());
            this.saveDrawNumbers();
        }
    }

    private void buyLotto() {
        this.requestInputPrice();
    }

    private void requestInputPrice() {
        try {
            lottoPublishService.lottoPublish(inputView.requestInputPrice());
        } catch (IllegalArgumentException e) {
            inputView.printMessage(e.getMessage());
            this.requestInputPrice();
        }
    }

    private void lottoPublish() {
        List<Lotto> lottos = lottoPublishService.getPublishedLottoNumbers();
        outputView.printPublishCount(lottos.size());
        outputView.printPublishedLottoNumbers(lottoPublishService.getPublishedLottoNumbers());
    }
}
