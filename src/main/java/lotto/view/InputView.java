package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다. 숫자를 입력해 주세요.";

    public int purchaseLottoInput() {
        System.out.println(START_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
            return purchaseLottoInput();
        }
    }

    public List<Integer> winningNumInput() {
        System.out.println(LOTTO_MESSAGE);
        try {
            String[] numbers = Console.readLine().split(",");
            List<Integer> lottoNumbers = new ArrayList<>();
            for (String number : numbers) {
                lottoNumbers.add(Integer.parseInt(number.trim()));
            }
            return lottoNumbers;
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
            return winningNumInput();
        }
    }

    public int inputBonus() {
        System.out.println(BONUS_MESSAGE);
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
            return inputBonus();
        }
    }
} 