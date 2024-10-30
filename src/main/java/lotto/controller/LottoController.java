package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;

import lotto.model.Lotto;
import lotto.service.LottoService;
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
        int countLotto = getCountLotto();
        ArrayList<Lotto> lottos = new ArrayList<>();
        outputView.printLottos(countLotto,lottos);

        int[] winningNums = getWinningNums();
        int bonusNumber = getBonusNumber();
        processLotto(lottos, winningNums, bonusNumber);

        outputResult(countLotto, bonusNumber);
    }

    public void outputResult(int countLotto, int bonusNumber) {
        HashMap<Integer,Integer> winningRecord = lottoService.getWinningRecord();
        double profitMargin = lottoService.calculateProfitMargin(countLotto, bonusNumber);
        outputView.printWinningResult(winningRecord);
        outputView.printProfitMargin(profitMargin);
    }

    public int getCountLotto(){
        outputView.requirePurchaseAmount();
        return lottoService.countLotto(inputView.inputPurchaseAmount());
    }

    public int[] getWinningNums(){
        outputView.requireWinningNumbers();
        return inputView.inputWinningNumbers();
    }

    public int getBonusNumber(){
        outputView.requireBonusNumber();
        return inputView.inputBonusNumber();
    }

    public void processLotto(ArrayList<Lotto> lottos, int[] winningNums, int bonusNumber){
        for (Lotto lotto : lottos) {
            ArrayList<Integer> lottoNums = lotto.getLotto();
            int count = lottoService.countMatchNumber(winningNums, lottoNums);
            boolean checkBonus = lottoService.checkBonusNumber(bonusNumber, lottoNums);
            Rank rank = Rank.fromMatchCount(count, checkBonus);
            lottoService.addWinningRecord(rank);
        }
    }
}
