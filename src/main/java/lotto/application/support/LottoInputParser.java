package lotto.application.support;

import lotto.common.Errors;

public class LottoInputParser {

    public int parseAmount(String amount){
        try{
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            Errors.IllegalArgumentException("금액은 숫자로 입력해야 합니다.");
        }
        return -1;
    }
}
