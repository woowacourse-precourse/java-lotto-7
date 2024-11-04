package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import lotto.Lotto;
import lotto.LottoPrize;
import lotto.util.LottoManager;
import lotto.util.Saparater;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoManager lottoManager = new LottoManager();
    ArrayList<Lotto> lottos;
    int purchaseAmount;
    Lotto winningLotto;
    HashMap<LottoPrize, Integer> winningResult;

    public void start() {
        purchaseProcess();
        setWinningNumbersProcess();
        winningResultProcess();
    }

    public void purchaseProcess() {
        try {
            purchaseAmount = inputView.getPurchaseAmount();
            lottos = lottoManager.purchaseLotto(purchaseAmount);
            outputView.printLottoInfo(lottos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseProcess();
        }
    }

    public void setWinningNumbersProcess() {
        try {
            String input = inputView.getWinningNumbers();
            Saparater saparater = new Saparater(",");
            ArrayList<Integer> numbers = new ArrayList<>();
            for (String s : saparater.split(input)) {
                numbers.add(Integer.parseInt(s));
            }
            int bonusNumber = inputView.getBonusNumber();
            winningLotto = lottoManager.getWinningLotto(numbers, bonusNumber);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            setWinningNumbersProcess();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setWinningNumbersProcess();
        }
    }

    public void winningResultProcess() {
        winningResult = lottoManager.getWinningResult(lottos, winningLotto);
        outputView.printWinningResult(winningResult);
        outputView.printProfitRate(lottoManager.getProfitRate(winningResult, purchaseAmount));
    }
}
