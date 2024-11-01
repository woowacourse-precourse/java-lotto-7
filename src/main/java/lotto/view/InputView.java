package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class InputView {
    // 정수 변환 및 예외 처리
    public int inputPayment() {
        int payment = 0;
        while (true) {
            try {
                payment = Integer.parseInt(Console.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력하세요.");
            }
        }
        return payment;
    }


    //  당첨 번호 입력 받기, 형식 검증
    public String inputWinningNumbersString() {
        String input = Console.readLine();
        validateWinningNumbersFormat(input);
        return input;
    }

    // 보너스 번호 입력 받기, 형식 검증
    public int inputBonusNumberString() {
        String bonusNumber = Console.readLine();
        return validateBonusNumber(bonusNumber);
    }

    private int validateBonusNumber(String inputBonusNumber) {
        int bonus = 0;
        while(true) {
            try {
                bonus = Integer.parseInt(inputBonusNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력하세요.");
            }
        }


        validateNumbersRange(bonus);

        return bonus;
    }

    // 입력 형식 벨리데이션
    private void validateWinningNumbersFormat(String inputString) {
        String pattern = "^\\d+(,\\d+){5}$";
        if (!inputString.matches(pattern)) {
            System.out.println("[ERROR] 입력 형식이 잘못되었습니다. 올바른 입력 예) 1,2,3,4,5,6");
        }
    }

    // 번호 범위 검증
    private void validateNumbersRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // 번호 중복 검증
    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    //  "숫자,숫자,숫자" 형식의 String을 int배열로 나누어 담기
    public List<Integer> winningNumbers(String validInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(validInput, ",");
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            validateNumbersRange(number);
            winningNumbers.add(number);
        }
        validateDuplicatedNumber(winningNumbers);
        return winningNumbers;
    }


}
