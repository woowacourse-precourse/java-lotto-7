package lotto.service;

import static lotto.utils.ErrorMessages.*;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.ErrorMessages;

public class LottoService {






    private List<Integer> parseInputToList(String inputLottoNumbers) {
        String[] splitLottoNumbers = inputLottoNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String number : splitLottoNumbers) {
            numbers.add(parseToInteger(number));
        }

        return numbers;
    }

    private Integer parseToInteger(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_MUST_INTEGER);
        }
    }



}
