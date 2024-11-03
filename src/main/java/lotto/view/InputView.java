package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
            validatePurchaseAmount(amount);
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
        return parseAndValidateWinningNumbers(input);
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
            validateBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수로 입력해 주세요.");
        }
    }

    /**
     * 구입 금액의 유효성을 검증
     *
     * @param amount 구입 금액
     * @throws IllegalArgumentException 유효하지 않은 금액일 경우
     */
    private void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    /**
     * 문자열을 파싱하고 당첨 번호 유효성을 검증
     *
     * @param input 당첨 번호 입력 문자열
     * @return 정수 리스트로 변환된 당첨 번호
     */
    List<Integer> parseAndValidateWinningNumbers(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            validateWinningNumbers(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 숫자 형식이어야 합니다.");
        }
    }

    /**
     * 당첨 번호 리스트의 유효성을 검증
     *
     * @param numbers 당첨 번호 리스트
     * @throws IllegalArgumentException 유효하지 않은 번호가 포함된 경우
     */
    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자로 입력해야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다.");
        }
    }

    /**
     * 보너스 번호의 유효성을 검증
     *
     * @param number 보너스 번호
     * @throws IllegalArgumentException 보너스 번호가 범위 밖일 경우
     */
    void validateBonusNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }
    }
}