package lotto.controller;

import lotto.Lotto;
import lotto.handler.MainLogicHandler;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
//    private final LottoService lottoService;
    private final MainLogicHandler mainLogicHandler;

    public LottoController() {
//        this.lottoService = new LottoService();
        this.mainLogicHandler = new MainLogicHandler();
    }

    public void run() {
        OutputView.printInputPurchaseMoneyMessage();
        mainLogicHandler.handlePurchaseMoney();
//        int purchaseMoney, lottoCount;
//        while (true) {
//            try {
//                String money = InputView.getUserInput();
//                purchaseMoney = lottoService.getPurchaseMoney(money);
//                lottoCount = lottoService.getLottoCount(purchaseMoney);
//                break;
//            }
//            catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }

//        List<Lotto> lottos = lottoService.generateLottos(mainLogicHandler.getLottoCount());
        mainLogicHandler.handleLottos();
//        OutputView.printLottoCountMessage(mainLogicHandler.getLottoCount());
//        OutputView.printLottoNumbers(mainLogicHandler.getLottos());

        OutputView.printInputWinningNumbers();
        mainLogicHandler.handleWinningLotto();
//        Lotto winningLotto;
//        while (true) {
//            try {
//                String winningNumbersInput = InputView.getUserInput();
//                winningLotto = lottoService.getWinningLotto(winningNumbersInput);
//                break;
//            }
//            catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }

        OutputView.printInputBonusNumber();
        mainLogicHandler.handleBonusNumber();
//        int bonusNumber;
//        while (true) {
//            try {
//                String bonusNumberInput = InputView.getUserInput();
//                bonusNumber = lottoService.getBonusNumber(bonusNumberInput, winningLotto.getNumbers());
//                break;
//            }
//            catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }

//        Map<String, Integer> matchCounts = lottoService.getMatchCounts(
//                lottos,
//                mainLogicHandler.getWinningLotto(),
//                mainLogicHandler.getBonusNumber());
        mainLogicHandler.handleMatchCounts();
//        OutputView.printPrizeStatistics(mainLogicHandler.getMatchCounts());

//        long totalPrizeMoney = lottoService.getPrizeMoney(mainLogicHandler.getMatchCounts());
//        String rateOfReturn = lottoService.getRateOfReturn(totalPrizeMoney, mainLogicHandler.getPurchaseMoney());
        mainLogicHandler.handleRateOfReturn();
        OutputView.printRateOfReturn(mainLogicHandler.getRateOfReturn());

    }
}
