package lotto;

public final class Constant {
    public static final int LOTTO_CHARGE = 1000;
    public static final int LOTTO_START = 1;
    public static final int LOTTO_END = 45;
    public static final int LOTTO_BONUS_APPLY = 5;
    public static final int LOTTO_BONUS_CORRECT = 10;

    private Constant() {
        throw new AssertionError("Constant 클래스는 인스턴스화 할 수 없습니다.");
    }
}
