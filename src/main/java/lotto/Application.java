package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            // 구입 금액 입력 및 유효성 검증
            int purchaseAmount = validatePurchaseAmount();

            // 로또 번호 발행
            List<Lotto> userLottos = publishLottos(purchaseAmount);
            System.out.println(userLottos.size() + "개를 구매했습니다.");
            userLottos.forEach(lotto -> System.out.println(lotto.getNumbers()));

            // 당첨 번호 및 보너스 번호 입력
            List<Integer> winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber();

            // 당첨 결과 확인
            int totalPrize = checkResults(userLottos, winningNumbers, bonusNumber);

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
    //로또 번호 생성 기능
    private static Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        numbers.sort(Integer::compareTo); // 번호 오름차순 정렬
        return new Lotto(numbers);
    }
    //구입 금액 입력 및 유효성 검증 기능 추가
    private static int validatePurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int amount = Integer.parseInt(Console.readLine());
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해 주세요.");
        }
    }
    //로또 티켓 발행기능
    private static List<Lotto> publishLottos(int amount) {
        int count = amount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    //당첨 번호 및 보너스 번호 입력 기능 추가
    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        List<Integer> winningNumbers = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        return winningNumbers;
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }

    private static int checkResults(List<Lotto> userLottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] prizeCount = new int[5];
        int totalPrize = 0;

        for (Lotto lotto : userLottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            if (matchCount == 6) {
                prizeCount[0]++;
                totalPrize += 2000000000;
            } else if (matchCount == 5 && bonusMatch) {
                prizeCount[1]++;
                totalPrize += 30000000;
            } else if (matchCount == 5) {
                prizeCount[2]++;
                totalPrize += 1500000;
            } else if (matchCount == 4) {
                prizeCount[3]++;
                totalPrize += 50000;
            } else if (matchCount == 3) {
                prizeCount[4]++;
                totalPrize += 5000;
            }
        }
        printResults(prizeCount);
        return totalPrize;
    }
    private static int getMatchCount(List<Integer> userNumbers, List<Integer> winningNumbers) {
        return (int) userNumbers.stream().filter(winningNumbers::contains).count();
    }

    private static void printResults(int[] prizeCount) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + prizeCount[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeCount[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeCount[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeCount[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeCount[0] + "개");
    }

}