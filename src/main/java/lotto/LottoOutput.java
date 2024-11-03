package lotto;

import java.util.List;

public class LottoOutput {
    public void printLottoCount(int lottoQuantity) {
        System.out.println("\n" + lottoQuantity + "개를 구매했습니다.");
    }

    public void printUserLottoNumbers(List<List<Integer>> allUserLottoNumbers) {
        for (List<Integer> userLottoNumbers : allUserLottoNumbers) {
            System.out.println(userLottoNumbers);
        }
    }
}
