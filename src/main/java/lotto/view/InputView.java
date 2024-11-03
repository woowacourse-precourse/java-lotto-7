package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.Validator;

/**
 * InputView 클래스
 * 사용자로부터 구입 금액, 당첨 번호, 보너스 번호를 입력받고 유효성을 검증하는 클래스
 */
public class InputView {

    /**
     * 구입 금액 입력을 받아 반환
     *
     * @return 구입 금액
     * @throws IllegalArgumentException 유효하지 않은 금액일 경우 예외 발생
     */
    public int inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요:");
        try {
            int amount = Integer.parseInt(Console.readLine().trim());
            Validator.validatePurchaseAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해 주세요.");
        }
    }

    /**
     * 당첨 번호 입력을 받아 리스트로 반환
     *
     * @return 당첨 번호 리스트
     * @throws IllegalArgumentException 유효하지 않은 입력일 경우 예외 발생
     */
    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요 (예: 1,2,3,4,5,6):");
        String input = Console.readLine();
        List<Integer> numbers = parseAndValidateWinningNumbers(input);
        Validator.validateWinningNumbers(numbers);
        return numbers;
    }

    /**
     * 보너스 번호를 입력받아 반환
     *
     * @return 보너스 번호
     * @throws IllegalArgumentException 유효하지 않은 입력일 경우 예외 발생
     */
    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요:");
        try {
            int bonusNumber = Integer.parseInt(Console.readLine().trim());
            Validator.validateBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해 주세요.");
        }
    }

    /**
     * 문자열을 파싱하고 당첨 번호 유효성을 검증
     *
     * @param input 당첨 번호 입력 문자열
     * @return 정수 리스트로 변환된 당첨 번호
     * @throws IllegalArgumentException 유효하지 않은 형식일 경우 예외 발생
     */
    private List<Integer> parseAndValidateWinningNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 숫자 형식이어야 합니다.");
        }
    }
}