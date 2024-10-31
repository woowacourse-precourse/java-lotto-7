package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputManager {
    public String validateEmptyAndReturnInput(){
        String input = Console.readLine();
            if (input.isEmpty()) {
                System.out.println("[ERROR] 빈 입력은 허용되지 않습니다.");
                throw new IllegalArgumentException();
            }

        return input;
    }

    public String validateAndReturnInt(String input){
            for (char c : input.toCharArray()) {
                if ((int) c < 48 || (int) c > 57) {
                    System.out.println("[ERROR] 숫자가 아닌 입력은 허용되지 않습니다");
                    throw new IllegalArgumentException();
                }
            }
        return input;
    }

    public void notContainComma(String input) {
            if (!input.contains(",")) {
                System.out.println("[ERROR] 쉼표로 구분된 6개의 숫자를 넣어주세요");
                throw new IllegalArgumentException();
            }
    }

    public void notSixNumbers(String input) {
            String[] parts = input.split(",");
            if (parts.length != 6) {
                System.out.println("[ERROR] 쉼표로 구분된 6개의 숫자를 넣어주세요");
                throw new IllegalArgumentException();
            }
    }

    public void isAllNumber(String[] parts,List<Integer> numbers) {
            for (String part : parts) {
                part = part.trim();
                if (!part.matches("\\d+")) {
                    System.out.println("[ERROR] 쉼표로 구분된 6개의 숫자를 넣어주세요");
                    throw new IllegalArgumentException();
                }
                numbers.add(Integer.parseInt(part));
            }
    }

    public List<Integer> validateAndReturnNumbersInput(String input) {
        notContainComma(input);
        notSixNumbers(input);
        String[] parts = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        isAllNumber(parts, numbers);
        return numbers;
    }
}
