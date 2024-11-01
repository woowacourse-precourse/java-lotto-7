package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    public static void printLottoCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }
    public static void printLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }
}
