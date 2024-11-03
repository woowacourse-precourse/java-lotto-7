package lotto.view;

import java.util.List;

public class ResultView {
    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printLottoSetCount(int lottoSetCount) {
        System.out.println(lottoSetCount+"개를 구매했습니다.");
    }
}
