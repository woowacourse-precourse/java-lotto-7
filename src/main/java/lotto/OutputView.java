package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printPickNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
