package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printPurchaseAmount(int purchaseAmount) {
        System.out.println();
        System.out.println(purchaseAmount+ "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottoNumbers) {
        lottoNumbers.forEach(System.out::println);
        System.out.println();
    }




}
