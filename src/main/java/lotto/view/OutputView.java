package lotto.view;

public class OutputView {
    enum Description {
        ASK_PURCHASE_PRICE("구입금액을 입력해 주세요."),
        LOTTO_COUNT("개를 구매했습니다.");

        private final String description;

        Description(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

    public void askPurchasePrice() {
        System.out.println(Description.ASK_PURCHASE_PRICE);
    }

    public void lottoPurchasedCount(int count) {
        System.out.println(count + "" + Description.LOTTO_COUNT);
    }
}
