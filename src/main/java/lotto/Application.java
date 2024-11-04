package lotto;

import java.util.*;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MAX_NUMBER = 45;

    private static final Map<Integer, Integer> preizeMoney = Map.of(
            6, 2_000_000_000, // 1등
            5, 1_500_000, // 2등
            4, 50_000, // 3등
            3, 5_000 // 4등
    );

    public static void main(String[] args) {
        try {
            int purchaseAmount = getPurchaseAmount();
            int numberOfTickets = purchaseAmount / LOTTO_PRICE;
            System.out.println(numberOfTickets + "개를 구매했습니다.");

            List<Set<Integer>> lottoTickets = generateLottoTickets(numberOfTickets);
            printLottoTickets(lottoTickets);

            Set<Integer> winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber(winningNumbers);

            System.out.println("당첨 번호: " + winningNumbers);
            System.out.println("보너스 번호: " + bonusNumber);

            Map<String, Integer> results = calculateResults(lottoTickets, winningNumbers, bonusNumber);
            printResults(results);

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

    // 당첨 번호 입력 및 검증
    private static Set<Integer> getWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("당첨 번호를 입력해 주세요. (예: 1,2,3,4,5,6)");
        String input = scanner.nextLine();
        String[] numbers = input.split(",");

        if (numbers.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자여야 합니다.");
        }

        Set<Integer> winningNumbers = new HashSet<>();
        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number.trim());
            validateLottoNumber(parsedNumber);
            if (!winningNumbers.add(parsedNumber)) {
                throw new IllegalArgumentException("당첨 번호에는 중복된 숫자가 없어야 합니다.");
            }
        }
        return winningNumbers;
    }

    // 보너스 번호 입력 및 검증
    private static int getBonusNumber(Set<Integer> winningNumbers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = scanner.nextInt();

        validateLottoNumber(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return bonusNumber;
    }

    // 번호 범위 검증
    private static void validateLottoNumber(int number) {
        if (number < 1 || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // 당첨 결과 계산
    private static Map<String, Integer> calculateResults(List<Set<Integer>> tickets, Set<Integer> winningNumbers, int bonusNumber) {
        Map<String, Integer> results = new LinkedHashMap<>();
        results.put("3개 일치 (5,000원)", 0);
        results.put("4개 일치 (50,000원)", 0);
        results.put("5개 일치 (1,500,000원)", 0);
        results.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        results.put("6개 일치 (2,000,000,000원)", 0);

        for (Set<Integer> ticket : tickets) {
            int matchCount = (int) ticket.stream().filter(winningNumbers::contains).count();
            boolean bonusMatch = ticket.contains(bonusNumber);

            if (matchCount == 6) {
                results.put("6개 일치 (2,000,000,000원)", results.get("6개 일치 (2,000,000,000원)") + 1);
            } else if (matchCount == 5 && bonusMatch) {
                results.put("5개 일치, 보너스 볼 일치 (30,000,000원)", results.get("5개 일치, 보너스 볼 일치 (30,000,000원)") + 1);
            } else if (matchCount == 5) {
                results.put("5개 일치 (1,500,000원)", results.get("5개 일치 (1,500,000원)") + 1);
            } else if (matchCount == 4) {
                results.put("4개 일치 (50,000원)", results.get("4개 일치 (50,000원)") + 1);
            } else if (matchCount == 3) {
                results.put("3개 일치 (5,000원)", results.get("3개 일치 (5,000원)") + 1);
            }
        }
        return results;
    }

    // 당첨 결과 출력
    private static void printResults(Map<String, Integer> results) {
        System.out.println("당첨 통계\n---");
        results.forEach((key, value) -> System.out.println(key + " - " + value + "개"));
    }
}
