package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.WinningLotto;
import lotto.domain.prize.WinningStrategy;
import lotto.domain.statistic.Statistic;
import lotto.io.LottoIOHandler;
import lotto.domain.prize.KoreaPrizeChecker;
import lotto.domain.user.User;
import lotto.domain.user.User.UserLottoInfo;

public class LottoMachine {
    private final LottoIOHandler lottoIOHandler = new LottoIOHandler();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final WinningStrategy koreaPrizeChecker = new KoreaPrizeChecker();
    private final Statistic statistic = new Statistic();
    public void run() {
        long purchaseCost = lottoIOHandler.askPurchaseCost();
        Integer lottoCount = Math.toIntExact(purchaseCost / 1000);
        lottoIOHandler.showPurchaseLottoCount(lottoCount);
        List<Lotto> lottoList = askLottoList(lottoCount);

        WinningLotto winningLotto = lottoIOHandler.askWinningLotto();

        List<UserLottoInfo> userLottoInfos = getUserLottoInfos(lottoList, winningLotto);
        User user = new User(userLottoInfos, purchaseCost);

        statistic.setWinningStatistics(user.getLottoInfos());
        lottoIOHandler.showWinningStatistics(statistic);
        lottoIOHandler.showInterestRate(statistic.getInterestRate(user.getLottoInfos(), user.getPurchaseCost()));
    }

    private List<UserLottoInfo> getUserLottoInfos(List<Lotto> lottoList, WinningLotto winningLotto) {
        List<UserLottoInfo> userLottoInfos = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            userLottoInfos.add(new UserLottoInfo(lotto,
                    koreaPrizeChecker.checkPrize(lotto.getNumbers(), winningLotto.getNumbers(),
                            winningLotto.getBonusNumber())));
        }
        return userLottoInfos;
    }

    private List<Lotto> askLottoList(Integer lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoGenerator.generateLottoNumbers(1, 45, 6));
            lottoList.add(lotto);
            lottoIOHandler.showNumber(lotto);
        }
        return lottoList;
    }
}

