package lotto.common.constant;

public class LottoConst {

    public static final int LOTTO_PRICE = 1000;

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String NOT_NUMBER_MSG = "구매하고 싶은 정확한 금액을 입력해주세요.";
    public static final String CANT_DIVIDE_MSG = String.format("로또의 한 장당 가격은 %d원 입니다. %d원 단위로 입력해주세요.",
            LottoConst.LOTTO_PRICE, LottoConst.LOTTO_PRICE);

}
