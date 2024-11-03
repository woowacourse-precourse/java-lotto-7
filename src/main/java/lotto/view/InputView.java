package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class InputView {

    public static int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateAmountInput(input);
        return Integer.parseInt(input);
    }

    public static void validateAmountInput(String money){
        if (isEmptyString(money)){
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해 주세요.");
        }
        if (!isNumeric(money)){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        int inputMoney = Integer.parseInt(money);
        if (!isModZero(inputMoney)){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public static boolean isNumeric(String input){
        return input.matches("\\d+");
    }

    public static boolean isModZero(int money){
        return money % 1000 == 0;
    }

    public static Lotto inputWinningLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return new Lotto(validateWinningLottoInput(input));
    }


    public static List<Integer> validateWinningLottoInput(String input){
        if (isEmptyString(input)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해 주세요.");
        }
        if (!input.matches("^(\\d+,){5}\\d+$")){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
        }

        List<Integer> numbers = Arrays.stream(input.split(","))
                                        .map(String::trim)
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
        for (int number : numbers){
            validateNumberRange(number);
        }
        return numbers;
    }

    public static boolean isEmptyString(String input){
        return input == null || input.isEmpty();
    }

    public static void validateNumberRange(int number){
        if (number < 1 || number > 45) throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
