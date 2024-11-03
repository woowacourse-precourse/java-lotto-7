package lotto.model.lotto;
// 구입 수량 객체
public class PurchaseAmount {

    private static final String INVALID_NUMERIC_MESSAGE = "[ERROR] 구입 금액은 숫자만 입력 가능합니다.";
    private static final String INVALID_MIN_AMOUNT_MESSAGE = "[ERROR] 구입 가능 최소 금액은 1,000원 입니다.";
    private static final String INVALID_EMPTY_MESSAGE = "[ERROR] 구입 금액이 빈 값입니다.";
    private static final String INVALID_AMOUNT_UNIT_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위로 입력 가능합니다.";

    private static final int MIN_AMOUNT = 1000;
    private static final int AMOUNT_UNIT = 1000;

    private final int amount;

    private PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }
    // 입력 받은 구입 수량을 검증하고 해당 값을 기분으로 PurchaseAmount객체를 생성한다.
    // 고민 -> input 값을 argument로 받아와 이를 검증하고 사용가능하면 변환해 바로 PurchaseAmount의 값으로 이용하는데
    // 이러한 작업이 PurchaseAmount가 모두 책임져야할 책임인지 확실한 판단이 서질 않아요...
    public static PurchaseAmount from(String input) {
        validateEmpty(input);
        validateNumeric(input);
        return new PurchaseAmount(Integer.parseInt(input));
    }

    private static void validateNumeric(String amount) {
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMERIC_MESSAGE);
        }
    }

    private static void validateEmpty(String amount) {
        if (amount == null || amount.isBlank()) {
            throw new IllegalArgumentException(INVALID_EMPTY_MESSAGE);
        }
    }

    private void validate(int amount) {
        validateMinAmount(amount);
        validateUnit(amount);
    }

    private void validateMinAmount(int amount) {
        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException(INVALID_MIN_AMOUNT_MESSAGE);
        }
    }

    private void validateUnit(int amount) {
        if (amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT_MESSAGE);
        }
    }
    // PurchaseAmount 객체에서 totalPrizeMoney를 이용해서 수익률을 계산해주는 책임을 가지는 것이 좋을까?
    // 만일 총 수익률을 계산하는 로직이 변경된다면 PurchaseAmount의 변경 이유가 늘어나는 것인데 이를 PurchaseAmount가 가지고 있는 것은 적절한 책임일가?
    // 하지만 calculate를 담담하는 객체를 따로 생성해서 Calculator에 totalPrizeMoney값과 PurchaseAmount를 get으로 보내서 해당 객체에서 계산하는 것이 적절한 책임일까?
    // 해당 기능을 분기할 필요가 있다면 분기한는 것도 좋을 것 같다!
    public double calculateProfitPercentage(int totalPrizeMoney) {
        double profitPercentage = ((double) totalPrizeMoney / amount) * 100;
        return (double) Math.round(profitPercentage * 100) / 100.0;
    }

    public int getPurchasableLottoAmount() {
        return amount / AMOUNT_UNIT;
    }

}
