package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String DELIMITER = ",";

    public int getInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateInput(input);
        return Integer.parseInt(input);
    }

    public static int getLottoNumber() {
        System.out.println("개수를 입력하시오.");
        String input = Console.readLine();
        if (!validLottoNumber(input) || !validateNumber(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "잘못된 입력입니다.");
        }
        return Integer.parseInt(input);
    }

    public static List<Integer> getInputWinLottoNumbers() {
        System.out.println("당첨 번호를 입력해주세요");
        List<Integer> inputLottoNumbers = new ArrayList<>();
        String input = Console.readLine();
        tokenizeInput(input, inputLottoNumbers);
        return inputLottoNumbers;

    }

    private static void tokenizeInput(String input, List<Integer> inputLottoNumbers) {
        validateDelimiter(input);
        StringTokenizer tokenizer = new StringTokenizer(input, DELIMITER);
        while (tokenizer.hasMoreTokens()) {
            inputLottoNumbers.add(Integer.parseInt(tokenizer.nextToken()));
        }
    }

    private static void validateDelimiter(String input) {
        if(!input.contains(DELIMITER)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 잘못된 구분자를 포함하고 있습니다.");
        }
    }


    private static void validateInput(String money) {
        if (!validateNumber(money) || !validateMoney(money)) {
            throw new RuntimeException(ERROR_MESSAGE + " 잘못된 입력 입니다.");
        }
    }

    private static boolean validateNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    private static boolean validateMoney(String money) {
        if (Integer.parseInt(money) < 0 || Integer.parseInt(money) % 1000 != 0) {
            return false;
        }
        return true;
    }

    private static boolean validLottoNumber(String number) {
        int count = Integer.parseInt(number);
        if (count <= 0) {
            return false;
        }
        return true;
    }

}