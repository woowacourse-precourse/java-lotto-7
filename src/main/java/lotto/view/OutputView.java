package lotto.view;

import java.util.List;

public class OutputView {

    public static final String PUBLISHED_LOTTO_MSG = "\n%d개를 구매했습니다.";

    public static void outputPublishedLotto(int lottoCnt, List<List<Integer>> lottosNumbers) {
        String publishedLottoTitle = String.format(PUBLISHED_LOTTO_MSG, lottoCnt);
        System.out.println(publishedLottoTitle);
        for (List<Integer> lottoNumbers : lottosNumbers) {
            System.out.println(lottoNumbers);
        }
    }

    public static void outputMessage(String message) {
        System.out.println(message);
    }
}
