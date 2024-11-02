package lotto.view;

public class OutputView {
    private static final String LINE_SEPARATOR = "\n";
    enum Description {
        ASK_PURCHASE_PRICE("구입금액을 입력해 주세요."),
        LOTTO_COUNT("개를 구매했습니다."),
        ASK_WINNING_NUMBER("당첨 번호를 입력해 주세요.");

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
        System.out.println(LINE_SEPARATOR + count + Description.LOTTO_COUNT);
    }

    public void lottoPurchasedDetail(String lottos){
        System.out.println(lottos);
    }

    public void askWinningNumber(){
        System.out.println(Description.ASK_WINNING_NUMBER);
    }
}
