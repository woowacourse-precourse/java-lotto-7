package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        int numberOfLottos = purchaseAmount / LOTTO_PRICE;
        System.out.println("\n" + numberOfLottos + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }

        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);
        printWinningStatistics(lottos, winningNumbers, bonusNumber, purchaseAmount);
    }

    private static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                int amount = Integer.parseInt(input);

                if (amount % LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException();
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
            }
        }
    }

    private static List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        while (winningNumbers.size() < 6) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String winningInput = Console.readLine();
                winningNumbers = parseNumbers(winningInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }

    private static int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());
                validateBonusNumber(winningNumbers, bonusNumber);
                return bonusNumber; // 유효한 보너스 번호가 입력된 경우 반환
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
            }
        }
    }

    private static List<Integer> parseNumbers(String input) {
        String[] numbers = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            validateLottoNumber(num); // 각 번호에 대해 유효성 검사
            winningNumbers.add(num);
        }
        return winningNumbers;
    }

    private static void validateLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static void printWinningStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        int[] counts = new int[5]; // [3개, 4개, 5개, 5개+보너스, 6개]
        int totalPrize = 0;

        for (Lotto lotto : lottos) {
            int matchCount = countMatches(lotto.getNumbers(), winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            totalPrize += calculatePrize(counts, matchCount, bonusMatch);
        }

        // 출력
        System.out.println("\n당첨 통계");
        System.out.println("---");
        printPrizeCounts(counts);

        double profitRate = (double) totalPrize / purchaseAmount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private static int calculatePrize(int[] counts, int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            counts[4]++;
            return 2000000000;
        }
        if (matchCount == 5 && bonusMatch) {
            counts[3]++;
            return 30000000;
        }
        if (matchCount == 5) {
            counts[2]++;
            return 1500000;
        }
        if (matchCount == 4) {
            counts[1]++;
            return 50000;
        }
        if (matchCount == 3) {
            counts[0]++;
            return 5000;
        }
        return 0; // 당첨되지 않은 경우
    }

    private static void printPrizeCounts(int[] counts) {
        System.out.printf("3개 일치 (5,000원) - %d개\n", counts[0]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", counts[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", counts[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", counts[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", counts[4]);
    }

    private static int countMatches(List<Integer> userNumbers, List<Integer> winningNumbers) {
        return (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
