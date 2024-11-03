package lotto;

import java.util.Arrays;
import java.util.List;

public class OutputSystem {
    public static void printMessageForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printMessageForLottoCountAndNumbers(int lottoPurchaseAmount) {
        int lottoCount = Lotto.lottoCount(lottoPurchaseAmount);
        System.out.println("\n"+lottoCount+"개를 구매했습니다.");
        List<List<Integer>> lottoNumbers = Lotto.purchaseLottoNumbers(lottoCount);
        for(List<Integer> purchaseLottoNumber: lottoNumbers){
            System.out.println(Arrays.toString(purchaseLottoNumber.toArray()));
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
