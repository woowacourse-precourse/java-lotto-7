package lotto.service;

import static lotto.utils.ErrorMessages.*;

import java.util.List;
import lotto.utils.ErrorMessages;

public class LottoService {

    public List<String> parseInputToList(String inputLottoNumbers) {
        String[] splitLottoNumbers = inputLottoNumbers.split(",");
        for (String number : splitLottoNumbers) {
            if (!isInteger(number.trim())) {
                throw new IllegalArgumentException(INPUT_MUST_INTEGER);
            }
        }
        return List.of(splitLottoNumbers);
    }

    public Integer parseToInteger(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_MUST_INTEGER);
        }
    }

    // 정수인지 확인하는 보조 메서드
    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
