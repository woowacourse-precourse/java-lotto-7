package lotto.controller;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.service.LottoBonusDuplicateCheckerService;
import lotto.service.LottoRankingService;
import lotto.service.PurchasedLottoNumbersService;
import lotto.validation.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.Rank;

public class Controller {
    private final PurchasedLottoNumbersService purchasedLottoNumbersService = new PurchasedLottoNumbersService();
    int userMoney;

    public int divideByThousand() {
        InputView.printRequestPurchaseAmountInput();
        String inputMoney = InputView.getUserInput();
        try{
            Money money = new Money(Parser.stringToInt(inputMoney));
            this.userMoney = money.getUserInputMoney();
            return money.getUserInputMoney() / 1000;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            OutputView.printInputAgainPrompt();
            return divideByThousand();
        }
    }

    public ArrayList<List<Integer>> generatePurchasedLottoNumbers(int times){
        OutputView.printPurchasedTicketCount(times);
        purchasedLottoNumbersService.PurchasedLottoNumbersGenerator(times);
        OutputView.printPurchasedLottoNumbers(purchasedLottoNumbersService.getPurchasedLottoNumbers());
        return purchasedLottoNumbersService.getPurchasedLottoNumbers();
    }

    public Lotto generateLotto() {
        InputView.printRequestLotto();
        List<Integer> numbers = InputView.getLotto(InputView.getUserInputSplitByComma());
        try {
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            OutputView.printInputAgainPrompt();
            return generateLotto();
        }
    }

    public BonusNumber generateBonusNumber(Lotto lotto){
        InputView.printRequestBonusNumber();
        String bonusNumberInput = InputView.getUserInput();
        try {
            BonusNumber bonusNumber = new BonusNumber(Parser.stringToInt(bonusNumberInput));
            LottoBonusDuplicateCheckerService.checkForDuplicates(lotto, Integer.parseInt(bonusNumberInput));
            return bonusNumber;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            OutputView.printInputAgainPrompt();
            return generateBonusNumber(lotto);
        }
    }

    public EnumMap<Rank, Integer> makeLottoAndBonusNumberCalculateRank(ArrayList<List<Integer>> purchasedLottoNumbers) {
        Lotto lotto = generateLotto();
        BonusNumber bonusNumber = generateBonusNumber(lotto);
        return LottoRankingService.calculateLottoRank(lotto,purchasedLottoNumbers,bonusNumber);
    }

    public void printResult(EnumMap<Rank, Integer> rankCounts){
        double totalRate = LottoRankingService.getTotalRate(rankCounts, userMoney);
        OutputView.printLottoResults(rankCounts,totalRate);
    }

    public void lottoStart(){
        printResult(makeLottoAndBonusNumberCalculateRank(generatePurchasedLottoNumbers(divideByThousand())));

    }
}
