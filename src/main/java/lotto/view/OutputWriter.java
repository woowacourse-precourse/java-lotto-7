package lotto.view;

import java.util.List;
import java.util.Set;

public class OutputWriter {

    public void printLottoNumbers(int lottoCount, List<Set<Integer>> totalLottoNumbers) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Set<Integer> lottoNumbers : totalLottoNumbers) {
            System.out.println(lottoNumbers);
        }
    }
}
