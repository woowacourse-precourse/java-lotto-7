package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.BonusNumberValidator;
import lotto.model.Lotto;
import lotto.validator.LottoValidator;
import lotto.model.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class InputView { //숫자 형식, 로또 구입 금액, 당첨 번호, 보너스 번호 유효성 검사

    // 로또 구입 금액을 입력받는 메서드
    public int readPurchaseAmount() {
        System.out.println("로또 구입 금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                int amount = Integer.parseInt(input);

                // LottoValidator를 사용하여 구입 금액 검증
                LottoValidator.validatePurchaseAmount(amount);

                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> readWinningNumbersFromInput() {
        System.out.println("당첨 번호를 입력해 주세요.(예: 1, 2, 3, 4, 5, 6) : ");
        while (true) {
            try {
                String input = Console.readLine();
                String[] numberStrings = input.split(",");

                List<Integer> winningNumbers = new ArrayList<>();
                for (String numberString : numberStrings) {
                    winningNumbers.add(Integer.parseInt(numberString.trim()));
                }

                // Lotto 객체를 생성하여 입력된 번호 유효성 검증
                Lotto lotto = new Lotto(winningNumbers); // 여기에 validate 메서드가 호출됨

                return lotto.getNumbers(); // 유효성 검증된 로또 번호 리스트 반환

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int readBonusNumberFromInput() {
        System.out.println("보너스 번호를 입력해 주세요. : ");
        while (true) {
            try {
                String input = Console.readLine();

                // 숫자 형식인지 먼저 검증
                BonusNumberValidator.validateBonusNumberIsNumeric(input);

                int bonusNumber = Integer.parseInt(input);

                // 범위와 중복 여부 검증
                BonusNumberValidator.validateBonusNumberRange(bonusNumber);

                return bonusNumber; // 검증된 보너스 번호 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumbers readWinningNumbers() {
        List<Integer> winningNumbers = readWinningNumbersFromInput();
        int bonusNumber = readBonusNumberFromInput();

        // 중복 검증
        BonusNumberValidator.validateBonusNumberNotDuplicate(bonusNumber, winningNumbers);

        return new WinningNumbers(winningNumbers, bonusNumber);
    }

}
