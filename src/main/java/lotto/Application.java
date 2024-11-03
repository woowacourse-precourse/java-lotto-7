package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("1구입금액을 입력해 주세요.");
        int purchaseInt;
        while (true) {
            String purchase = Console.readLine();
            if (lotto.Lotto.validatePurchase(purchase)) {
                purchaseInt = Integer.parseInt(purchase);
                break;
            }
        }

        System.out.println("2당첨 번호를 입력해 주세요.");
        String winningNumber[];
        while (true) {
            String winningNum = Console.readLine();
            winningNumber = winningNum.split(",");
            if (lotto.Lotto.validateWinningNumber(winningNumber)) {
                break;
            }
        }

        System.out.println("3보너스 번호를 입력해 주세요.");
        int bonusNumInt;
        while (true) {
            String bonusNum = Console.readLine();
            if (lotto.Lotto.validateBonus(winningNumber, bonusNum)) {
                bonusNumInt = Integer.parseInt(bonusNum);
                break;
            }
        }

        Integer[] lottoStat = lottoStatistics(purchaseInt / 1000, winningNumber, bonusNumInt);
        finalResult(lottoStat, purchaseInt);
    }

    private static Integer[] lottoStatistics(int count, String[] winningNumber, int bonusNumInt) {
        Integer[] result = new Integer[7];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }

        int sum = 0;
        for (int i = 0; i < count; i++) {
            int number = lotto.Lotto.calculateWinningStatus(lotto.Lotto.purchaseLotto(), winningNumber);
            boolean bonus = lotto.Lotto.calculateBonusStatus(lotto.Lotto.purchaseLotto(), bonusNumInt);
            result[lotto.Lotto.checkWinnerIndex(number, bonus)] += 1;
            sum += lotto.Lotto.checkLottoResult(number, bonus);
        }
        result[6] = sum;
        return result;
    }

    private static void finalResult(Integer[] lottoStat, int purchaseInt) {
        System.out.println("당첨 통계\n---");
        for (int i = 1; i < lottoStat.length - 1; i++) {
            if( i == 1 ) {
                System.out.println("3개 일치 (5,000원) - " + lottoStat[i] + "개");
            }
            if( i == 2 ) {
                System.out.println("4개 일치 (50,000원) - " + lottoStat[i] + "개");
            }
            if( i == 3 ) {
                System.out.println("5개 일치, 보너스 불 일치 (1,500,000원) - " + lottoStat[i] + "개");
            }
            if( i == 4 ) {
                System.out.println("5개 일치 (30,000,000원) - " + lottoStat[i] + "개");
            }
            if( i == 5 ) {
                System.out.println("6개 일치 (2,000,000,000원) - " + lottoStat[i] + "개");
            }
        }
        String message = String.format("총 수익률은 %.2f%%입니다.", lottoStat[6]/(double)purchaseInt);
        System.out.println(message);
    }


}
