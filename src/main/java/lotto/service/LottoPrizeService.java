package lotto.service;

import static lotto.constant.Message.DELIMITER;
import static lotto.constant.Number.FIFTH_BONUS_PRIZE_MONEY;
import static lotto.constant.Number.FIFTH_PRIZE_MONEY;
import static lotto.constant.Number.FOURTH_PRIZE_MONEY;
import static lotto.constant.Number.SIXTH_PRIZE_MONEY;
import static lotto.constant.Number.THIRD_PRIZE_MONEY;
import static lotto.domain.PrizeCount.calculatePrizeCount;
import static lotto.domain.PrizeCount.getPrizeCount;
import static lotto.domain.UserLotto.getLottoMoneyCount;
import static lotto.domain.UserLotto.getRandomLottoNumbers;
import static lotto.service.LottoCalculateService.calculateLottoPrize;
import static lotto.view.InputView.getPrintInputBonusNumberMessage;
import static lotto.view.InputView.getPrintInputPrizeNumberMessage;
import static lotto.view.OutputView.getPrintTotalInvestment;
import static lotto.view.OutputView.printPrizeMessage;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.domain.PrizeCount;
import lotto.domain.PrizeNumbers;

public class LottoPrizeService {
    private static PrizeNumbers prizeNumbers;


    public PrizeNumbers PrizeNumbers(){
        prizeNumbers = new PrizeNumbers(setPrizeNumber(),setBonusNumber());
        return prizeNumbers;
    }

    private Lotto setPrizeNumber() {
        getPrintInputPrizeNumberMessage();
        return new Lotto(delimiterPrizeNumbers(Console.readLine()));

    }

    private Integer setBonusNumber(){
        getPrintInputBonusNumberMessage();
        return bonusStringToInteger(Console.readLine());
    }

    private List<Integer> delimiterPrizeNumbers(String prizeNumbers) {
        System.out.println(" ");
        return Arrays.stream(prizeNumbers.trim().split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private Integer bonusStringToInteger(String numbers){
        System.out.println(" ");
        return Integer.valueOf(numbers);
    }

   public void calculatePrizeMoney(){
       PrizeCount prizeCount = new PrizeCount();
        for(int i=0;i <getRandomLottoNumbers().size();i++){
            HashMap<Boolean, Integer> prizeMoneyCount = calculateLottoPrize(getRandomLottoNumbers().get(i).getNumbers(),prizeNumbers);
            hasBonusNumber(prizeMoneyCount);
        }
       printPrizeMessage();

   }

   private void hasBonusNumber(HashMap<Boolean, Integer> prizeMoneyCount){
        if(prizeMoneyCount.containsKey(true)){
            hasBonusNumberWinner(prizeMoneyCount.get(true)+1);
            calculatePrizeCount(prizeMoneyCount.get(true)+1);

       }
       calculatePrizeCount(prizeMoneyCount.get(false));
   }

   private void hasBonusNumberWinner(Integer number){
        if(number.equals(6)){
            calculatePrizeCount(7);
        }
   }

   public static void printCalculateInvestment(){
        int totalExpenditure = getLottoMoneyCount() * 1000;

        // 당첨 내역
        int threeCount = getPrizeCount().getOrDefault(3,0);
        int fourthCount = getPrizeCount().getOrDefault(4,0);
        int fifthCount = getPrizeCount().getOrDefault(5,0);
        int fifthBonusCount = getPrizeCount().getOrDefault(7,0);
        int sixthCount = getPrizeCount().getOrDefault(6,0);

        int totalPrize = (threeCount * THIRD_PRIZE_MONEY) +
                (fourthCount * FOURTH_PRIZE_MONEY) +
                (fifthCount * FIFTH_PRIZE_MONEY) +
                (fifthBonusCount * FIFTH_BONUS_PRIZE_MONEY) +
                (sixthCount * SIXTH_PRIZE_MONEY);

        getPrintTotalInvestment(calculateProfit(totalPrize, totalExpenditure));


    }

    public static double calculateProfit(int totalPrize, int totalExpenditure){
        double profitRate = ((double) totalPrize / totalExpenditure) * 100;
        return Math.round(profitRate * 10.0) / 10.0;
    }

}
