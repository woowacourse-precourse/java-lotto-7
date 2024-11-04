package lotto;

import java.util.*;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static void main(String[] args) {
        try {
            int purchaseAmount = getPurchaseAmount();
            int numberOfTickets = purchaseAmount / LOTTO_PRICE;
            System.out.println(numberOfTickets + "개를 구매했습니다.");

            List<Set<Integer>> lottoTickets = generateLottoTickets(numberOfTickets);
            printLottoTickets(lottoTickets);
            // 이후 기능으로 넘어가도록 구성할 수 있습니다.
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    // 구입 금액 입력 및 검증
    private static int getPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");

        int amount = scanner.nextInt();

        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }

        return amount;
    }

    // 로또 티켓 발행
    private static List<Set<Integer>> generateLottoTickets(int numberOfTickets) {
        List<Set<Integer>> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            Set<Integer> ticket = generateLottoNumbers();
            tickets.add(ticket);
        }

        return tickets;
    }

    // 중복되지 않는 6개의 숫자를 생성하여 로또 번호로 사용
    private static Set<Integer> generateLottoNumbers() {
        Set<Integer> numbers = new TreeSet<>();
        Random random = new Random();

        while (numbers.size() < LOTTO_NUMBER_COUNT) {
            int number = random.nextInt(LOTTO_MAX_NUMBER) + 1;
            numbers.add(number);
        }

        return numbers;
    }

    // 로또 티켓 출력
    private static void printLottoTickets(List<Set<Integer>> tickets) {
        for (Set<Integer> ticket : tickets) {
            System.out.println(ticket);
        }
    }
}
