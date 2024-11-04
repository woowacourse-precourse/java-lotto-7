package lotto;

import camp.nextstep.edu.missionutils.*;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {

        System.out.println("구입 금액을 입력해주세요.");
        String input = Console.readLine();
        validateInput(input);
    }

    public static void validateInput(String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력값이 비어 있습니다. 다시 입력해 주세요.");
        }

        if (input.contains(" ")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력에 공백이 포함되어 있습니다. 다시 입력해 주세요.");
        }
    }
}
