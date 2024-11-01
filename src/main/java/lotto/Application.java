package lotto;

import static lotto.ErrorMessage.DUPLICATE_BONUS_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.PurchasedLottoNumbers;
import lotto.model.RandomNumbers;
import lotto.validation.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private String input;

    // 컨트롤러
    public int divideByThousand(String input) {
        try{
            new Money(Parser.stringToInt(input));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            OutputView.printInputAgainPrompt();
            return divideByThousand(Console.readLine());
        }
        this.input = input;
        return Integer.parseInt(input) / 1000;
    }

    // 서비스 계층
    public ArrayList<List<Integer>> generateLottoNumbers(int times){
        OutputView.printPurchasedTicketCount(times);
        PurchasedLottoNumbers purchasedLottoNumbers = new PurchasedLottoNumbers(RandomNumbers.generateSortedRandomLottoSets(times));
        OutputView.printPurchasedLottoNumbers(purchasedLottoNumbers.getPurchasedLottoNumbers());
        return purchasedLottoNumbers.getPurchasedLottoNumbers();
    }

    // 컨트롤러

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

    // 서비스 계층
    public void checkForDuplicates(List<Integer> numbers, int bonusNumber){
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.format());
        }
    }

    // 컨트롤러
    public int generateBonusNumber(Lotto lotto, String bonusNumber){
        try {
            BonusNumber bonusNumber1 = new BonusNumber(Parser.stringToInt(bonusNumber));
            checkForDuplicates(lotto.getNumbers(), Integer.parseInt(bonusNumber));
            return bonusNumber1.getBonusNumber();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            OutputView.printInputAgainPrompt();
            return generateBonusNumber(lotto, Console.readLine());
        }
    }

    // 서비스 계층

    public int[] calculateLottoRank(ArrayList<List<Integer>> purchasedLottoNumbers){
        Lotto lotto = generateLotto();
        int bounsNumber = generateBonusNumber(lotto, InputView.requestBonusNumber());
        int [] rank = {0,0,0,0,0};
        for (int i = 0; i < purchasedLottoNumbers.size(); i++) {
            int count = 0;
            for (int j = 0; j < 6; j++) {
                if(lotto.getNumbers().contains(purchasedLottoNumbers.get(i).get(j))){
                    count++;
                }
            }
            if(count == 3){
                rank[0] += 1;
            }
            if (count == 4){
                rank[1] += 1;
            }
            if (count == 5){
                if(purchasedLottoNumbers.get(i).contains(bounsNumber)){
                    rank[3] += 1;
                }
                else{
                    rank[2] += 1;
                }
            }
            if (count ==6){
                rank[4] += 1;
            }
        }return rank;

    }

    // 서비스 계층으로
    private double getTotalRate(int[] rank) {
        int total = rank[0] * 5000 + rank[1] * 50000 + rank[2] * 1500000 + rank[3] * 30000000 + rank[4] * 2000000000;
        double totalRate = (double) total / Integer.parseInt(input) * 100;
        totalRate = Math.round(totalRate * 10) / 10.0;
        return totalRate;
    }

    // 컨트롤러

    public void printResult(int [] rank){
        double totalRate = getTotalRate(rank);
        OutputView.printLottoResults(rank,totalRate);
    }


    public static void main(String[] args) {
        Application application = new Application();
        application.printResult(application.calculateLottoRank(application.generateLottoNumbers(application.divideByThousand(
                InputView.requestPurchaseAmountInput()))));
    }
}
