package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

// Input에 필요한 메서드 모음
public class InputModel {

    // 구입금액 입력 받은 후 반환
    public int getPrice() {
        int price;

        try {
            price = validatePrice(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("구입금액을 다시 입력해 주세요.");
            price = getPrice();
        }
        return price;
    }

    // 당첨번호 입력 받은 후 Lotto 객체로 반환
    public Lotto getWinningNumbers() {
        List<Integer> numbers;
        Lotto winningNumbers;

        try {
            numbers = validateNumbers(Console.readLine());
            winningNumbers = new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("당첨 번호를 다시 입력해 주세요.");
            winningNumbers = getWinningNumbers();
        }
        return winningNumbers;
    }

    // 보너스 번호 입력 받은 후 반환
    public int getBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;

        try {
            bonusNumber = validateBonusNumber(Console.readLine(), winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("보너스 번호를 다시 입력해 주세요.");
            bonusNumber = getBonusNumber(winningNumbers);
        }
        return bonusNumber;
    }

    // 보너스 번호의 유효성 체크
    static int validateBonusNumber(String inputNumberText, List<Integer> winningNumbers) {
        int bonusNumber;

        isEmptyOrNull(inputNumberText);
        bonusNumber = isNumber(inputNumberText);
        isInRange(bonusNumber);
        isDuplicate(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    static void isInRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    static void isDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            checkNumbers(bonusNumber, number);
        }
    }

    static void checkNumbers(int bonusNumber, int number) {
        if (number == bonusNumber) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    // 당첨번호 문자열을 체크하고 List<Integer>로 반환
    static List<Integer> validateNumbers(String inputNumbersText) {
        List<Integer> inputNumbers;

        isEmptyOrNull(inputNumbersText);
        inputNumbersText = inputNumbersText.replaceAll(" ", "");
        try {
            inputNumbers = addInputNumbers(inputNumbersText.split(","));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 각 로또 번호는 쉼표(,)로 구분된 숫자여야 합니다.");
        }
        return inputNumbers;
    }

    private static List<Integer> addInputNumbers(String[] numbers) {
        List<Integer> inputNumbers = new ArrayList<>();

        for (String number : numbers) {
            inputNumbers.add(Integer.parseInt(number));
        }
        return inputNumbers;
    }

    // 구입금액 입력 유효성 검사
    static int validatePrice(String inputPriceText) {
        int price;

        isEmptyOrNull(inputPriceText);
        price = isNumber(inputPriceText);
        isOverThousand(price);
        isDivisibleThousand(price);
        return price;
    }

    private static void isEmptyOrNull(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 입력입니다.");
        }
    }

    private static int isNumber(String priceText) {
        int price;

        try {
            price = Integer.parseInt(priceText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        return price;
    }

    private static void isOverThousand(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 이상이어야 합니다.");
        }
    }

    private static void isDivisibleThousand(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 합니다.");
        }
    }
}
