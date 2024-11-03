package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JackpotNumbers {
    public static List<Integer> jackpotNumbers = new ArrayList<>();

    public JackpotNumbers() {
        pickJackpotNumbers();
    }

    private void pickJackpotNumbers() {
        try {
            printGuideMessage();
            getJackpotNumbers();
            new Lotto(jackpotNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            jackpotNumbers.clear();
            pickJackpotNumbers();
        }
    }

    private void printGuideMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void getJackpotNumbers() {
        String userInput = readLine();
        userInput = removeBlank(userInput);
        checkIsBlank(userInput);
        checkIsOnlyNumber(userInput);
    }

    private String removeBlank(String input) {
        return input.replaceAll(" ", "");
    }

    private void makeJackpotList(String input) {
        List<String> jackpots = Arrays.asList(input.split(","));
        for (String numbers : jackpots) {
            jackpotNumbers.add(Integer.parseInt(numbers));
        }
    }

    private void checkIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력하지 않았습니다.");
        }
    }

    private void checkIsOnlyNumber(String input) {
        try {
            makeJackpotList(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자뿐이어야 합니다.");
        }
    }
}