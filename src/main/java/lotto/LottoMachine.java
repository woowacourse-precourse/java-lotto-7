package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {

    private final Set<Integer> winningNumbersSet = new HashSet<>();
    private final List<Lotto> lottoList = new ArrayList<>();
    private final List<Integer> winningNumbers = new ArrayList<>();
    private int totalTickets = 0;

    public LottoMachine() {
        generateLottoNumbers();
        getWinningNumbers();
        printStatistics();
    }

    private int buy() {
        System.out.println("구입 금액을 입력해 주세요.");
        while (true) {
            try {
                int amount = Integer.parseInt(Console.readLine());
                validateAmount(amount);
                return (amount / 1000);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자로만 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
    }

    private void generateLottoNumbers() {
        totalTickets = buy();
        System.out.println(totalTickets + "개를 구매했습니다.");
        for (int i = 0; i < totalTickets; i++) {
            List<Integer> randomNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoList.add(new Lotto(randomNumber));
            System.out.println(randomNumber);
        }
    }

    private String[] inputWinningNumbers() {
        while (true) {
            winningNumbersSet.clear();
            System.out.println("당첨 번호를 입력해주세요.");
            String inputNumbers = Console.readLine();
            try {
                validateInputWinningNumbers(inputNumbers);
                return inputNumbers.split(",");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자와 쉼표(,)로만 입력해주세요");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateInputWinningNumbers(String inputNumbers) {
        String[] numbers = inputNumbers.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개만 입력 가능합니다.");
        }
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다.");
            }
            if (!winningNumbersSet.add(num)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 입력되었습니다: " + num);
            }
        }
    }

    private String inputBonusNumber() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumber = Console.readLine();
            try {
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력하세요");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(String bonusNumber) {
        int num = Integer.parseInt(bonusNumber.trim());
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }
        if (winningNumbersSet.contains(num)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다: " + num);
        }
    }

    private void getWinningNumbers() {
        String[] winningNumbersArray = inputWinningNumbers();
        for (String number : winningNumbersArray) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        winningNumbers.add(Integer.parseInt(inputBonusNumber()));
    }

    private void printStatistics() {
        int[] counts = new int[LottoPrize.values().length];
        for (Lotto lotto : lottoList) {
            int matchCount = countMatches(lotto.getNumbers());
            boolean hasBonus = checkBonusMatch(lotto.getNumbers());
            LottoPrize prize = getPrizeBasedOnMatch(matchCount, hasBonus);
            addPrizeCount(counts, prize);
        }
        printPrizeStatistics(counts);
    }

    private int countMatches(List<Integer> lottoNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkBonusMatch(List<Integer> lottoNumbers) {
        int bonusNumber = winningNumbers.get(winningNumbers.size() - 1); // 마지막 요소가 보너스 번호
        return lottoNumbers.contains(bonusNumber);
    }

    private LottoPrize getPrizeBasedOnMatch(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            return LottoPrize.FIRST_PRIZE;
        }
        if (matchCount == 5) {
            if (hasBonus) {
                return LottoPrize.SECOND_PRIZE;
            }
            return LottoPrize.THIRD_PRIZE;
        }
        if (matchCount == 4) {
            return LottoPrize.FOURTH_PRIZE;
        }
        if (matchCount == 3) {
            return LottoPrize.FIFTH_PRIZE;
        }
        return null; // No prize
    }

    private void addPrizeCount(int[] counts, LottoPrize prize) {
        if (prize != null) {
            counts[Arrays.asList(LottoPrize.values()).indexOf(prize)]++;
        }
    }

    private void printPrizeStatistics(int[] counts) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printPrizeCounts(counts);
        double totalWinnings = calculateTotalWinnings(counts);
        double earningsRate = (totalWinnings / (totalTickets * 1000)) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningsRate);
    }

    private void printPrizeCounts(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            LottoPrize prize = LottoPrize.values()[i];
            boolean hasBonus = prize.hasBonus();
            boolean countExists = counts[i] > 0;
            printPrizeLine(prize, counts[i], hasBonus, countExists);
        }
    }

    private void printPrizeLine(LottoPrize prize, int count, boolean hasBonus, boolean countExists) {
        StringBuilder output = new StringBuilder();
        if (hasBonus && countExists) {
            output.append(String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", prize.getMatchCount(), prize.getAmount(), count));
        }
        if (!hasBonus && countExists) {
            output.append(String.format("%d개 일치 (%,d원) - %d개\n", prize.getMatchCount(), prize.getAmount(), count));
        }
        System.out.print(output.toString());
    }

    private double calculateTotalWinnings(int[] counts) {
        double total = 0;
        for (int i = 0; i < counts.length; i++) {
            total += counts[i] * LottoPrize.values()[i].getAmount();
        }
        return total;
    }
}
