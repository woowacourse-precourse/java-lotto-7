package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String DELIMITER = ",";
    private static final int BASIC_MONEY = 1_000;

    public static int getInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateInput(input);
        return Integer.parseInt(input);
    }

    public static int getLottoNumber(int money) {
        int count = money / BASIC_MONEY;
        System.out.println(count +"개를 구매했습니다.");
        return count;
    }

    public static List<Integer> getInputWinLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> inputLottoNumbers = new ArrayList<>();
        String input = Console.readLine();
        tokenizeInput(input, inputLottoNumbers);
        validateSize(inputLottoNumbers);
        return inputLottoNumbers;
    }

    public static int getInputBonusNumber(List<Integer> inputLottoNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateNumber(input);

        int bonusNumber = Integer.parseInt(input);

        return bonusNumber;
    }

    private static void validateSize(List<Integer> inputLottoNumbers) {
        if (inputLottoNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 당첨 번호는 6개여야 합니다.");
        }
    }

    private static void tokenizeInput(String input, List<Integer> inputLottoNumbers) {
        validateDelimiter(input);
        Set<Integer> uniqueNumbers = new HashSet<>();
        StringTokenizer tokenizer = new StringTokenizer(input, DELIMITER);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            validateUnique(uniqueNumbers, token);
            inputLottoNumbers.add(Integer.parseInt(token));
        }
    }

    private static void validateUnique(Set<Integer> uniqueNumbers, String token) {
        int number = Integer.parseInt(token);
        if (!uniqueNumbers.add(number)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 중복된 숫자를 입력했습니다.");
        }
    }

    private static void validateDelimiter(String input) {
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 잘못된 구분자를 포함하고 있습니다.");
        }
    }

    private static void validateInput(String money) {
        validateNumber(money);
        validateMoney(money);
    }

    private static void validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 숫자가 아닙니다.");
        }
    }

    private static void validateMoney(String money) {
        int amount = Integer.parseInt(money);
        if (amount < 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 금액은 0 이상의 1000 단위여야 합니다.");
        }
    }


}
