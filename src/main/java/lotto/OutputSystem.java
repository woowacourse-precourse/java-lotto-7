package lotto;

import java.util.Arrays;

public class OutputSystem {
    public static void printMessageForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printMessageForLottoCountAndNumbers(int lottoPurchaseAmount) {
        int lottoCount = Lotto.lottoCount(lottoPurchaseAmount);
        System.out.println("\n"+lottoCount+"개를 구매했습니다.");
        int[][] lottoNumbers = Lotto.purchaseLottoNumbers(lottoCount);
        for(int[] purchaseLottoNumber: lottoNumbers){
            System.out.println(Arrays.toString(purchaseLottoNumber));
        }
    }

    public static void printMessageForLottoNumber() {
        System.out.println("\n당첨 번호를 입력해주세요.");
    }

    public static void printMessageForBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printMessageForWinningStatistics(){
        System.out.println("\n당첨 통계\n---");
    }
}
