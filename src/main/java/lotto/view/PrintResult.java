package lotto.view;

import lotto.service.CreateNumbers;
import lotto.service.Prize;

import java.util.List;

public class PrintResult {
    private CreateNumbers createNumbers;

    public PrintResult(CreateNumbers createNumbers) {
        this.createNumbers = createNumbers;
    }

    public void printMyLotto(int number) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", number);

        for (List<Integer> lotto : createNumbers.getNumbers()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void result(int[] winningList, int number) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.printf("3개 일치 (5,000원) - %d개\n", winningList[0]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", winningList[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winningList[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winningList[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winningList[4]);

        double rate = returnRate(winningList, number);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rate);
    }

    private double returnRate(int[] winningList, int number) {
        double totalPrize = 0;

        for (Prize price : Prize.values()) {
            totalPrize += winningList[price.ordinal()] * price.getPrice();
        }

        return (totalPrize / (number * 1000)) * 100;
    }
}
