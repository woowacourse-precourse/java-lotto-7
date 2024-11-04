package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 로또 생성
        int money = inputMoney();
        List<Lotto> tickets = generateLottoTickets(money);
        printTickets(tickets);

        // 당첨 번호 보너스 번호
        List<Integer> winNumbers = inputWinNum();
        int bonusNum = inputBonusNum();

        // 로또 당첨 여부
        for (Lotto ticket : tickets) {
            int grade = compareGrade(ticket, winNumbers, bonusNum);
            System.out.println("등수: " + grade); // 각 티켓의 등수 출력
        }
    }

    private static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        errorMoney(amount);
        return amount;
    }

    private static void errorMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("ERROR 구입 금액은 1,000원 단위로 입력해야 합니다.");
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
    private static List<Integer> inputWinNum() {
        System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분된 6개의 숫자)");
        String[] input = Console.readLine().split(",");
        List<Integer> winNum = new ArrayList<>();

        for (String number : input) {
            winNum.add(Integer.parseInt(number.trim()));
        }

        if (winNum.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        return winNum;
    }

    // 보너스 번호 입력 기능
    private static int inputBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine().trim());
    }

    // 당첨 번호와 티켓을 비교하여 일치하는 번호 개수 반환
    private static int checkMatchingNumbers(Lotto ticket, List<Integer> winNumbers) {
        int count = 0;
        for (int number : ticket.getSortNumbers()) {
            if (winNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    // 로또의 일치 개수와 보너스 번호 여부로 grade 판별
    private static int compareGrade(Lotto ticket, List<Integer> winNumbers, int bonusNum) {
        int count = checkMatchingNumbers(ticket, winNumbers);
        boolean bonusMatch = ticket.getSortNumbers().contains(bonusNum);

        if (count == 6) return 1;
        if (count == 5 && bonusMatch) return 2;
        if (count == 5) return 3;
        if (count == 4) return 4;
        if (count == 3) return 5;
        return 0;
    }
}
//inputWinningNum 당첨번호 입력
//inputBonusNum 보너스번호 입력
//inputMoney 금액을 입력받고 유효성을 검사하는 로직을 추가
//generateLottoTickets(int purchaseAmount) 구입 금액에 따라 로또 티켓 수를 계산, 각 티켓을 생성
//printTickets(List<Lotto> tickets): 생성된 티켓의 개수와 티켓의 번호를 오름차순으로 출력