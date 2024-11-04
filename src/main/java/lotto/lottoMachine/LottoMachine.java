package lotto.lottoMachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.view.InputController;
import lotto.view.OutputController;

public class LottoMachine {
    private final InputController inputController = new InputController();
    private final OutputController outputController = new OutputController();

    private final Integer purchaseNum;
    private final List<Lotto> userLottos;
    private final Lotto winLotto;
    private final Integer bonusNum;
    private final Map<LottoResult, Integer> resultMap;

    public LottoMachine() {
        this.purchaseNum = inputController.getPurchaseNumber();
        this.userLottos = getUserLottos();
        this.winLotto = inputController.getLotto();
        this.bonusNum = inputController.getBonusNumber(winLotto);
        this.resultMap = getResultMap();
    }

    public void run() {
        matchUserLottosWithWinLotto();
        outputController.printResult(resultMap, getRatioOfProfit());
    }

    protected Map<LottoResult, Integer> getResultMap() {
        final Map<LottoResult, Integer> resultMap;
        resultMap = new EnumMap<>(LottoResult.class);
        for(LottoResult result : LottoResult.values()) {
            resultMap.put(result, 0);
        }
        return resultMap;
    }

    private void matchUserLottosWithWinLotto() {
        for(Lotto userLotto : userLottos) {
            LottoResult lottoResult = userLotto.getMatchCount(winLotto, bonusNum);
            if(lottoResult != null) {
                resultMap.put(lottoResult, resultMap.get(lottoResult) + 1);
            }
        }
    }

    protected Double getRatioOfProfit() {
        double totalProfit = 0;
        for(LottoResult lottoResult : resultMap.keySet()) {
            totalProfit += (lottoResult.getWinningAmount() * resultMap.get(lottoResult));
        }

        return totalProfit / (purchaseNum * 1000) * 100;
    }

    protected List<Lotto> getUserLottos () {
        List<Lotto> userLottos = new ArrayList<>();
        for(int i = 0; i < purchaseNum; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userLottos.add(new Lotto(numbers));
        }

        outputController.printUserLottos(purchaseNum, userLottos);
        return userLottos;
    }
}
