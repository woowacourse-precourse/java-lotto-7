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

    // 로또 수익률 계산
    private static double lottoLate(int[] checkNumber,int lottoAmount){
        int gain = 0;
        gain = gain + 5000*checkNumber[0];
        gain = gain + 50000*checkNumber[1];
        gain = gain + 1500000*checkNumber[2];
        gain = gain + 30000000*checkNumber[3];
        gain = gain + 2000000000*checkNumber[4];

        return (double) gain / lottoAmount * 100;
    }

    public static void printMessageForWinningStatistics(int[] checkNumber,int lottoAmount){
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + checkNumber[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + checkNumber[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + checkNumber[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + checkNumber[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + checkNumber[4] + "개");
        double lottoLateNumber = lottoLate(checkNumber,lottoAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.", lottoLateNumber);
    }
}
