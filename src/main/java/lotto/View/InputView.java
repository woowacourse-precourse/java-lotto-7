package lotto.View;

import lotto.domain.Lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.validation.validation.*;

public class InputView {
    private static final String ASK_PurchaseAmount="구입금액을 입력해 주세요.";
    private static final String ASK_WinningNumber="당첨 번호를 입력해 주세요.";
    private static final String ASK_BounsNumber="보너스 번호를 입력해 주세요.";
    public static final String ERROR_PurchaseAmount="[ERROR] 구입 금액은 양수인 1000원 단위로 입력해주세요.";
    public static final String ERROR_RangeValidWinningNumber="[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_CommaValidWinningNumber="[ERROR] 당첨 번호는 쉼표로 구분되어야 합니다.";
    public static final String ERROR_OverlapValidWinningNumber="[ERROR] 당첨 번호는 중복된 숫자일 수 없습니다.";
    public static final String ERROR_RangeValidBounsNumber="[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";


    public static int input_purchaseAmount() {
        while (true) {
            System.out.println(ASK_PurchaseAmount);
            String input_purchase_amount = readLine();
            try {
                return validatePurchaseAmount(input_purchase_amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static Lotto input_winningNumber() {
        while (true) {
            System.out.println(ASK_WinningNumber);
            String input_winning_number = readLine();
            try {
                return validateWinningNumber(input_winning_number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static int input_bounsNumber() {
        while (true) {
            System.out.println(ASK_BounsNumber);
            String input_bouns_number = readLine();
            try {
                return validateBounsNumber(input_bouns_number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
