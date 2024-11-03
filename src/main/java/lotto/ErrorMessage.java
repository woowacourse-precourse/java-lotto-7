package lotto;

import static lotto.LottoConstant.PRICE;

public enum ErrorMessage {

    AMOUNT_FORMAT_ERROR("금액은 정수 형태로 입력해야 합니다."),
    NUMBER_FORMAT_ERROR("잘못된 로또 번호입니다."),
    NUMBER_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NUMBER_COUNT_ERROR("로또 번호는 6개여야 합니다."),
    INVALID_AMOUNT_UNIT("구매 금액은 " + PRICE + "원 단위로 입력해야 합니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호는 당첨번호와 중복되지 않아야 합니다."),
    DUPLICATED_NUMBER_ERROR("중복된 번호가 없어야 합니다.");

    private final String content;

    ErrorMessage(String content){
        this.content =content;
    }

    public String getValue(){
        return content;
    }
}
