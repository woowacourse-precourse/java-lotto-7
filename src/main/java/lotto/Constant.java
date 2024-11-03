package lotto;

public final class Constant {
    public static final int LOTTO_CHARGE = 1000;
    public static final int LOTTO_START = 1;
    public static final int LOTTO_END = 45;
    public static final int LOTTO_NUMBERS_LIMIT = 6;
    public static final int LOTTO_FIVE_HIT = 5;
    public static final int LOTTO_BONUS_HIT = 10;

    private Constant() {
        throw new AssertionError("Constant 클래스는 인스턴스화 할 수 없습니다.");
    }
}
