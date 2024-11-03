package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.prize.KoreaPrizeChecker;
import lotto.user.User;
import lotto.user.User.UserLottoInfo;

public class LottoMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {

        Integer purchaseCost = null;

        outputHandler.showPurchaseCostInputComments();

        while (purchaseCost == null) {
            try {
                purchaseCost = inputHandler.getPurchaseCost();

            } catch (IllegalArgumentException e) {
                outputHandler.showErrorMessage(e.getMessage());
            }
        }


        LottoGenerator lottoGenerator = new LottoGenerator();

        Integer lottoCount = purchaseCost / 1000;

        outputHandler.showPurchaseLottoCount(lottoCount);

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {

            Lotto lotto = new Lotto(lottoGenerator.generateLottoNumbers(1, 45, 6));
            lottos.add(lotto);
            outputHandler.showNumber(lotto);
        }

        outputHandler.showWinningLottoInputComment();
        List<Integer> winningLottoNumber = inputHandler.getWinningLottoInput();
        outputHandler.showWinningLottoBonusNumberInputComment();
        Integer bonusNum = inputHandler.getWinningLottoBonusNumberInput();

        WinningLotto winningLotto = new WinningLotto(winningLottoNumber, bonusNum);

        KoreaPrizeChecker koreaPrizeChecker = new KoreaPrizeChecker();

        List<UserLottoInfo> userLottoInfos = new ArrayList<>();

        for (Lotto lotto : lottos) {
            userLottoInfos.add(new UserLottoInfo(lotto,
                    koreaPrizeChecker.checkPrize(lotto.getNumbers(), winningLotto.getNumbers(),
                            winningLotto.getBonusNumber())));
        }

        User user = new User(userLottoInfos, purchaseCost);

        Statistic statistic = new Statistic();

        statistic.setWinningStatistics(user.getLottoInfos());

        outputHandler.showWinningStatistics(statistic);
        outputHandler.showInterestRate(statistic.getInterestRate(user.getLottoInfos(), user.getPurchaseCost()));

    }

    public void before() {

        outputHandler.showPurchaseCostInputComments();

    }
}

