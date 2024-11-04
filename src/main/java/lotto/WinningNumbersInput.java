package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbersInput{
    public Lotto inputNumbers() {
        List<Integer> numbers;
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String numberSet = Console.readLine();
                numbers = splitNumbers(numberSet);
                return new Lotto(numbers);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> splitNumbers(String numberSet) {
        List<Integer> tempNumbers = new ArrayList<>();
        String[] numbersArray = numberSet.split(",");
        for (String number : numbersArray) {
            tempNumbers.add(Integer.parseInt(number.trim()));
        }
        return tempNumbers;
    }
}
