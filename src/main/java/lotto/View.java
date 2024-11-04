package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class View {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요";
    private static final String NUMBER_OF_LOTTO = "%d개를 구매했습니다.";
    private static final String STATISTICS_PROMPT = "당첨 통계\n" +
            "---\n" +
            "3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개";

    private static final String RATE_OF_RETURN_MONEY = "총 수익률은 %d%입니다.";

    public String printAndgetPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }

    public String getLottoNumber(){
        System.out.println(WINNING_NUMBERS_PROMPT);
        return Console.readLine();
    }

    public String getBonusNumberPrompt(){
        System.out.println(BONUS_NUMBER_PROMPT);
        return Console.readLine();
    }

    public void printNumberOfLotto(int numberOfLotto) {
        System.out.println(String.format(NUMBER_OF_LOTTO,numberOfLotto));
    }

    public void printStaticsOfWinning(int threeMatches, int fourMatches, int fiveMatches, int fiveMatchesWithBonous, int sixMatches){
        System.out.println(String.format(STATISTICS_PROMPT, threeMatches, fourMatches, fiveMatches, fiveMatchesWithBonous, sixMatches));
    }

    public void printRateOfReturnMoney(int rateOfReturnMoney){
        System.out.println(String.format(RATE_OF_RETURN_MONEY, rateOfReturnMoney));
    }

    public void printLottos(List<List<Integer>> lottos){
        for(List<Integer> lotto : lottos){
            System.out.println(lotto.toString());
        }
    }

}
