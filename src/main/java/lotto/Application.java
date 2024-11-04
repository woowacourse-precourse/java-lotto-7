package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final Map<Integer, Integer> LOTTO_MONEY = Map.of(
            1, 2000000000,
            2, 30000000,
            3, 1500000,
            4, 50000,
            5, 5000
    );
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 로또 생성
        int money = inputMoney();
        List<Lotto> tickets = generateLottoTickets(money);
        printTickets(tickets);

        // 당첨 번호 보너스 번호
        List<Integer> winNums = inputWinNums();
        int bonusNum = inputBonusNum();

        // 당첨 통계와 수익률 계산
        Map<Integer, Integer> gradeCounts = calculateGradeCounts(tickets, winNums, bonusNum);
        printResults(gradeCounts);
        calculateProfitRate(gradeCounts, money);
    }

    private static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        errorMoney(amount);
        return amount;
    }

    private static void errorMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private static List<Lotto> generateLottoTickets(int money) {
        int ticketCount = money / 1000; // 로또 개당 1000원
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return tickets;
    }

    // 생성된 티켓 출력
    private static void printTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getSortNumbers());
        }
    }

    // 당첨 번호 입력 기능
    private static List<Integer> inputWinNums() {
        System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분된 6개의 숫자)");
        String[] input = Console.readLine().split(",");
        List<Integer> winNum = new ArrayList<>();

        for (String number : input) {
            winNum.add(Integer.parseInt(number.trim()));
        }

        if (winNum.size() != 6) {
            throw new IllegalArgumentException("[ERROR]당첨 번호는 6개여야 합니다.");
        }
        return winNum;
    }

    // 보너스 번호 입력 기능
    private static int inputBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine().trim());
    }

    // 로또의 일치 개수와 보너스 번호 여부로 grade 판별
    private static int compareGrade(Lotto ticket, List<Integer> winNums, int bonusNum) {
        int count = checkMatchingNumbers(ticket, winNums);
        boolean bonusMatch = ticket.getSortNumbers().contains(bonusNum);

        if (count == 6) return 1;
        if (count == 5 && bonusMatch) return 2;
        if (count == 5) return 3;
        if (count == 4) return 4;
        if (count == 3) return 5;
        return 0;
    }

    // 당첨 번호와 티켓을 비교하여 일치하는 번호 개수 반환
    private static int checkMatchingNumbers(Lotto ticket, List<Integer> winNums) {
        int count = 0;
        for (int number : ticket.getSortNumbers()) {
            if (winNums.contains(number)) {
                count++;
            }
        }
        return count;
    }

    // 각 티켓의 등수를 계산하고 등수별 당첨 횟수를 맵에 저장하여 반환
    private static Map<Integer, Integer> calculateGradeCounts(List<Lotto> tickets, List<Integer> winNums, int bonusNum) {
        Map<Integer, Integer> gradeCounts = new HashMap<>();
        for (Lotto ticket : tickets) {
            int grade = compareGrade(ticket, winNums, bonusNum);
            gradeCounts.put(grade, gradeCounts.getOrDefault(grade, 0) + 1);
        }
        return gradeCounts;
    }

    // 등수별 당첨 통계 출력
    private static void printResults(Map<Integer, Integer> gradeCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", gradeCounts.getOrDefault(5, 0));
        System.out.printf("4개 일치 (50,000원) - %d개%n", gradeCounts.getOrDefault(4, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", gradeCounts.getOrDefault(3, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", gradeCounts.getOrDefault(2, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", gradeCounts.getOrDefault(1, 0));
    }

    // 총 수익률 계산 및 출력
    private static void calculateProfitRate(Map<Integer, Integer> gradeCounts, int money) {
        long totalProfit = 0;
        for (Map.Entry<Integer, Integer> entry : gradeCounts.entrySet()) {
            int grade = entry.getKey();
            int count = entry.getValue();
            totalProfit += (long) LOTTO_MONEY.getOrDefault(grade, 0) * count;
        }
        double profitRate = ((double) totalProfit / money) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
//inputWinningNum 당첨번호 입력
//inputBonusNum 보너스번호 입력
//inputMoney 금액을 입력받고 유효성을 검사하는 로직을 추가
//generateLottoTickets(int purchaseAmount) 구입 금액에 따라 로또 티켓 수를 계산, 각 티켓을 생성
//printTickets(List<Lotto> tickets): 생성된 티켓의 개수와 티켓의 번호를 오름차순으로 출력