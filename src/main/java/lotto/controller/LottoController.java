package lotto.controller;

import lotto.domain.Consumer;
import lotto.domain.LottoPrize;
import lotto.domain.LottoRankManager;
import lotto.service.LottoService;
import lotto.view.OutputView;

import java.util.List;

import static lotto.util.Utils.changeStringToInt;
import static lotto.util.Utils.changeStringToIntegerList;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {

    private static final int NUMBER_LIMIT = 1000;
    private final LottoService lottoService = new LottoService();
    private Consumer consumer;
    private LottoPrize lottoPrize;
    private LottoRankManager lottoRankManager;

    public void start() {
        initLottoSetting();
        startLottoPick();
        LottoResult();
    }

    public void initLottoSetting() {
        consumer = payMoney();
        lottoService.buyLottoes(consumer, NUMBER_LIMIT);
        lottoRankManager = new LottoRankManager(consumer);
        lottoRankManager.initLottoRank();
        lottoResult();
    }

    private void lottoResult() {
        printLottoCount(consumer.getMoney() / NUMBER_LIMIT);
        printLottoes(consumer);
    }

    private Consumer payMoney() {
        try {
            return new Consumer(inputMoney());
        } catch (IllegalArgumentException e) {
            ErrorMessage(e.getMessage());
            return payMoney();
        }
    }

    private int inputMoney() {
        try {
            String inputMoney = inputPrice();
            return changeStringToInt(inputMoney);
        } catch (IllegalArgumentException e) {
            ErrorMessage(e.getMessage());
            return inputMoney();
        }
    }

    public void startLottoPick() {
        lottoPrize = lottoPrizeNumber();
        lottoPrize = lottoBonusNumber();
    }

    private LottoPrize lottoPrizeNumber() {
        try {
            return LottoPrize.createLottoPrize(inputLottoPrizeNumber());
        } catch (IllegalArgumentException e) {
            ErrorMessage(e.getMessage());
            return lottoPrizeNumber();
        }
    }

    private List<Integer> inputLottoPrizeNumber() {
        try {
            String inputPrizeNumber = inputLottoNumbers();
            return changeStringToIntegerList(inputPrizeNumber);
        } catch (IllegalArgumentException e) {
            ErrorMessage(e.getMessage());
            return inputLottoPrizeNumber();
        }
    }

    private LottoPrize lottoBonusNumber() {
        try {
            return LottoPrize.createLottoBonus(lottoPrize.getLottoPrizeNumbers(), inputLottoBonusNumber());
        } catch (IllegalArgumentException e) {
            ErrorMessage(e.getMessage());
            return lottoBonusNumber();
        }
    }

    private Integer inputLottoBonusNumber() {
        try {
            String inputBonusNumber = inputLottoBonus();
            return changeStringToInt(inputBonusNumber);
        } catch (IllegalArgumentException e) {
            ErrorMessage(e.getMessage());
            return inputLottoBonusNumber();
        }
    }

    public void LottoResult() {
        lottoService.calculationLottoRank(consumer, lottoRankManager, lottoPrize);

        OutputView.printLottoMessage();
        OutputView.printLottoRank(lottoRankManager.getLottoRankResult());

        double lottoRate = lottoService.resultLotto(lottoRankManager);
        OutputView.printTotalYield(lottoRate);

    }

}
