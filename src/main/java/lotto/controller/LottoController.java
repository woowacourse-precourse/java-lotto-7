package lotto.controller;

import lotto.Lotto;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    public LottoController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
    }
    public void process() {
        Queue<Lotto> purchaseLotto = new LinkedList<>();

        int purchaseAmount = inputView.inputPurchaseAmount();
        int purchaseCount = purchaseAmount / 1000;
        outputView.printPurchaseCount(purchaseCount);

        generateLottoNumber(purchaseLotto,purchaseCount);
        winningExamine(purchaseLotto,purchaseAmount);

    }

    public void generateLottoNumber(Queue<Lotto>purchaseLotto,int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(lottoNumbers.stream().sorted().toList());
            purchaseLotto.add(new Lotto(lottoNumbers));
        }
    }

    public void winningExamine(Queue<Lotto> purchaseLotto,int purchaseAmount) {
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        LottoResult totalWinningResult = addWinningResult(purchaseLotto, winningNumbers, bonusNumber);
        outputView.printLottoReslt(totalWinningResult);
        outputView.printProfitResult(totalWinningResult, purchaseAmount);
    }

    public LottoResult addWinningResult(Queue<Lotto> purchaseLotto, List<Integer> winningNumber, int bonusNumber){
        LottoResult result = new LottoResult();
        for(Lotto lotto : purchaseLotto){
            result.addResult(lotto.winningCheck(winningNumber, bonusNumber));
        }
        return result;
    }
}
