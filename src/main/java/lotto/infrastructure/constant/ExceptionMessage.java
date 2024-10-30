package lotto.infrastructure.constant;

public final class ExceptionMessage {
    public static final String DUPLICATE = "서로 중복된 숫자가 존재합니다.";

    public static String INVALID_LOTTO_COUNT(int count) {
        return String.format("로또 번호는 %d개여야 합니다.", count);
    }
}
