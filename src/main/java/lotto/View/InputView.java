package lotto.View;


import static lotto.Model.ErrorCode.PARSING_INTEGER_ERROR;
import static lotto.Model.ErrorCode.RETRY_MESSAGE;
import static lotto.constants.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.Model.Validation;
import lotto.constants.Constants;

public class InputView {

    private final static Validation validation = new Validation();


    //사용자에게 구입금액 입력받는 메소드
    public static int getPurchasePrice() {
        System.out.println(Constants.SET_PURCHASE_PRICE);
        while (true) {
            try {
                int purchasePrice = Integer.parseInt(Console.readLine());
                validation.purchaseValidator(purchasePrice);
                return purchasePrice;
            } catch (NumberFormatException e) {
                System.out.println(PARSING_INTEGER_ERROR.getMessage());
                System.out.println(OUTPUT_RETYPE);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println(RETRY_MESSAGE.getMessage());
            }
        }

    }

    //사용자에게 당첨번호 받는 로직
    public static Lotto getWinningLottoNumber() {
        while (true) {
            try {
                String lotto = Console.readLine();
                List<Integer> lottoNumbers = Arrays.stream(lotto.split(","))
                        .map(Integer::valueOf)
                        .toList();
                return new Lotto(lottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println(RETRY_MESSAGE);
            }
        }
    }


    //사용자에게 보너스 번호 받는 로직
    public static int getBonusNumber() {
        System.out.println(SET_BONUS_NUMBER);
        while (true) {
            try {
                int bonusNumber = Integer.parseInt(Console.readLine());
                validation.bonusNumberValidator(bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println(PARSING_INTEGER_ERROR.getMessage());
                System.out.println(RETRY_MESSAGE.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println(RETRY_MESSAGE.getMessage());
            }
        }

    }
}
