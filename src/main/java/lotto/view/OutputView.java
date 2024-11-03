package lotto.view;

import java.util.List;

public class OutputView {

    public static void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");
        lottoNumbers.forEach(System.out::println);
    }
}
