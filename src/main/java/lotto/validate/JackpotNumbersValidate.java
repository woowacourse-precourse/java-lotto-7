package lotto.validate;

import java.util.List;

public class JackpotNumbersValidate{
    public void validate(List<Integer> values) {
        for (Integer value : values) {
            if(value < 1 || value > 45) {
                throw new IllegalArgumentException("\n올바르지 않은 로또 번호입니다.\n");
            }
        }
    }
}
