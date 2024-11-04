package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class InputHandler {
    public InputHandler() {

    }

    public List<Integer> integerInverter(String[] numbers) {
        List<Integer> result = new ArrayList<>();

        for (String s : numbers) {
            try {
                int number = Integer.parseInt(s);
                result.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("입력 값은 숫자가 아닙니다.");
            }
        }
        return result;
    }

    public String getUserInput() {
        String value;
        while (true) {
            try {
                value = Console.readLine();
                int budget = Integer.parseInt(value);
                if (budget % 1000 > 0) {
                    throw new InputMismatchException("1000의 배수로 입력해야 합니다.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + "올바른 수를 입력하세요");
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return value;
    }

}
