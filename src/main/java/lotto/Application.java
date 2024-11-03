package lotto;

import lotto.controller.LottoController;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        LottoController lottoController = new LottoController();
        try{
            String money = inputHandler.getBuyMoney();
            int count = parseInt(money)/1000;
            outputHandler.printPurchaseCount(count);
            lottoController.createLottos(parseInt(money));
            outputHandler.printLottos(lottoController.getLottos());
            String[] winningNumbers = inputHandler.getWinningNum();
            List<Integer> winningLotto = new ArrayList<>();
            for (String number : winningNumbers) {
                winningLotto.add(Integer.parseInt(number));
            }
            int bonusNumber = Integer.parseInt(inputHandler.getBonusNum());
            lottoController.setWinningNumbers(winningLotto, bonusNumber);
            outputHandler.printStatistics(lottoController.getStatistics());
            outputHandler.printProfitRate(lottoController.getProfitRate());
        }catch(IllegalArgumentException e){
            outputHandler.printError(e.getMessage());
            throw e;
        }
    }
}
