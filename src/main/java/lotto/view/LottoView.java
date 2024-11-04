package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.Rank;
import lotto.message.Message;

import java.util.List;

public class LottoView {

    public static String inputAmount(){
        System.out.println(Message.INPUT_AMOUNT);
        String input = Console.readLine();
        isDivisibleBy1000(input);
        isPositive(input);
        return input;
    }

    public static String inputWinningNumbers(){
        System.out.println(Message.INPUT_WINNING_NUMBERS);
        String input = Console.readLine();
        return input;
    }

    public static String inputBonusNumbers(){
        System.out.println(Message.INPUT_BONUS_NUMBERS);
        String input = Console.readLine();
        return input;
    }

    public static void printLottoList(List<Lotto> lottoList){
        System.out.println(lottoList.size() + Message.OUTPUT_LOTTOS.toString());
        lottoList.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printResults(int[] rankCount, int totalProfit, int amountSpent) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                if (rank == Rank.SECOND) {
                    System.out.printf("5개 일치, 보너스 볼 일치 (%d원) - %d개\n", rank.getPrize(), rankCount[rank.ordinal()]);
                }
                if (rank != Rank.NONE && rank != Rank.SECOND) {
                    System.out.printf("%d개 일치 (%d원) - %d개\n", rank.getMatchCount(), rank.getPrize(), rankCount[rank.ordinal()]);
                }
            }
        }

        // 총 수익률 계산
        double profitRate = (double) totalProfit / amountSpent * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }


    private static void isDivisibleBy1000(String input) {
        if(Integer.parseInt(input) % 1000 !=0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    private static void isPositive(String input) {
        if(Integer.parseInt(input) <= 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
    }
}
