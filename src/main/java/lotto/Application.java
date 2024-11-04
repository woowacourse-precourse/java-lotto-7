package lotto;

import static java.util.Arrays.*;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int PURCHASE_UNIT = 1000;

    public static void main(String[] args) {
        int purchaseAmount = getValidPurchaseAmount();

        List<Lotto> lottoTickets = createLottoTickets(purchaseAmount);
        printLottoTickets(lottoTickets);

        List<Integer> winningNumbers = getValidWinningNumbers();
        int bonusNumber = getValidBonusNumber(winningNumbers);

        Map<Rank, Integer> records = getWinningRecords(lottoTickets, winningNumbers, bonusNumber);
        printStatistics(records);

        double profitRate = calculateProfitRate(records, purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    public static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력값이 비어 있습니다. 다시 입력해 주세요.");
        }

        if (input.contains(" ")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력에 공백이 포함되어 있습니다. 다시 입력해 주세요.");
        }
    }

    public static int getValidPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해주세요.");
                String input = Console.readLine();

                validateInput(input);
                int purchaseCost = validatePurchaseCostInput(input);
                validatePurchaseCost(purchaseCost);

                return purchaseCost / PURCHASE_UNIT; // 입력이 유효하면 변환 후 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력 후 루프 반복하여 재입력 요청
            }
        }
    }

    public static int validatePurchaseCostInput(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력값이 숫자가 아닙니다. 다시 입력해 주세요.");
        }

        return Integer.parseInt(input);
    }

    public static void validatePurchaseCost(int purchaseCost) {
        if (purchaseCost < PURCHASE_UNIT) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 구입 금액은 최소 1000원 이상이어야 합니다.");
        }

        if (purchaseCost % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public static List<Lotto> createLottoTickets(int purchaseAmount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoTickets.add(new Lotto(numbers));
        }
        return lottoTickets;
    }

    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();

                validateInput(input);
                return validateWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> validateWinningNumbers(String input) {
        if (!input.matches("^([0-9]{1,2},){5}[0-9]{1,2}$")) { // 1~2자리 숫자로 시작, 쉼표로 구분된 5개의 숫자, 마지막엔 쉼표 없는 숫자
            throw new IllegalArgumentException(ERROR_MESSAGE + " 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
        }

        List<Integer> numbers = stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
        }

        if (numbers.size() != 6 || numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 중복되지 않는 6개의 숫자를 입력해 주세요.");
        }

        return numbers;
    }

    public static int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();

                validateInput(input);
                return validateBonusNumber(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validateBonusNumber(String input, List<Integer> winningNumbers) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력값이 숫자가 아닙니다. 다시 입력해 주세요.");
        }

        int bonusNumber = Integer.parseInt(input);

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }

        return bonusNumber;
    }

    // 당첨 통계 계산
    public static Map<Rank, Integer> getWinningRecords(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class); // 각 로또 티켓 별 결과 저장

        for (Lotto ticket : lottoTickets) {
            int matchCount = (int) ticket.getNumbers().stream().filter(winningNumbers::contains).count();
            boolean matchBonus = ticket.getNumbers().contains(bonusNumber); // 보너스 번호 일치 여부

            Rank rank = Rank.getRank(matchCount, matchBonus);
            results.put(rank, results.getOrDefault(rank, 0) + 1); // 결과 갱신
        }

        return results;
    }

    // 당첨 통계 출력
    public static void printStatistics(Map<Rank, Integer> winningRecords) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningRecords.getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningRecords.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningRecords.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningRecords.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningRecords.getOrDefault(Rank.FIRST, 0) + "개");
    }


    // 수익률 계산
    public static double calculateProfitRate(Map<Rank, Integer> results, int purchaseAmount) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / (purchaseAmount * PURCHASE_UNIT) * 100;
    }
}
