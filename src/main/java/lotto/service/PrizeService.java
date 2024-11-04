package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrizeService {

    public List<Integer> inputNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        try {
            List<String> numbers = Arrays.asList(Console.readLine().split(","));
            return numbers.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS.toString());
        }
    }

    public int inputNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS.toString());
        }
    }
}
