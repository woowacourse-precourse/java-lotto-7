package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.util.LottoValidator;

public class InputHandler {
    private static final String DELIMITER = ",";
    private static final String ENTER_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String NEW_LINE = "\n";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public long getInputForPurchaseMoney() {
        while (true) {
            try {
                print(ENTER_PURCHASE_MONEY_MESSAGE);
                String input = Console.readLine();
                LottoValidator.checkPurchaseMoney(input);
                return Long.parseLong(input);
            } catch (IllegalArgumentException e) {
                print(e.getMessage());
            }
        }
    }

    public List<Integer> getInputForWinningNumber() {
        while (true) {
            try {
                print(INPUT_WINNING_NUMBER_MESSAGE);
                String input = Console.readLine();
                LottoValidator.checkLottoNumbers(input);
                return Stream.of(input.split(DELIMITER)).map(number -> Integer.parseInt(number.trim()))
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                print(e.getMessage());
            }
        }
    }

    public Integer getInputForBonusNumber() {
        while (true) {
            try {
                print(NEW_LINE + INPUT_BONUS_NUMBER_MESSAGE);
                String input = Console.readLine();
                LottoValidator.checkBonusNumber(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                print(e.getMessage());
            }
        }
    }

    public void print(String message) {
        System.out.println(message);
        System.out.flush();
    }
}
