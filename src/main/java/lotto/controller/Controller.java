package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
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

public class Controller {
    private final PurchasedLottoNumbersService purchasedLottoNumbersService = new PurchasedLottoNumbersService();
    private int input;

    public int divideByThousand() {
        String input = InputView.requestPurchaseAmountInput();
        try{
            new Money(Parser.stringToInt(input));
            this.input = Parser.stringToInt(input);
            return Parser.stringToInt(input) / 1000;
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
        List<Integer> numbers = InputView.requestLotto();
        try {
            return new Lotto(numbers); // 올바른 Lotto 객체 생성
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            OutputView.printInputAgainPrompt();
            return generateLotto();
        }
    }

    public int generateBonusNumber(Lotto lotto, String bonusNumberInput){
        try {
            BonusNumber bonusNumber = new BonusNumber(Parser.stringToInt(bonusNumberInput));
            LottoBonusDuplicateCheckerService.checkForDuplicates(lotto, Integer.parseInt(bonusNumberInput));
            return bonusNumber.getBonusNumber();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            OutputView.printInputAgainPrompt();
            return generateBonusNumber(lotto, Console.readLine());
        }
    }

    public int[] makeLottoAndBonusNumberCalculateRank(ArrayList<List<Integer>> purchasedLottoNumbers) {
        Lotto lotto = generateLotto();
        int bonusNumber = generateBonusNumber(lotto, InputView.requestBonusNumber());
        int[] rank = new int[5];

        for (List<Integer> purchasedLottoNumber : purchasedLottoNumbers) {
            int matchCount = LottoRankingService.countMatches(lotto, purchasedLottoNumber);
            LottoRankingService.updateRank(rank, matchCount, purchasedLottoNumber.contains(bonusNumber));
        }

        return rank;
    }

    public void printResult(int [] rank){
        double totalRate = LottoRankingService.getTotalRate(rank, input);
        OutputView.printLottoResults(rank,totalRate);
    }

    public void lottoStart(){
        printResult(makeLottoAndBonusNumberCalculateRank(generatePurchasedLottoNumbers(divideByThousand())));

    }
}
