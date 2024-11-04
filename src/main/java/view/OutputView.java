package view;

import java.util.List;

public class OutputView {
    public static void outBuyingPriceView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void outBuyingQuantityView(int buyingQuantity) {
        System.out.println();
        System.out.println(buyingQuantity + "개를 구매했습니다.");
    }

    public static void outGenerateNumbersView(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void outLottoNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void outBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
