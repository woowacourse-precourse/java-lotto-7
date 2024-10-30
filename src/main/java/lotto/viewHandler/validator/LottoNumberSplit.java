package lotto.viewHandler.validator;

import lotto.viewHandler.Validator;
import lotto.viewHandler.exception.NotLottoNumberSize;

import java.util.List;

public class LottoNumberSplit implements Validator<List<String>, String> {
    @Override
    public List<String> validate(String input) {
        List<String> split = List.of(input.split(","));
        if(split.size() != 6) {
            throw new NotLottoNumberSize("6개의 숫자가 입력 안되었습니다.");
        }
        return split;
    }
}
