package domain;

import camp.nextstep.edu.missionutils.Randoms;
import message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class ManageNumbers {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMS = 6;

    public Lotto generateLotto() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMS);

        return new Lotto(numbers);
    }

    public WinningNumbers generateWinningNumbers(String numbers) {

        Validate validate = new Validate();
        List<Integer> winningNumbers = new ArrayList<>();

        String[] temps = numbers.split(",");

        for(String number : temps) {
            number = number.trim();
            if (number.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.IS_EMPTY.getErrorMessage());
            }
            validate.validateContainsLetters(number);
            winningNumbers.add(Integer.parseInt(number));
        }

        return new WinningNumbers(winningNumbers);
    }


}
