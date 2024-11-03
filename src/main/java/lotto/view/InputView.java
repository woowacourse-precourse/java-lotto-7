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
        int purchaseAmount = Integer.parseInt(input);
        // 양수인지 or 0보다 큰지 검증
        PositiveNumberValidator.validate(purchaseAmount);
        // 1000원 단위로 입력 받았는지 검증
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    // 당첨 번호 입력
    public static Set<Integer> getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        //빈값인지 검증
        EmptyInputValidator.validate(input);

        Set<Integer> inputWinningNumber = Stream.of(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableSet());

        // 6개만 입력 받았는지 검증, 로또 숫자들이 중복되지 않는지 검증
        validate6Numbers(inputWinningNumber);
        // 로또 숫자들이 1~45 사이의 숫자인지 검증
        for (int number : inputWinningNumber) {
            LottoNumberRangeValidator.validate(number);
        }

        return inputWinningNumber;
    }

    // 보너스 번호 입력
    public static int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = Console.readLine();

        // 빈 값인지 검증
        EmptyInputValidator.validate(input);
        // 숫자 형식인지 검증
        NumberFormatValidator.validate(input);
        // 1개만 입력 받았는지
        validate1Numbers(input);
        // 양수로 입력 받았는지
        int bonusBall = Integer.parseInt(input);
        // 로또 숫자가 1~45 사이의 숫자인지 검증
        LottoNumberRangeValidator.validate(bonusBall);

        return bonusBall;
    }

    public static void validatePurchaseAmount(int input) {
        if ((input % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public static void validate6Numbers(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void validate1Numbers(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}
