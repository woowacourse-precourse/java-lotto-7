package lotto;

import java.util.Arrays;
import java.util.List;

public class Output {
    public static void printLotto(List<Lotto> values) {
//        System.out.println(values.size() + "개를 구매했습니다.");
        System.out.println(values.size() + " Purchase Lotto.");
        for (int i = 0; i < values.size(); i++) {
            System.out.println(Arrays.toString(values.get(i).getNumbers().toArray()));
        }
        System.out.println();
    }

    public static void printWinner() {
//        System.out.println("당첨 통계");
        System.out.println("Winner Statistics");
        System.out.println("---");


    }
}
