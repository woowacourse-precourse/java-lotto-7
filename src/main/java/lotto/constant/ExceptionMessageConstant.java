package lotto.constant;

public class ExceptionMessageConstant {

    private static final String PREFACE = "[ERROR] ";
    public static final String INVALID_LOTTO_PURCHASE_AMOUNT_FORMAT = PREFACE + "로또 구입 금액은 숫자입니다.";
    public static final String INVALID_LOTTO_NUMBER_FORMAT = PREFACE + "로또 번호는 숫자입니다.";
    public static final String INVALID_LOTTO_PURCHASE_AMOUNT_UNIT =
            PREFACE + "로또 구입 금액 단위는 " + LottoPurchaseConstant.AMOUNT_UNIT + " 입니다.";
    public static final String INVALID_LOTTO_REQUIRED_COUNT =
            PREFACE + "로또 당첨 번호의 개수는 " + LottoNumberConstant.REQUIRED_COUNT + "개 입니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE =
            PREFACE + "로또 번호는 " + LottoNumberConstant.MIN_NUMBER + "~" + LottoNumberConstant.MAX_NUMBER + "까지 입니다.";

}
