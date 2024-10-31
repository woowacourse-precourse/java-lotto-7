package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.util.Validator;

public class InputHandler {
    private static final String DELIMITER = ",";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private final Validator validator;

    // TODO: InputHandler가 OutputHandler에 의존하여 Sysout 하는 것 고민하기
    public InputHandler(Validator validator) {
        this.validator = validator;
    }

    public int getInputForPurchaseMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                validator.checkPurchaseMoney(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                print(ERROR_PREFIX + e.getMessage());
            }
        }
    }

    public List<Integer> getInputForWinningNumber() {
        while (true) {
            try {
                print("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                validator.checkLottoNumbers(input);
                return Stream.of(input.split(DELIMITER))
                        .map(number -> Integer.parseInt(number.trim()))
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                print(ERROR_PREFIX + e.getMessage());
            }
        }
    }

    public Integer getInputForBonusNumber() {
        while (true) {
            try {
                print("\n보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                validator.checkBonusNumber(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }

    public void print(String message) {
        System.out.println(message);
        System.out.flush();
    }
}
