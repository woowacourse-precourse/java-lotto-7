package lotto.model;

public enum LottoWinningResult {

    THREE_MATCHES(5000) {
        @Override
        public String print(int count) {
            return "3개 일치 (5,000원) - " + count + "개";
        }
    },
    FOUR_MATCHES(50000) {
        @Override
        public String print(int count) {
            return "4개 일치 (50,000원) - " + count + "개";
        }
    },
    FIVE_MATCHES(1500000) {
        @Override
        public String print(int count) {
            return "5개 일치 (1,500,000원) - " + count + "개";
        }
    },
    FIVE_AND_BONUS_MATCHES(30000000) {
        @Override
        public String print(int count) {
            return "5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개";
        }
    },
    SIX_MATCHES(2000000000) {
        @Override
        public String print(int count) {
            return "6개 일치 (2,000,000,000원) - " + count + "개";
        }
    };

    private final int amount;

    LottoWinningResult(int amount) {
        this.amount = amount;
    }

    public abstract String print(int count);

    public int getAmount() {
        return amount;
    }

}
