package lotto.common.rule;

public class Rule {

    /**
     * 로또 생성 rule
     */
    public static final int LOTTO_LENGTH = 6;
    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_MAXIMUM_NUMBER = 45;

    /**
     * money rule
     */
    public static final long MONEY_MINIMUM_VALUE = 1000;
    public static final int LOTTO_PRICE = 1000;

    // parsing rule
    public static final String LIST_DELIMITER = ",";

    private Rule() {
    }
}
