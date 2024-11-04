package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static Lotto winningNumbers;
    private static int bonusNumber;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = inputPurchaseAmount();
        int lottoCount = getLottoCount(purchaseAmount);

        Lotto[] lottos = Lotto.generateLottos(lottoCount);
        Lotto.printLottos(lottos);
        System.out.println();

        winningNumbers = inputWinningNumbers();
        bonusNumber = inputBonusNumber();

        compareLottos(lottos);
        printResults(purchaseAmount);
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
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (winningNumbers.getNumbers().contains(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }


    private static void compareLottos(Lotto[] lottos){
        for(Lotto lotto : lottos){
            countMatches(lotto.getNumbers());
        }
    }

    private static void countMatches(List<Integer> lotto) {
        int matchCount = 0;

        for (int number : lotto) {
            if (winningNumbers.getNumbers().contains(number)) {
                matchCount++;
            }
        }

        increaseMatchTypeCount(lotto, matchCount);
    }

    private static int increaseMatchTypeCount(List<Integer> lotto, int matchCount) {

        if (matchCount == 6) {
            Lotto.MatchType.SIX.increaseCount();
            return 0;
        }
        if (matchCount == 5) {
            if (lotto.contains(bonusNumber)) {
                Lotto.MatchType.FIVE_WITH_BONUS.increaseCount();
                return 0;
            }
            Lotto.MatchType.FIVE.increaseCount();
            return 0;
        }
        if (matchCount == 4) {
            Lotto.MatchType.FOUR.increaseCount();
            return 0;
        }
        if (matchCount == 3) {
            Lotto.MatchType.THREE.increaseCount();
            return 0;
        }
        return 0;
    }


    private static void printResults(int purchaseAmount){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + Lotto.MatchType.THREE.getCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + Lotto.MatchType.FOUR.getCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Lotto.MatchType.FIVE.getCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Lotto.MatchType.FIVE_WITH_BONUS.getCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Lotto.MatchType.SIX.getCount() + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.\n", calculateReturnRate(purchaseAmount));
    }

    private static float calculateReturnRate(int purchaseAmount) {
        return (float) Lotto.MatchType.calculateTotalPrize() / purchaseAmount * 100;
    }
}
