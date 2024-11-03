package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseInt;
        while (true) {
            String purchase = Console.readLine();
            if (lotto.Lotto.validatePurchase(purchase)) {
                purchaseInt = Integer.parseInt(purchase);
                break;
            }
        }
        System.out.println("\n" + purchaseInt / 1000 + "개를 구매했습니다.");
        Integer[] lottoStat = lotto.Lotto.lottoStatistics(purchaseInt / 1000);
        finalResult(lottoStat, purchaseInt);
    }




    private static void finalResult(Integer[] lottoStat, int purchaseInt) {
        System.out.println("\n당첨 통계\n---");
        for (int i = 1; i < lottoStat.length - 1; i++) {
            printResult(lottoStat, i);
        }

        String message = String.format("총 수익률은 %.1f%%입니다.", lottoStat[6]/(double)purchaseInt * 100);
        System.out.println(message);
    }

    private static void printResult(Integer[] lottoStat, int i) {
        if( i == 1 ) {
            System.out.println("3개 일치 (5,000원) - " + lottoStat[i] + "개");
            return;
        }
        if( i == 2 ) {
            System.out.println("4개 일치 (50,000원) - " + lottoStat[i] + "개");
            return;
        }
        if( i == 3 ) {
            System.out.println("5개 일치 (1,500,000원) - " + lottoStat[i] + "개");
            return;
        }
        if( i == 4 ) {
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoStat[i] + "개");
            return;
        }
        if( i == 5 ) {
            System.out.println("6개 일치 (2,000,000,000원) - " + lottoStat[i] + "개");
        }
    }


}
