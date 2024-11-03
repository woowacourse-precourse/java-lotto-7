package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = inputPurchaseAmount();
        int lottoCount = getLottoCount(purchaseAmount);

        Lotto[] lottos = Lotto.generateLottos(lottoCount);
        Lotto.printLottos(lottos);
        System.out.println();

        Lotto winningNumbers = inputWinningNumbers();

        int bonusNumber = inputBonusNumber();
    }


    private static int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();

                int purchaseAmount = parsePurchaseAmount(input);
                validatePurchaseAmount(purchaseAmount);

                System.out.println();
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private static int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입금액은 정수형이어야 합니다.");
        }
    }

    private static void validatePurchaseAmount(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입금액은 양수이어야 합니다.");
        }
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입금액은 1000단위이어야 합니다.");
        }
    }


    private static int getLottoCount(int input) {
        int lottoCount = input / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    private static Lotto inputWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();

                List<Integer> numbers = parseWinningNumbers(input);
                Lotto winningNumbers = new Lotto(numbers);

                System.out.println();
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        String[] splitNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String number : splitNumbers) {
            try {
                numbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_MESSAGE + " 당첨 번호는 정수형이어야 합니다.");
            }
        }
        return numbers;
    }


    private static int inputBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();

                int bonusNumber = parseBonusNumber(input);
                validateBonusNumber(bonusNumber);

                System.out.println();
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private static int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 정수형이어야 합니다.");
        }
    }

    private static void validateBonusNumber(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private int countMatches(List<Integer> lottos, List<Integer> winningNumbers) {
        int count = 0;
        for (int lotto : lottos) {
            if (winningNumbers.contains(lotto)) {
                count++;
            }
        }
        return count;
    }
}
