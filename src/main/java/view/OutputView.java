package view;

public class OutputView {
    public static void outBuyingPriceView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void outBuyingQuantityView(int buyingQuantity) {
        System.out.println();
        System.out.println(buyingQuantity + "개를 구매했습니다.");
    }
}
