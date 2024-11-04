package lotto.config.constant;

import static lotto.config.constant.LottoNumberConstant.MAX_NUMBER;
import static lotto.config.constant.LottoNumberConstant.MIN_NUMBER;
import static lotto.config.constant.LottoNumberConstant.REQUIRED_COUNT;
import static lotto.config.constant.LottoPurchaseConstant.AMOUNT_UNIT;

public class ExceptionMessageConstant {

    private static final String PREFACE = "[ERROR] ";

    public static final String INVALID_LOTTO_PURCHASE_AMOUNT_FORMAT = PREFACE + "로또 구입 금액은 숫자입니다.";
    public static final String INVALID_LOTTO_NUMBER_FORMAT = PREFACE + "로또 번호는 숫자입니다.";
    public static final String INVALID_LOTTO_PURCHASE_AMOUNT_UNIT = PREFACE + "로또 구입 금액 단위는 " + AMOUNT_UNIT + " 입니다.";
    public static final String INVALID_LOTTO_REQUIRED_COUNT = PREFACE + "로또 당첨 번호의 개수는 " + REQUIRED_COUNT + "개 입니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = PREFACE + "로또 번호는 " + MIN_NUMBER + "~" + MAX_NUMBER + "까지 입니다.";

    public static final String DUPLICATED_LOTTO_NUMBER = PREFACE + "로또 번호는 중복되지 않아야 합니다.";
    public static final String UNKNOWN_RANK = PREFACE + "일치하는 순위를 찾을 수 없습니다.";

}
