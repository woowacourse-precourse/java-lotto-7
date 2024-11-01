package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.BonusBall;
import lotto.domain.Lotto;
import lotto.util.PrizeType;

public class Application {
    public static void main(String[] args) {
        playLotto();
    }

    private static void playLotto() {
        int money = inputMoney();
        List<List<Integer>> lottoNumbers = generateLottoNumbers(money);
        printLotto(lottoNumbers);

        Lotto lotto = new Lotto(splitWinningNumbers(inputWinningNumbers()));
        BonusBall bonusNumber = new BonusBall(parseToInt(inputBonusNumber()), lotto.getNumbers());
    }

    private static String readLine() {
        return Console.readLine();
    }

    public static int inputMoney() {
        printMoneyInputMessage();
        String input = readLine();
        return parseToInt(input) / 1000;
    }

    private static int parseToInt(String input) {
        int intValue;
        try {
            intValue = Integer.parseInt(input);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
        return intValue;
    }

    private static void printMoneyInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private static List<List<Integer>> generateLottoNumbers(int money) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        printPurchaseCountInputMessage(money);
        for (int i = 0; i < money; i++) {
            List<Integer> singleLotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            Collections.sort(singleLotto);
            lottoNumbers.add(singleLotto);
        }
        return lottoNumbers;
    }

    private static void printPurchaseCountInputMessage(int money) {
        System.out.printf("\n%d개를 구매했습니다.\n", money);
    }

    public static void printLotto(List<List<Integer>> lottoNumbers) {
        lottoNumbers.stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

    private static String inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해주세요.");
        return Console.readLine();
    }

    private static List<Integer> splitWinningNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");
        return Arrays.stream(numbers)
                .filter(num -> !num.trim().isEmpty())
                .map(num -> parseToInt(num.trim()))
                .collect(Collectors.toList());
    }

    private static String inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해주세요.");
        return Console.readLine();
    }

    private static int[] calculateStatistics(List<Integer> winningNumbers, int bonusNumber, List<List<Integer>> lottoNumbers) {
        int[] results = new int[PrizeType.values().length];

        for (List<Integer> singleLotto : lottoNumbers) {
            int matchCount = countMatchingNumbers(singleLotto, winningNumbers);
            boolean hasBonus = singleLotto.contains(bonusNumber);

            if (matchCount == 6) {
                results[PrizeType.MATCHING_6.ordinal()]++;
            } else if (matchCount == 5 && hasBonus) {
                results[PrizeType.HAS_BONUS_WIN_MATCHING_5.ordinal()]++;
            } else if (matchCount == 5) {
                results[PrizeType.MATCHING_5.ordinal()]++;
            } else if (matchCount == 4) {
                results[PrizeType.MATCHING_4.ordinal()]++;
            } else if (matchCount == 3) {
                results[PrizeType.MATCHING_3.ordinal()]++;
            }
        }
        return results;
    }

    private static int countMatchingNumbers(List<Integer> singleLotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : singleLotto) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

}
