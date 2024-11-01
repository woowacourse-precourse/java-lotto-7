package lotto.View;

import lotto.Messages.StateMessage;
import lotto.MyResult;
import lotto.WinningDetails;

public class OutputView {
    public static final String LOTTO_AMOUNT_PHRASE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_COUNT_PHRASE = "개를 구매했습니다.";
    public static final String LOTTO_WINNING_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String LOTTO_BONUS_INPUT = "보너스 번호를 입력해 주세요.";
    public static final String NUM = "개";

    public static void printPurchaseAmount(){
        System.out.println(LOTTO_AMOUNT_PHRASE);
    }

    public static void printCount(){
        System.out.println(LOTTO_COUNT_PHRASE);
    }

    public static void printWinning(){
        System.out.println(LOTTO_WINNING_INPUT);
    }

    public static void printBonus(){
        System.out.println(LOTTO_BONUS_INPUT);
    }

    public static void printBlank(){
        System.out.println("");
    }

    public static void printReturn(Integer purchasePrice, Integer revenue){
        System.out.println("총 수익률은 " + MyResult.getReturn(purchasePrice, revenue) + "%입니다.");
    }

    public static void printResults(WinningDetails grades){
        System.out.println(StateMessage.WIN_STATICS.getMessage());
        System.out.println(StateMessage.THREE.getMessage() + grades.getThird() + NUM);
        System.out.println(StateMessage.FOUR.getMessage() + grades.getFourth() + NUM);
        System.out.println(StateMessage.FIVE.getMessage() + grades.getFifth() + NUM);
        System.out.println(StateMessage.FIVE_BONUS.getMessage() +grades.getFifthBonus() + NUM);
        System.out.println(StateMessage.SIX.getMessage() + grades.getSixth() + NUM);
    }

}
