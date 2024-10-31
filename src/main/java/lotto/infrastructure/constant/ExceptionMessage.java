package lotto.infrastructure.constant;

public final class ExceptionMessage {
    public static final String DUPLICATE = "서로 중복된 숫자가 존재합니다.";

    public static final String PURCHASE_LESS_THAN_ONE = "구입 금액은 양의 정수만 입력할 수 있습니다.";

    public static String INVALID_LOTTO_COUNT(int count) {
        return String.format("로또 번호는 %d개여야 합니다.", count);
    }

    public static String INVALID_PURCHASE_UNIT(int unit) {
        return String.format("구입 금액은 %d 단위의 정수만 가능합니다.", unit);
    }
}
