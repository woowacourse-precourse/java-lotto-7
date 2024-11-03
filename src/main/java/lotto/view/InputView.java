package lotto.view;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoException;


public class InputView {
    public static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String COMMA_DELIMITER = ",";

    public int RequestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT);
        return TryGetPurchaseAmount();
    }

    public List<Integer> RequestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS);
        String input = Console.readLine();
        return Arrays.stream(input.split(COMMA_DELIMITER))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList()); // TODO: 검증 로직 추가
    }

    public int RequestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String input = Console.readLine();
        return parseInt(input); // TODO: 검증 로직 추가
    }

    private int TryGetPurchaseAmount() {
        try{
            String input = Console.readLine();
            return parseInt(input);
        }catch(NumberFormatException e){
            System.out.println(LottoException.INVALID_NUMBER_FORMAT);
            return TryGetPurchaseAmount();
        }
    }


}
