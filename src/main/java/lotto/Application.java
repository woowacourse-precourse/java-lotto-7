package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 프로그램 시작
        int purchaseAmount = getValidPurchaseAmount();
        List<Lotto> purchasedLottos = generateLottos(purchaseAmount);

        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        purchasedLottos.forEach(lotto -> System.out.println(lotto.getNumbers()));

        List<Integer> winningNumbers = getValidWinningNumbers();
        int bonusNumber = getValidBonusNumber();

        Map<LottoInfo, Integer> result = calculateResults(purchasedLottos, winningNumbers, bonusNumber);
        displayResult(result, purchaseAmount);
    }

    // 유효한 구입 금액을 입력받고 반환
    private static int getValidPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int amount = Integer.parseInt(readLine());
                return calculatePurchaseCount(amount);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    // 구입 금액을 1000원 단위로 계산
    private static int calculatePurchaseCount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위로 입력해야 합니다.");
        }
        return amount / 1000;
    }

    // 로또 개수만큼 생성하여 반환
    private static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers;
            do {
                numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                        .stream().sorted().collect(Collectors.toList());
            } while (hasDuplicate(numbers)); // 중복 체크

            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }


    // 유효한 당첨 번호 리스트를 입력받아 반환
    private static List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요. (예: 1,2,3,4,5,6)");
                String[] input = readLine().split(",");
                List<Integer> numbers = Arrays.stream(input)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                validateWinningNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    // 당첨 번호 유효성 검사
    private static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6 || hasDuplicate(numbers)) {
            // 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다
            // 로또_번호에_중복된_숫자가_있으면_예외가_발생한다
            throw new IllegalArgumentException("당첨 번호는 중복되지 않는 6개의 숫자로 입력해야 합니다.");
        }
        for (int number: numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
            }
        }
    }

    // 유효한 보너스 번호를 입력받아 반환
    private static int getValidBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(readLine());
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    // 보너스 번호 유효성 검사
    private static void validateBonusNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    static boolean hasDuplicate(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    // 당첨 결과를 계산하여 반환
    private static Map<LottoInfo, Integer> calculateResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoInfo, Integer> result = new EnumMap<>(LottoInfo.class);
        for (Lotto lotto : purchasedLottos) {
            LottoInfo rank = determineRank(lotto, winningNumbers, bonusNumber);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    // 로또 한 장의 등수를 확인하여 반환
    private static LottoInfo determineRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = lotto.getNumbers().stream().filter(winningNumbers::contains).count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
        return LottoInfo.findRank((int) matchCount, bonusMatch);
    }

    // 당첨 결과와 수익률을 출력
    private static void displayResult(Map<LottoInfo, Integer> result, int purchaseCount) {
        int totalPrize = 0;
        for (LottoInfo rank : LottoInfo.values()) {
            int count = result.getOrDefault(rank, 0);
            System.out.println(rank.getMatchMessage() + " - " + count + "개");
            totalPrize += count * rank.getPrize();
        }
        double yield = (double) totalPrize / (purchaseCount * 1000) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}
