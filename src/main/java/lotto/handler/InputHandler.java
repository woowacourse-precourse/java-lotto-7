package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import lotto.exceptioin.InputException;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    private static final String delimiter = ",";
    private final InputException validator = new InputException();

    // 구입 금액 입력 메서드
    public int inputMoney() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요:");
                int moneyValue = Integer.parseInt(Console.readLine().trim()); // 사용자 입력을 다시 받음
                validator.validateMoney(moneyValue); // 예외 검증
                return moneyValue;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식으로 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    // 당첨 번호 입력 메서드
    public List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요 (쉼표로 구분):");
                List<Integer> winningNumbers = new ArrayList<>();
                String[] numbers = Console.readLine().trim().split(delimiter);

                for (String numStr : numbers) {
                    winningNumbers.add(Integer.parseInt(numStr.trim()));
                }
                validator.validateLottoNumbers(winningNumbers); // 예외 검증
                return winningNumbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식으로 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    // 보너스 번호 입력 메서드
    public int inputBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요:");
                int bonusNumber = Integer.parseInt(Console.readLine().trim()); // 사용자 입력을 다시 받음
                validator.validateBonusNumber(bonusNumber); // 예외 검증
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식으로 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}