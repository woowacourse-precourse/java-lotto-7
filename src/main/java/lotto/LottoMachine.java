package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    private final LottoTicketGenerator ticketGenerator = new LottoTicketGenerator();

    public void start() {
        int purchaseAmount = getPurchaseAmount();
        validatePurchaseAmount(purchaseAmount);

        List<Lotto> purchasedTickets = purchaseTickets(purchaseAmount);
        printPurchasedTickets(purchasedTickets);

        Set<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        WinningChecker winningChecker = new WinningChecker(winningNumbers, bonusNumber);
        WinStatistics statistics = new WinStatistics();

        // 당첨 결과 확인 및 기록
        purchasedTickets.forEach(ticket -> {
            int winCategory = winningChecker.checkWinning(ticket);
            statistics.recordResult(winCategory);

        });

        printStatistics(statistics, purchaseAmount);
    }

    private int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return readIntegerInput();
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private List<Lotto> purchaseTickets(int purchaseAmount) {
        int ticketCount = purchaseAmount / 1000;
        return ticketGenerator.generateTickets(ticketCount);
    }

    private void printPurchasedTickets(List<Lotto> tickets) {
        System.out.printf("%d개를 구매했습니다.\n", tickets.size());
        tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
    }

    private Set<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요 (예: 1,2,3,4,5,6):");
        Set<Integer> numbers = readUniqueNumbers(6);

        if (!isValidLottoNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return numbers;
    }

    private int getBonusNumber(Set<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요:");
        int bonusNumber = readIntegerInput();

        if (!isValidLottoNumber(bonusNumber) || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자이며, 당첨 번호와 중복되지 않아야 합니다.");
        }
        return bonusNumber;
    }

    private void printStatistics(WinStatistics statistics, int purchaseAmount) {
        statistics.printStatistics();
        System.out.printf("총 수익률은 %.1f%%입니다.\n", statistics.calculateProfitRate(purchaseAmount));
    }

    private int readIntegerInput() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            return readIntegerInput();
        }
    }

    private Set<Integer> readUniqueNumbers(int count) {
        try {
            return Stream.of(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자 형식이 잘못되었습니다. 다시 입력해 주세요.");
            return readUniqueNumbers(count);
        }
    }

    private boolean isValidLottoNumbers(Set<Integer> numbers) {
        return numbers.size() == 6 && numbers.stream().allMatch(this::isValidLottoNumber);
    }

    private boolean isValidLottoNumber(int number) {
        return number >= 1 && number <= 45;
    }
}
