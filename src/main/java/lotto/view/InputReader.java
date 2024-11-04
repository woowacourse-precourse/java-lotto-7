package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {
    public int readInteger() {
        while(true){
            String input = Console.readLine();
            try {
                return validateNotNumber(input);
            }catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자만 입력해야 합니다.");
            }
        }
    }

    private int validateNotNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> readIntegerList() {
        String input = Console.readLine();
        return parseDelimiter(input);
    }

    private List<Integer> parseDelimiter(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
