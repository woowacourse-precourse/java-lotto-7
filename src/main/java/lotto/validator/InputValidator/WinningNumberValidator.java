package lotto.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.LottoValidator;

public class WinningNumberValidator implements InputValidator<List<Integer>> {


    @Override
    public List<Integer> validate(String input) {
        String[] numbers = input.split(",", -1); // 입력된 문자열을 쉼표로 분리하여 배열로 변환
        List<Integer> winningNumbers = isNumber(numbers); // 배열을 숫자 리스트로 변환
        LottoValidator.validate(winningNumbers);
        return winningNumbers; // 배열을 숫자 리스트로 변환
    }

    // 문자열 배열을 정수 리스트로 변환하며 유효성 검증
    private List<Integer> isNumber(String[] input) {
        try {
            List<Integer> winningNumbers = new ArrayList<>();
            for (String winningNumber : input) {
                winningNumbers.add(Integer.parseInt(winningNumber)); // 공백 제거 후 정수 변환
            }
            return winningNumbers; // 변환된 리스트 반환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 유효한 숫자를 입력해야 합니다.");
        }
    }


}
