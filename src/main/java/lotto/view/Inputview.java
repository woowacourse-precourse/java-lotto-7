package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.Validator;

public class Inputview {

    // 구입 금액 입력
    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                int money = Validator.validateAndParseNumber(Console.readLine()); // 숫자 형식 검사
                Validator.validatePurchaseAmount(money); // 1,000원 단위 검사
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 당첨 번호 입력
    public static String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    // 보너스 번호 입력
    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                int bonusNumber = Validator.validateAndParseNumber(Console.readLine()); // 숫자 형식 검사 및 파싱
                Validator.validateLottoNumberRange(List.of(bonusNumber)); // 보너스 번호 범위 검사
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
