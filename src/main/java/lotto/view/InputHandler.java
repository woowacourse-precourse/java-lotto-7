package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.util.Validator;

public class InputHandler {

    // 구입 금액 입력 및 검증
    public static int getValidMoney() {
        while (true) {
            try {
                int money = Validator.validateAndParseNumber(Inputview.inputMoney());
                Validator.validatePurchaseAmount(money); // 1,000원 단위 검사
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 당첨 번호 입력 및 검증
    public static List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                String winningNumbers = Inputview.inputWinningNumbers();
                List<Integer> numbers = parseWinningNumbers(winningNumbers); // 파싱
                validateWinningNumbers(numbers); // 검증
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 보너스 번호 입력 및 검증
    public static int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = Validator.validateAndParseNumber(Inputview.inputBonusNumber());
                Validator.validateBonusNumberDuplication(winningNumbers, bonusNumber); // 중복 확인
                Validator.validateLottoNumberRange(List.of(bonusNumber)); // 범위 확인
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 당첨 번호를 파싱하는 메서드
    private static List<Integer> parseWinningNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String num : numberStrings) {
            numbers.add(Validator.validateAndParseNumber(num.trim())); // 숫자 형식 확인 및 파싱
        }

        return numbers;
    }

    // 파싱된 당첨 번호 리스트를 검증하는 메서드
    private static void validateWinningNumbers(List<Integer> numbers) {
        Validator.validateLottoNumberCount(numbers); // 6개 숫자 검사
        Validator.validateLottoNumberRange(numbers); // 범위 검사
        Validator.validateLottoNumberDuplication(numbers); // 중복 검사
    }
}
