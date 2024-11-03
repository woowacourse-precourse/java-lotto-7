package lotto.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String HOW_MUCH_WANT_BUY="구입금액을 입력해 주세요";
    private static final String LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String INPUT_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String RESULT_STATISTIC ="당첨 통계";
    private static final String RESULT_PER_WINNING_RANKING ="%d개 일치 (%,d원) - %d개";
    private static final String RANKING_BONUS ="%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String PROFIT_RANGE = "총 수익률은 %.1f%%입니다";
    private static final String CONTOUR="---";
    public static void inputHowMuchBuy(){
        System.out.println(HOW_MUCH_WANT_BUY);
    }

    public static void outputHowManyBuy(int count){
        System.out.println(String.format(LOTTO_COUNT_FORMAT,count));
    }
    public static void outputRandomLottoNumbers(List<Integer> numbers){
        System.out.println(numbers.toString());
    }

    public static void inputLottoNumber(){
        System.out.println(INPUT_LOTTO_NUMBERS);
    }
    public static void inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
    }
    public static void outputResult(){
        System.out.println(RESULT_STATISTIC);
        System.out.println(CONTOUR);
    }
    public static void outputResultOfWinning(List<Integer> result){
        List<Integer> winningMoney = List.of(5000,50000,1500000,30000000,2000000000);
        for(int i=0;i<result.size();i++){
            if(i==3){
                System.out.println(String.format(RANKING_BONUS,i+2,winningMoney.get(i),result.get(i)));
                continue;
            }
            System.out.println(String.format(RESULT_PER_WINNING_RANKING,i+3,winningMoney.get(i),result.get(i)));
        }
    }
    public static void outputProfit(BigDecimal profit){
        System.out.println(String.format(PROFIT_RANGE,profit));
    }
}