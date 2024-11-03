package lotto;

public class LottoPurchaseService {

    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_PRICE = 0;
    public static final int ERROR = 1;

    private static final String EMPTY_INPUT_ERROR = "[ERROR] 아무것도 입력되지 않았습니다.";
    private static final String NEGATIVE_INPUT_ERROR = "[ERROR] 구입 금액은 양수여야 합니다.";
    private static final String INVALID_INPUT_ERROR = "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.";

    private final int lottoCount;

    public LottoPurchaseService(String price) {
        int numericPrice = validate(price);
        this.lottoCount = numericPrice/LOTTO_PRICE;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private int validate(String price) {
        try {
            if (price == null || price.isBlank()) {
                throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
            }

            int numericPrice = Integer.parseInt(price);

            if (numericPrice < MIN_PRICE) {
                throw new IllegalArgumentException(NEGATIVE_INPUT_ERROR);
            }

            if (numericPrice % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException(INVALID_INPUT_ERROR);
            }

            return numericPrice;
        } catch (IllegalArgumentException e) {
            return ERROR;
        }
    }
}
