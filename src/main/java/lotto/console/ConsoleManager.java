package lotto.console;

import lotto.validate.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.validate.Validator.*;

public class ConsoleManager {
    public static void printf(String input, Object... args){
        System.out.printf(input, args);
    }
    public static void println(String input){
        System.out.println(input);
    }
    public static void println(){
        System.out.println();
    }
    public static List<Integer> toNumberList(String input){
        return Arrays.stream(input.split(","))
                .map(ConsoleManager::toNumeric)
                .collect(Collectors.toList());
    }

    public static Integer toNumeric(String input) {
        isNumeric(input);
        isBlank(input);
        return Integer.parseInt(input);
    }
}
