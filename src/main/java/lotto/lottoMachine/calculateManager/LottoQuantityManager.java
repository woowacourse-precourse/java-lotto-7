package lotto.lottoMachine.calculateManager;

public class LottoQuantityManager {
    private static final int QUANTITY_AMOUNT_ONE_LOTTERY_TICKET = 1000;
    private static final String INFORMATION_WITH_LOTTO_QUANTITY = "개를 구매했습니다.";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final int lottoPurchaseAmount;

    public LottoQuantityManager(int lottoPurchaseAmount) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
    }

    public int getLottoQuantity() {
        int lottoQuantity = lottoPurchaseAmount / QUANTITY_AMOUNT_ONE_LOTTERY_TICKET;

        System.out.println(LINE_SEPARATOR + lottoQuantity + INFORMATION_WITH_LOTTO_QUANTITY);

        return lottoQuantity;
    }
}
