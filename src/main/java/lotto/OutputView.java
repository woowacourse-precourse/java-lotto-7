package lotto;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    static final String FIRST_OUT_PRINT = "개를 구매했습니다.";
    static final String SECOND_OUT_PRINT = "당첨 통계\n---\n";
    int count;

    ArrayList<List<Integer>> lotto = new ArrayList<>();

    public OutputView(int count, ArrayList<List<Integer>> lotto) {
        this.count = count;
        this.lotto = lotto;
    }

    public void buyCountPrint() {
        System.out.println(count + FIRST_OUT_PRINT);
    }

    public void lottosPrint() {
        for (List<Integer> lottoList : lotto) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (Integer value : lottoList) {
                sb.append(value + ", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append("]");
            System.out.println(sb.toString());
        }
    }

    public void matchPrint(int[] winCounts, double profitRate) {
        System.out.println(SECOND_OUT_PRINT);
        System.out.printf("3개 일치 (5,000원) - %d개\n", winCounts[0]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", winCounts[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winCounts[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winCounts[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winCounts[4]);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
