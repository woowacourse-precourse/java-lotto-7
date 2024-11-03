package lotto;

import java.util.List;

public class OutputView {
    public void updateLottos(List<List<Integer>> numbersOfLottos) {
        System.out.println("\n" + numbersOfLottos.size() + "개를 구매했습니다.");
        for (int i = 0; i < numbersOfLottos.size(); i++) {
            System.out.println(numbersOfLottos.get(i));
        }
    }

    private String makePadding(int tail) {
        if (tail < 10) {
            return "00" + tail;
        }
        if (tail < 100) {
            return "0" + tail;
        }
        return Integer.toString(tail);
    }

    private String makeComma(int prize) {
        String commaIn = "";
        while (prize > 1000) {
            int tail = prize % 1000;
            commaIn = "," + makePadding(tail) + commaIn;
            int head = prize / 1000;
            prize = head;
        }
        commaIn = prize + commaIn;
        return commaIn;
    }

    public void updateResults(Result[] results) {
        System.out.println("\n당첨 통계\n---");
        for (int i = 0; i < results.length - 1; i++) {
            Result result = results[i];
            if (i == 3) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (" + makeComma(result.prize()) + "원) - %d개\n",
                        (int) Math.floor(result.winningPoints()), result.winningCounts());
                continue;
            }
            System.out.printf("%d개 일치 (" + makeComma(result.prize()) + "원) - %d개\n",
                    (int) Math.floor(result.winningPoints()), result.winningCounts());
        }
    }

    public void updatePrizeRate(double prizeRate) {
        System.out.printf("총 수익률은 %.2f" + "%s입니다.", prizeRate, "%");
    }

}
