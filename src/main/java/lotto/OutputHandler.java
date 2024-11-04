package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputHandler {
    public static void printLottos(List<Lotto> lottos) {
        printLottoCount(lottos.size());
        lottos.forEach(OutputHandler::printLottoNumbers);
    }

    private static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    private static void printLottoNumbers(Lotto lotto) {
    List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
    Collections.sort(sortedNumbers);
    System.out.println(sortedNumbers);
    }
}
