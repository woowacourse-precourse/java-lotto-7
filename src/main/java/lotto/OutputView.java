package lotto;

public class OutputView {

    private final static String PRINT_QUANTITY = "개를 구매했습니다.";

    public static void printReceipt(LottoReceipt lottoReceipt) {
        System.out.println(lottoReceipt.getQuantity() + PRINT_QUANTITY);
        for (Lotto lottery : lottoReceipt.getLotteries()) {
            System.out.println(lottery);
        }

    }
}
