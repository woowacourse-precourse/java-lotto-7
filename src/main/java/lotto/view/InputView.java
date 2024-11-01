package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class InputView {
    private static final String LOTTO_NUMBER_INPUT_QUESTION = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_QUESTION = "보너스 번호를 입력해 주세요.";

    public static List<Integer> getLottoNumber() {
        String input = askInput(LOTTO_NUMBER_INPUT_QUESTION);
        try {
            return InputParser.parseLottoNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoNumber();
        }
    }

    public static int getBonusNumber() {
        String input = askInput(BONUS_NUMBER_INPUT_QUESTION);
        try {
            return InputParser.parseBonusNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }

    private static String askInput(String question) {
        System.out.println(question);
        return readLine();
    }
}
