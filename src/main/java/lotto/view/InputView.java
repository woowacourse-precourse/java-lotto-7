package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class InputView {

    public int inputPayment() {
        int payment = 0;
        int lottoAmount = 0;
        while (true) {
            try {
                payment = Integer.parseInt(Console.readLine());
                lottoAmount = countIssueLottoNumber(payment);
                validatePayment(payment);
                break;
            } catch (NumberFormatException formatException) {
                System.out.println("[ERROR] 입력 형식 오류 : 숫자를 입력하세요.");
            } catch (IllegalArgumentException divide1000Exception) {
                System.out.println("[ERROR] "+divide1000Exception.getMessage());
            }
        }
        return lottoAmount;
    }

    // 구입금액을 1000으로 나누어 로또 구입 갯수를 반환하는 함수
    private int countIssueLottoNumber(int amountPaid) {
        if (amountPaid % 1000 != 0) {
            throw new IllegalArgumentException("입력 형식 오류 : 지불 금액이 1000으로 나누어 떨어지지 않습니다");
        }
        // else 쓰지 말기
        return amountPaid / 1000;
    }

    private void validatePayment(int payment) {
        if (payment <= 0 ) {
            throw new IllegalArgumentException("입력 범위 오류 : 지불 금액은 0보다 커야 합니다.");
        }
    }


    //  당첨 번호 입력 받기, 형식 검증, 리스트로 반환
    public List<Integer> inputWinningNumbersString() {
        String input;
        List<Integer> winningNumbers;
        while(true) {
            try {
                input = Console.readLine();
                validateWinningNumbersFormat(input);
                winningNumbers = winningNumbers(input);
                break;
            } catch (IllegalArgumentException formatException) {
                System.out.println("[ERROR] " + formatException.getMessage());
            }
        }
        return winningNumbers;
    }

    // 보너스 번호 입력 받기, 형식 검증, 범위 검증
    public int inputBonusNumberString(List<Integer> winningNumbers) {
        int bonusNumber = 0;
        String bonusInput;
        while(true) {
            try {
                bonusInput = Console.readLine();
                bonusNumber = validateBonusNumberFormat(bonusInput);
                validateNumbersRange(bonusNumber);
                validateIsInWinningNumber(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException argumentException) {
                System.out.println("[ERROR] "+ argumentException.getMessage());
            }
        }
        return bonusNumber;
    }

    private void validateIsInWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("입력 중복 오류 : 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private int validateBonusNumberFormat(String inputBonusNumber) {
        int bonus = 0;
        try {
            bonus = Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException formatException) {
            throw new NumberFormatException("입력 형식 오류 : 숫자를 입력하세요.");
        }
        return bonus;
    }

    // 입력 형식 벨리데이션
    private void validateWinningNumbersFormat(String inputString) {
        String pattern = "^\\d+(,\\d+){5}$";
        if (!inputString.matches(pattern)) {
            throw new IllegalArgumentException("입력 형식 오류 : 양수 6개를 ,로 구분하여 입력하세요.");
        }
    }

    // 번호 범위 검증
    private void validateNumbersRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("입력 범위 오류 : 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // 번호 중복 검증
    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("입력 중복 오류 : 로또 번호는 중복될 수 없습니다.");
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
