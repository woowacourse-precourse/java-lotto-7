package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoResult;

public class lottoView {

    public String purchaseInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();

        return input;
    }

    public String winningInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();

        return input;
    }

    public String bonusInput(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();

        return input;
    }

    public void printStat(LottoResult result){
        int[] prizeAmounts = result.getPrizeAmounts();
        int[] rankCounts = result.getRankCounts();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%,d원) - %d개\n", prizeAmounts[4], rankCounts[2]); // 3개 일치
        System.out.printf("4개 일치 (%,d원) - %d개\n", prizeAmounts[3], rankCounts[3]); // 4개 일치
        System.out.printf("5개 일치 (%,d원) - %d개\n", prizeAmounts[2], rankCounts[4]); // 5개 일치
        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개\n", prizeAmounts[1], rankCounts[1]); // 5개 일치, 보너스
        System.out.printf("6개 일치 (%,d원) - %d개\n", prizeAmounts[0], rankCounts[0]); // 6개 일치
    }

}
