package lotto.model.domain;

import static lotto.model.domain.LottoConstant.*;

class LottoError {
    public final static String WINNING_NUMBERS_SIZE_ERR = String.format("로또 번호는 %d개여야 합니다.", SIZE);
    public final static String LOTTO_NUM_OUT_OF_RANGE_ERR = String.format("로또 번호의 숫자 범위는 %d~%d까지 입니다.", MIN_NUM, MAX_NUM);
    public final static String DUPLICATE_NUMBER_ERR = "로또 번호에 중복된 숫자가 발견되었습니다.";
}
