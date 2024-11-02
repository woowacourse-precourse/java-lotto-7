package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.BonusNumberValidator;
import lotto.model.Lotto;
import lotto.validator.LottoValidator;
import lotto.model.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    // 로또 구입 금액을 입력받는 메서드
    public int readPurchaseAmount() {
        System.out.println("로또 구입 금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                return parseAndValidatePurchaseAmount(input); // 숫자 변환 및 유효성 검사
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseAndValidatePurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
        LottoValidator.validatePurchaseAmount(amount);
        return amount;
    }

    public List<Integer> readWinningNumbersFromInput() {
        System.out.println("당첨 번호를 입력해 주세요.(예: 1, 2, 3, 4, 5, 6) : ");
        while (true) {
            try {
                String input = Console.readLine();
                return parseAndValidateWinningNumbers(input); // 입력 파싱 및 유효성 검사
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseAndValidateWinningNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            winningNumbers.add(Integer.parseInt(numberString.trim()));
        }
        new Lotto(winningNumbers); // Lotto 객체를 생성하여 유효성 검증 수행
        return winningNumbers;
    }

    public static int readBonusNumberFromInput() {
        System.out.println("보너스 번호를 입력해 주세요. : ");
        while (true) {
            try {
                String input = Console.readLine();
                return parseAndValidateBonusNumber(input); // 입력 파싱 및 유효성 검사
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int parseAndValidateBonusNumber(String input) {
        BonusNumberValidator.validateBonusNumberIsNumeric(input); // 숫자 형식 검증
        int bonusNumber = Integer.parseInt(input);
        BonusNumberValidator.validateBonusNumberRange(bonusNumber); // 범위 검증
        return bonusNumber;
    }

    public WinningNumbers readWinningNumbers() {
        List<Integer> winningNumbers = readWinningNumbersFromInput();
        int bonusNumber = readBonusNumberFromInput();
        BonusNumberValidator.validateBonusNumberNotDuplicate(bonusNumber, winningNumbers); // 중복 검증
        return new WinningNumbers(winningNumbers, bonusNumber);
    }
}
