package lotto.service;

import java.util.List;

public class LottoService {

    public List<String> parseInputToList(String inputLottoNumbers) {
        String[] splitLottoNumbers = inputLottoNumbers.split(",");
        for (String number : splitLottoNumbers) {
            if (!isInteger(number.trim())) {
                throw new IllegalArgumentException("[ERROR] 입력값은 모두 정수여야 합니다.");
            }
        }
        return List.of(splitLottoNumbers);
    }

    public Integer parseToInteger(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 정수여야 합니다.");
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
