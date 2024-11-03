package global.io.console;

import global.io.InputHandler;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleInputHandler implements InputHandler {
    @Override
    public Integer getIntegerInput(int limit) {
        while (true) {
            try {
                String input = Console.readLine();
                int number = Integer.parseInt(input);
                if (number <= limit) {
                    System.out.printf("[ERROR] %d보다 큰 숫자를 입력하세요.%n", limit);
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력하세요.");
            }
        }
    }

    @Override
    public List<Integer> getIntegerListInput(int size) {
        while (true) {
            String input = Console.readLine();
            try {
                List<Integer> numbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                if (numbers.size() != size) {
                    System.out.printf("[ERROR] %d개의 숫자를 입력하세요.%n", size);
                    continue;
                }

                return numbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자 리스트를 입력하세요.");
            }
        }
    }
}
