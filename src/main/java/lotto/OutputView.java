package lotto;

import java.util.List;

public class OutputView {
    private static final int DIGITS_TWO = 10;
    private static final int DIGITS_THREE = 100;
    private static final int DIGITS_FOUR = 1000;

    private static final int INDEX_OF_SECOND_RANK = 3;

    public void updateLottos(List<List<Integer>> numbersOfLottos) {
        System.out.println("\n" + numbersOfLottos.size() + "개를 구매했습니다.");
        for (int i = 0; i < numbersOfLottos.size(); i++) {
            System.out.println(numbersOfLottos.get(i));
        }
    }

    private String makePadding(int tail) {
        if (tail < DIGITS_TWO) {
            return "00" + tail;
        }
        if (tail < DIGITS_THREE) {
            return "0" + tail;
        }
        return Integer.toString(tail);
    }

    private String makeComma(int prize) {
        String commaIn = "";
        while (prize > DIGITS_FOUR) {
            int tail = prize % DIGITS_FOUR;
            commaIn = "," + makePadding(tail) + commaIn;
            int head = prize / DIGITS_FOUR;
            prize = head;
        }
        commaIn = prize + commaIn;
        return commaIn;
    }

    public void updateResults(Result[] results) {
        System.out.println("\n당첨 통계\n---");
        for (int i = 0; i < results.length - 1; i++) {
            Result result = results[i];
            if (i == INDEX_OF_SECOND_RANK) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (" + makeComma(result.prize()) + "원) - %d개\n",
                        (int) Math.floor(result.winningPoints()), result.winningCounts());
                continue;
            }
            System.out.printf("%d개 일치 (" + makeComma(result.prize()) + "원) - %d개\n",
                    (int) Math.floor(result.winningPoints()), result.winningCounts());
        }
    }

    public void updatePrizeRate(double prizeRate) {
        System.out.printf("총 수익률은 %.1f" + "%s입니다.", prizeRate, "%");
    }

}
