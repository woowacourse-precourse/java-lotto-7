package lotto.view;

import camp.nextstep.edu.missionutils.*;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.view.validate.EmptyInputValidator;
import lotto.view.validate.LottoNumberRangeValidator;
import lotto.view.validate.NumberFormatValidator;
import lotto.view.validate.PositiveNumberValidator;

public class InputView {

    // 로또 구입 금액 입력
    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        // 빈 값인지 검증
        EmptyInputValidator.validate(input);
        // 숫자 형식인지 검증
        NumberFormatValidator.validate(input);
        // 양수인지 검증
        int purchaseAmount = Integer.parseInt(input);
        PositiveNumberValidator.validate(purchaseAmount);
        // 1000원 단위로 입력 받았는지 검증
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public static int validatePurchaseAmount(int input) {
        if ((input % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
        return input;
    }
}
