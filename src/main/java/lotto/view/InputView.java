package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int purchaseLottoInput() {
        System.out.println(Constants.START_MESSAGE);
        while (true) {
            try {
                return Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println(Constants.ERROR_INVALID_INPUT);
            }
        }
    }

    public List<Integer> winningNumInput() {
        System.out.println(Constants.LOTTO_MESSAGE);
        while (true) {
            try {
                String[] numbers = Console.readLine().split(",");
                List<Integer> lottoNumbers = new ArrayList<>();
                for (String number : numbers) {
                    lottoNumbers.add(Integer.parseInt(number.trim()));
                }
                return lottoNumbers;
            } catch (NumberFormatException e) {
                System.out.println(Constants.ERROR_INVALID_INPUT);
            }
        }
    }

    public int inputBonus() {
        System.out.println(Constants.BONUS_MESSAGE);
        while (true) {
            try {
                int bonusNumber = Integer.parseInt(Console.readLine());
                if (bonusNumber < Constants.LOTTO_NUMBER_MIN || bonusNumber > Constants.LOTTO_NUMBER_MAX) {
                    System.out.println(Constants.ERROR_BONUS_NUMBER_RANGE);
                    continue;
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println(Constants.ERROR_INVALID_INPUT);
            }
        }
    }
}
