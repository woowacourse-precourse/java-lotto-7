package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = inputAmount();
        int ticketCount = calculateTicketCount(purchaseAmount);
        System.out.println(ticketCount + "개를 구매했습니다.");
        List<Lotto> lottoTickets = generateLottoTickets(ticketCount);
        printLottoTickets(lottoTickets);
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);
        Map<String, Integer> winningStatistics = calculateResults(lottoTickets, winningNumbers, bonusNumber);
        printWinningStatistics(winningStatistics, purchaseAmount);
    }
    private static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        if (!isNum(input)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        int amount = Integer.parseInt(input);

        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }

        return amount;
    }

    private static boolean isNum(String str) {
        return str.matches("\\d+");
    }

    private static int calculateTicketCount(int amount){
        return amount / LOTTO_PRICE;
    }
    private static List<Lotto> generateLottoTickets(int ticketCount) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            Set<Integer> numbers = new TreeSet<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoTickets.add(new Lotto(new ArrayList<>(numbers)));
        }

        return lottoTickets;
    }

    private static void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto ticket : lottoTickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    private static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        List<Integer> winningNumbers = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumbers;
    }
    private static int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자 중 당첨 번호와 중복되지 않는 번호여야 합니다.");
        }

        return bonusNumber;
    }
    private static Map<String, Integer> calculateResults(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<String, Integer> statistics = new LinkedHashMap<>(Map.of(
                "3개 일치 (5,000원)", 0,
                "4개 일치 (50,000원)", 0,
                "5개 일치 (1,500,000원)", 0,
                "5개 일치, 보너스 볼 일치 (30,000,000원)", 0,
                "6개 일치 (2,000,000,000원)", 0
        ));

        for (Lotto ticket : tickets) {
            int matchedCount = countMatchingNumbers(ticket.getNumbers(), winningNumbers);
            if (matchedCount == 6) {
                statistics.put("6개 일치 (2,000,000,000원)", statistics.get("6개 일치 (2,000,000,000원)") + 1);
            } else if (matchedCount == 5 && ticket.getNumbers().contains(bonusNumber)) {
                statistics.put("5개 일치, 보너스 볼 일치 (30,000,000원)", statistics.get("5개 일치, 보너스 볼 일치 (30,000,000원)") + 1);
            } else if (matchedCount == 5) {
                statistics.put("5개 일치 (1,500,000원)", statistics.get("5개 일치 (1,500,000원)") + 1);
            } else if (matchedCount == 4) {
                statistics.put("4개 일치 (50,000원)", statistics.get("4개 일치 (50,000원)") + 1);
            } else if (matchedCount == 3) {
                statistics.put("3개 일치 (5,000원)", statistics.get("3개 일치 (5,000원)") + 1);
            }
        }

        return statistics;
    }
    private static int countMatchingNumbers(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        return (int) ticketNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
    private static void printWinningStatistics(Map<String, Integer> statistics, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + "개");
        }

    }





}
