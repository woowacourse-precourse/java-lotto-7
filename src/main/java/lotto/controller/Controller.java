package lotto.controller;

import static lotto.common.Constant.THOUSAND;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.service.LottoRankingService;
import lotto.service.PurchasedLottoNumbersService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.Rank;

public class Controller {
    private final PurchasedLottoNumbersService purchasedLottoNumbersService = new PurchasedLottoNumbersService();
    int userMoney;

    public int divideUserMoneyByThousand() {
        InputView.printRequestPurchaseAmountInput();
        this.userMoney = InputHandler.getMoneyUntilValid(InputView.getUserInput());
        return userMoney / THOUSAND;
    }

    public ArrayList<List<Integer>> generatePurchasedLottoNumbers(int times){
        OutputView.printPurchasedTicketCount(times);
        purchasedLottoNumbersService.PurchasedLottoNumbersGenerator(times);
        OutputView.printPurchasedLottoNumbers(purchasedLottoNumbersService.getPurchasedLottoNumbers());
        return purchasedLottoNumbersService.getPurchasedLottoNumbers();
    }

    public EnumMap<Rank, Integer> makeLottoAndBonusNumberCalculateRank(ArrayList<List<Integer>> purchasedLottoNumbers) {
        Lotto lotto = InputHandler.generateLotto();
        BonusNumber bonusNumber = InputHandler.generateBonusNumber(lotto);
        return LottoRankingService.calculateLottoRank(lotto,purchasedLottoNumbers,bonusNumber);
    }

    public void printResult(EnumMap<Rank, Integer> rankCounts){
        double totalRate = LottoRankingService.getTotalRate(rankCounts, userMoney);
        OutputView.printLottoResults(rankCounts,totalRate);
    }

    public void lottoStart(){
        printResult(makeLottoAndBonusNumberCalculateRank(generatePurchasedLottoNumbers(divideUserMoneyByThousand())));
    }
}
