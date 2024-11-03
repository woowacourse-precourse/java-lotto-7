package lotto.domain;

public class LottoConstants {
    public static final int LOTTO_SIZE = 6;
    public static final String IS_NOT_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String IS_DUPLICATE_NUMBER = "[ERROR] 중복된 번호가 있습니다.";
    public static final String IS_NOT_LOTTO_NUMBER = "[ERROR] 로또번호가 1~45가 아닙니다.";
    public static final int LOTTO_MIN_NUM = 1;
    public static final int LOTTO_MAX_NUM = 45;
    public static final String CAN_NOT_BUY_LOTTO = "[ERROR] 로또를 살 수 없는 금액입니다.";

    public static final String CAN_NOT_BUY_LOTTO_AMOUNT = "[ERROR] 로또는 1000원 단위로 구입 가능합니다.";
    public static final int GAME_PRICE = 1000;
}
