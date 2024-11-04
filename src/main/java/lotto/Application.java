package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    private static final LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        // 로또 구입 및 검증
        int lottoPurchaseAmount = getValidatedPurchaseAmount();

        // 당첨 번호와 보너스 번호 입력 및 검증
        List<Integer> winningNumbers = getValidatedWinningNumbers();
        int bonusNumber = getValidatedBonusNumber(winningNumbers);

        // 로또 티켓 발행 및 출력
        List<Lotto> tickets = lottoMachine.createTickets(lottoPurchaseAmount);
        lottoMachine.printTickets(tickets);

        // 당첨 내역 계산 및 출력
        Map<PrizeRank, Integer> resultMap = lottoMachine.calculateResults(tickets, winningNumbers, bonusNumber);

        // 당첨 내역 및 수익률 출력
        printResults(resultMap);
        printYield(lottoPurchaseAmount, resultMap);
    }

    private static int getValidatedPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                int lottoPurchaseAmount = Integer.parseInt(Console.readLine());
                validatePurchaseAmount(lottoPurchaseAmount);
                return lottoPurchaseAmount;

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식이 올바르지 않습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 금액 유효성 검증 메서드
    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1보다 커야 합니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 당첨 번호 입력 및 유효성 검증
    private static List<Integer> getValidatedWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> winningNumbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                WinningNumbersValidator.validateWinningNumbers(winningNumbers, -1); // 보너스 번호는 -1로 설정하여 일단 무시
                return winningNumbers;

            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    // 보너스 번호 입력 및 유효성 검증
    private static int getValidatedBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());

                WinningNumbersValidator.validateWinningNumbers(winningNumbers, bonusNumber); // 당첨 번호와 보너스 번호 검증
                return bonusNumber;

            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void printResults(Map<PrizeRank, Integer> resultMap) {
        System.out.println("당첨 통계\n---");
        for (PrizeRank rank : PrizeRank.values()) {
            if (rank != PrizeRank.NONE) {
                System.out.printf("%d개 일치%s (%,d원) - %d개%n",
                        rank.getMatchCount(),
                        rank.hasBonusMatch() ? ", 보너스 볼 일치" : "",
                        rank.getPrizeAmount(),
                        resultMap.getOrDefault(rank, 0));
            }
        }
    }

    // 수익률 출력 메서드
    private static void printYield(int purchaseAmount, Map<PrizeRank, Integer> resultMap) {
        double totalPrize = calculateTotalPrize(resultMap);
        double yield = (totalPrize / purchaseAmount) * 100;

        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield); // 소수점 한 자리 맞추기
    }

    // 총 당첨 금액 계산 메서드
    private static double calculateTotalPrize(Map<PrizeRank, Integer> resultMap) {
        double totalPrize = 0;

        for (Map.Entry<PrizeRank, Integer> entry : resultMap.entrySet()) {
            PrizeRank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrizeAmount() * count;
        }
        return totalPrize;
    }
}
