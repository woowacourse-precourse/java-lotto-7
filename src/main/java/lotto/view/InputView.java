package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.BonusNumberValidator;
import lotto.model.Lotto;
import lotto.validator.LottoValidator;
import lotto.model.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    // 로또 구입 금액 입력
    public int readPurchaseAmount() {
        System.out.println("로또 구입 금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                return parseAndValidatePurchaseAmount(input); // 구입 금액 숫자 변환 및 유효성 검사
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseAndValidatePurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
        LottoValidator.validatePurchaseAmount(amount); // 구입 금액 유효성 검사
        return amount;
    }

    // 당첨 번호 입력
    public List<Integer> readWinningNumbersFromInput() {
        System.out.println("당첨 번호를 입력해 주세요.(예: 1, 2, 3, 4, 5, 6) : ");
        while (true) {
            try {
                String input = Console.readLine();
                return parseAndValidateWinningNumbers(input); // 입력된 당첨 번호의 파싱 및 유효성 검사
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
            winningNumbers.add(Integer.parseInt(numberString.trim())); // 입력된 숫자 파싱 후 리스트에 추가
        }
        new Lotto(winningNumbers); // Lotto 객체 생성하여 유효성 검증 수행
        return winningNumbers;
    }

    // 보너스 번호 입력
    public static int readBonusNumberFromInput() {
        System.out.println("보너스 번호를 입력해 주세요. : ");
        while (true) {
            try {
                String input = Console.readLine();
                return parseAndValidateBonusNumber(input); // 보너스 번호의 파싱 및 유효성 검사
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int parseAndValidateBonusNumber(String input) {
        BonusNumberValidator.validateBonusNumberIsNumeric(input); // 숫자 형식 유효성 검사
        int bonusNumber = Integer.parseInt(input);
        BonusNumberValidator.validateBonusNumberRange(bonusNumber); // 범위 유효성 검사
        return bonusNumber;
    }

    // 당첨 번호 및 보너스 번호 입력 후 WinningNumbers 객체 생성
    public WinningNumbers readWinningNumbers() {
        List<Integer> winningNumbers = readWinningNumbersFromInput(); // 당첨 번호 리스트 입력
        int bonusNumber = readBonusNumberFromInput(); // 보너스 번호 입력
        BonusNumberValidator.validateBonusNumberNotDuplicate(bonusNumber, winningNumbers); // 보너스 번호 중복 검증
        return new WinningNumbers(winningNumbers, bonusNumber);
    }
}
