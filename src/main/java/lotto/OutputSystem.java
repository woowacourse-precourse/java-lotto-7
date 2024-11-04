package lotto;

import java.util.Arrays;
import java.util.List;

public class OutputSystem {
    public static void printMessageForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printMessageForLottoCountAndNumbers(int lottoCount ,List<List<Integer>> lottoNumbers) {
        System.out.println("\n"+lottoCount+"개를 구매했습니다.");
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
        System.out.println("\n3개 일치 (5,000원) - " + + "개");
        System.out.println("\n4개 일치 (50,000원) - " + + "개");
        System.out.println("\n5개 일치, 보너스 볼 일치 (30,000,000원) - " + + "개");
        System.out.println("\n6개 일치 (2,000,000,000원) - " + + "개");
        System.out.println("\n총 수익률은 " + + "%입니다.");
    }
}
