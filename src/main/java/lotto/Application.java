package lotto;

import lotto.constants.LottoRank;
import lotto.controller.InputController;
import lotto.inputoutput.OutputHandler;
import lotto.model.LottoList;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        int price = InputController.getPrice();
        LottoList lottoList = LottoManager.getLottoList(price);

        OutputHandler.printLottoStatus(lottoList);

        List<Integer> winningNumber = InputController.getWinningLottoNumber();
        int bonusNumber = InputController.getBonusNumber(winningNumber);

        System.out.println("당첨 확인 결과:");
        Map<LottoRank, Integer> result = LottoManager.findWinningLotto(lottoList, winningNumber, bonusNumber);

        double profit = LottoManager.calculateProfit(result, price);
        OutputHandler.printLottoResult(profit);
    }
}