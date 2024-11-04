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

//    public static void printMessageForBonusNumber(){
//        System.out.println("\n보너스 번호를 입력해 주세요.");
//    }

    // 로또 수익률 계산
    private static double lottoLate(int[] checkNumber,int lottoAmount){
        int gain = 0;
        for (int i = 0; i < checkNumber.length; i++) {
            gain += checkNumber[i] * LottoWinning.values()[i].getPrize();
        }

        return (double) gain / lottoAmount * 100;
    }

    public static void printMessageForWinningStatistics(int[] checkNumber,int lottoAmount){
        System.out.println("\n당첨 통계\n---");
        for (LottoWinning winning : LottoWinning.values()) {
            int count = checkNumber[winning.ordinal()]; // Enum의 인덱스를 사용하여 개수 가져오기
            if (winning == LottoWinning.FIVE_BONUS_MATCH) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n",
                        winning.getMatchCount(), winning.getPrize(), count);
                continue;
            }
            System.out.printf("%d개 일치 (%d원) - %d개\n",
                    winning.getMatchCount(), winning.getPrize(), count);
        }
        double lottoLateNumber = lottoLate(checkNumber,lottoAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.", lottoLateNumber);
    }
}
