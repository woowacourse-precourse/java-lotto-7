package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class InputView {
    private static final String LOTTO_NUMBER_INPUT_QUESTION = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_QUESTION = "보너스 번호를 입력해 주세요.";

    public static List<Integer> getLottoNumber() {
        List<Integer> lottoNumber = null;
        while (lottoNumber == null) {
            try {
                String input = askInput(LOTTO_NUMBER_INPUT_QUESTION);
                lottoNumber = InputParser.parseLottoNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoNumber;
    }

    public static int getBonusNumber() {
        int bonusNumber = 0;
        while (bonusNumber == 0) {
            try {
                String input = askInput(BONUS_NUMBER_INPUT_QUESTION);
                bonusNumber = InputParser.parseBonusNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return getBonusNumber();
            }
        }
        return bonusNumber;
    }

    private static String askInput(String question) {
        System.out.println(question);
        return readLine();
    }
}
