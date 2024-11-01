package lotto.view;

public class OutputView {
    enum Description {
        ASK_PURCHASE_PRICE("구입금액을 입력해 주세요.");

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
}
