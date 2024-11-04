package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parse;
import java.util.List;

public class InputView {

    private static final String READ_PURCHASED_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

        public static int readPurchasedPrice() {
            System.out.println(READ_PURCHASED_PRICE_MESSAGE);
            return readNumber();
        }

        public static int readBonusNumber() {
            System.out.println(READ_BONUS_NUMBER_MESSAGE);
            return readNumber();
        }

        private static int readNumber() {
            String buffer = readInput();
            try {
                return Integer.parseInt(buffer);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
            }
        }

        public static List<Integer> readWinningNumbers() {
            System.out.println(READ_WINNING_NUMBERS_MESSAGE);
            String buffer = readInput();
            return Parse.winningNumbers(buffer);
        }

        private static String readInput() {
            String buffer = Console.readLine();
            validateInput(buffer);
            return buffer;
        }

        public static void validateInput(String buffer) {
            if(buffer == null || buffer.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 입력이 비어있습니다.");
            }
        }

}
