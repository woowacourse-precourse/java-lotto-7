package view;

import Model.Lotto;

import java.util.List;

public class OutputView {

    public static void PurchasedLottoCount(List<Lotto> lottoNumbers) {
        int length = lottoNumbers.size();
        System.out.println("\n" + length + "개를 구매했습니다.");
        for (Lotto lotto : lottoNumbers) {
            printLottoNumbers(lotto);
        }
    }

    public static void printLottoNumbers(Lotto lotto) {
        List<Integer> lottosorted = lotto.getSortedLotto();
        int length = lottosorted.size();

        System.out.print("[");
        for (int i = 0 ; i < length; i++) {
            System.out.print(lottosorted.get(i));
            if (i != length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\n");
    }
    public static void printWinnerDetails(List<Integer> checkcount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        List<String> prizeDescriptions = List.of(
                "3개 일치 (5,000원)",
                "4개 일치 (50,000원)",
                "5개 일치 (1,500,000원)",
                "5개 일치, 보너스 볼 일치 (30,000,000원)",
                "6개 일치 (2,000,000,000원)"
        );

        for(int i = 0 ; i < checkcount.size(); i++) {
            int count = checkcount.get(i);
            System.out.println(prizeDescriptions.get(i) + " - " + count + "개");
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        String message = String.format("총 수익률은 %.1f%%입니다.", rateOfReturn);
        System.out.println(message);
    }
}