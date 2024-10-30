package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.util.LottoUtils;
import lotto.util.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int puchaseAmount = getPuchaseAmount();
        int countLotto = getCountLotto(puchaseAmount);
        List<Lotto> lottos = getLottos(countLotto);
        outputView.printLottos(countLotto,lottos);

        int[] winningNums = getWinningNums();
        int bonusNumber = getBonusNumber();
        processLotto(lottos, winningNums, bonusNumber);

        outputResult(puchaseAmount);
    }

    private List<Lotto> getLottos(int countLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countLotto; i++) {
            lottos.add(LottoUtils.createLotto());
        }
        return lottos;
    }

    public void outputResult(int puchaseAmount) {
        HashMap<Integer,Integer> winningRecord = lottoService.getWinningRecord();
        double profitMargin = lottoService.calculateProfitMargin(winningRecord,puchaseAmount);
        outputView.printWinningResult(winningRecord);
        outputView.printProfitMargin(profitMargin);
    }

    public int getCountLotto(int purchaseAmount){
        return lottoService.countLotto(purchaseAmount);
    }

    private int getPuchaseAmount() {
        outputView.requirePurchaseAmount();
        return inputView.inputPurchaseAmount();
    }

    public int[] getWinningNums(){
        outputView.requireWinningNumbers();
        return inputView.inputWinningNumbers();
    }

    public int getBonusNumber(){
        outputView.requireBonusNumber();
        return inputView.inputBonusNumber();
    }

    public void processLotto(List<Lotto> lottos, int[] winningNums, int bonusNumber){
        for (Lotto lotto : lottos) {
            List<Integer> lottoNums = lotto.getLotto();
            int count = lottoService.countMatchNumber(winningNums, lottoNums);
            boolean checkBonus = lottoService.checkBonusNumber(bonusNumber, lottoNums);
            Rank rank = Rank.fromMatchCount(count, checkBonus);
            if (rank.getRankOrder()!=0) {
                lottoService.addWinningRecord(rank);
            }

        }
    }
}
