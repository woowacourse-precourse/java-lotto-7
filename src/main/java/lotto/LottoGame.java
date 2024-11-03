package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final Map<Integer, Integer> PRIZE_MONEY = Map.of(
            6, 2000000000,
            5, 1500000,
            4, 50000,
            3, 5000
    );
    private static final int SECOND_PLACE_PRIZE = 30000000;
    private final List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNumbers;
    private int bonusNumber;



    // 1. 구입 금액 입력 및 검증
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        if (!isNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        int amount = Integer.parseInt(input);
        validateAmount(amount);
        return amount / LOTTO_PRICE;
    }

    private boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void validateAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 2. 로또 발행 및 출력
    public void purchaseLottos(int quantity) {
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6); // 로또 번호 생성
            lottos.add(new Lotto(numbers)); // 생성된 번호 리스트로 Lotto 객체 생성
        }
        System.out.printf("%d개를 구매했습니다.%n", quantity);
        printLottoNumbers();
        System.out.println();
    }

    private void printLottoNumbers() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    // 3. 당첨 번호 및 보너스 번호 입력 및 검증
    public void inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbers = parseAndValidate(Console.readLine());
        System.out.println();
    }

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
        validateBonusNumber();
        System.out.println();
    }

    private List<Integer> parseAndValidate(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if (numbers.size() != 6 || new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
            }
        }
        return numbers;
    }

    private void validateBonusNumber() {
        if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 하며, 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    // 4. 당첨 결과 계산
    private int calculateMatchCount(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public int getRank(List<Integer> lottoNumbers) {
        int matchCount = calculateMatchCount(lottoNumbers);
        if (matchCount == 6) return 1;
        if (matchCount == 5 && lottoNumbers.contains(bonusNumber)) return 2;
        if (matchCount == 5) return 3;
        if (matchCount == 4) return 4;
        if (matchCount == 3) return 5;
        return 0; // 미당첨
    }

    // 5. 결과 출력
    public void calculateAndPrintResults() {
        Map<String, Integer> rankCount = new HashMap<>();
        rankCount.put("1st", 0);
        rankCount.put("2nd", 0);
        rankCount.put("3rd", 0);
        rankCount.put("4th", 0);
        rankCount.put("5th", 0);

        int totalPrize = 0;

        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto.getNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 6) {
                rankCount.put("1st", rankCount.get("1st") + 1);
                totalPrize += PRIZE_MONEY.get(6);
            } else if (matchCount == 5 && bonusMatch) {
                rankCount.put("2nd", rankCount.get("2nd") + 1);
                totalPrize += SECOND_PLACE_PRIZE;
            } else if (matchCount == 5) {
                rankCount.put("3rd", rankCount.get("3rd") + 1);
                totalPrize += PRIZE_MONEY.get(5);
            } else if (matchCount == 4) {
                rankCount.put("4th", rankCount.get("4th") + 1);
                totalPrize += PRIZE_MONEY.get(4);
            } else if (matchCount == 3) {
                rankCount.put("5th", rankCount.get("5th") + 1);
                totalPrize += PRIZE_MONEY.get(3);
            }
        }

        printResults(rankCount);
        printProfitRate(totalPrize);
    }

    private int getMatchCount(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }

    private void printResults(Map<String, Integer> rankCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", rankCount.get("5th"));
        System.out.printf("4개 일치 (50,000원) - %d개%n", rankCount.get("4th"));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", rankCount.get("3rd"));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", rankCount.get("2nd"));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", rankCount.get("1st"));
    }

    private void printProfitRate(int totalPrize) {
        int totalCost = lottos.size() * 1000;
        double profitRate = (double) totalPrize / totalCost * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
