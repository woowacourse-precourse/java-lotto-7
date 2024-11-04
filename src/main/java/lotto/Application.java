package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("구입 금액을 입력하세요: ");
            int purchaseAmount = Integer.parseInt(Console.readLine());
            validatePurchaseAmount(purchaseAmount);

            int ticketCount = purchaseAmount / 1000;
            System.out.println(ticketCount + "개를 구매했습니다.");
            List<Lotto> purchasedLottos = generateLottoTickets(ticketCount);

            for (Lotto lotto : purchasedLottos) {
                System.out.println(lotto.getNumbers());
            }

            System.out.println("당첨 번호를 입력하세요(쉼표로 구분): ");
            String winningNumbersInput = Console.readLine();
            List<Integer> winningNumbers = parseAndValidateWinningNumbers(winningNumbersInput);

            System.out.println("보너스 번호를 입력하세요: ");
            int bonusNumber = Integer.parseInt(Console.readLine());
            validateBonusNumber(bonusNumber, winningNumbers);

            // 당첨 결과 계산 및 출력
            LottoResult lottoResult = new LottoResult();
            for (Lotto lotto : purchasedLottos) {
                int matchingCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
                boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
                lottoResult.addResult(matchingCount, bonusMatch);
            }
            lottoResult.printStatistics(purchaseAmount);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // 구입 금액 검증: 1,000원 단위 확인
    private static void validatePurchaseAmount(int amount) {
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 로또 티켓 발행 메서드
    private static List<Lotto> generateLottoTickets(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Lotto.generateRandomNumbers();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    // 당첨 번호 입력을 처리하고 검증
    private static List<Integer> parseAndValidateWinningNumbers(String input) {
        String[] numberStrings = input.split(",");
        if (numberStrings.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
            }
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
            }
            numbers.add(number);
        }

        return numbers;
    }

    // 보너스 번호 검증
    private static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    // 일치하는 숫자 개수 계산
    private static int countMatchingNumbers(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : ticketNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}