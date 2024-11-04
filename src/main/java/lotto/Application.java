package lotto;

import lotto.model.Lotto;
import lotto.model.Money;
import lotto.validator.IntegerValidator;
import lotto.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        // 1. 로또 구입 금액 입력
        int number = IntegerValidator.moneyValidator(InputView.inputMoney());
        Money money = new Money(number);

        // 2. 로또 번호 추첨
        int count = money.getCount();
        List<List<Integer>> lottos = Lotto.makeRandomNumbers(count);

//
//        // 3. 구매 로또 번호 수량 및 번호 출력
//        String checkCount = "%d개를 구매했습니다.".formatted(count);
//        System.out.println(checkCount);
//
//        for (List<Integer> purchaseNumbers : purchaseLottos) {
//            Collections.sort(purchaseNumbers);
//            System.out.println(purchaseNumbers);
//        }
//
//        // 4. 로또 당첨 번호 입력
//        System.out.println("당첨 번호를 입력해 주세요.");
//        List<String> numbers = List.of(Console.readLine().split(","));
//
//        List<Integer> winningNumbers = new ArrayList<>();
//
//        // 4-1. 먼저 숫자로 변환할 수 있는지를 확인
//        for (String number : numbers) {
//            try {
//                int winningNumber = Integer.parseInt(number);
//                winningNumbers.add(winningNumber);
//            } catch (NumberFormatException e) {
//                throw new IllegalArgumentException("[ERROR] 로또 번호는 정수여야 합니다.");
//            }
//        }
//
//        // 4-2. 숫자가 1-45 사이에 있는 숫자인지 확인
//        for (int winningNumber : winningNumbers) {
//            if (winningNumber > 45 || winningNumber < 1) {
//                throw new IllegalArgumentException("[ERROR] 로또 번호는 1-45 사이의 정수여야 합니다.");
//            }
//        }
//
//        // 4-3. 입력된 모든 숫자가 서로 다른지 확인
//        for (int winningNumber : winningNumbers) {
//            if (Collections.frequency(winningNumbers, winningNumber) != 1) {
//                throw new IllegalArgumentException("[ERROR] 로또 번호의 모든 숫자는 서로 다른 숫자여야 합니다.");
//            }
//        }
//
//        // 4-4. 6개의 숫자가 입력되었는지 확인
//        if (numbers.size() != 6) {
//            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
//        }
//
//        // 5. 보너스 번호 입력
//        int bonusNumber;
//        System.out.println("보너스 번호를 입력해 주세요.");
//        try {
//            bonusNumber = Integer.parseInt(Console.readLine());
//        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수여야 합니다.");
//        }
//
//        // 5-1. 보너스 번호가 1-45 사이에 있는 숫자인지 확인
//        if (bonusNumber > 45 || bonusNumber < 1) {
//            throw new IllegalArgumentException("[ERROR] 로또 번호의 모든 숫자는 서로 다른 숫자여야 합니다.");
//        }
//
//        // 5-2. 보너스 번호가 기존에 있는 로또번호와 서로 다른지 확인
//        if (Collections.frequency(winningNumbers, bonusNumber) != 0) {
//            throw new IllegalArgumentException("[ERROR] 로또 번호의 모든 숫자는 서로 다른 숫자여야 합니다.");
//        }
//
//        // 6. 당첨 여부 확인
//        int firstCount = 0;
//        int secondCount = 0;
//        int thirdCount = 0;
//        int fourthCount = 0;
//        int fifthCount = 0;
//
//        for (List<Integer> purchaseNumbers : purchaseLottos) {
//            int matchCount = 0;
//            boolean bonusMatch = false;
//
//            // 6-1. 구매한 로또 번호와 당첨 로또 번호가 몇 개 일치하는지 확인
//            for (int number : purchaseNumbers) {
//                if (winningNumbers.contains(number)) {
//                    matchCount++;
//                }
//            }
//
//            // 6-2. 만약 5개가 일치한다면 보너스 볼 일치 여부 확인
//            if (matchCount == 5 & purchaseNumbers.contains(bonusNumber)) {
//                bonusMatch = true;
//            }
//
//            // 6-3. 일치한 수에 따라 해당 등수 개수 추가
//            if (matchCount == 6) {
//                firstCount++;
//            } else if (matchCount == 5 & bonusMatch) {
//                secondCount++;
//            } else if (matchCount == 5) {
//                thirdCount++;
//            } else if (matchCount == 4) {
//                fourthCount++;
//            } else if (matchCount == 3) {
//                fifthCount++;
//            }
//        }
//
//        // 7. 수익률 계산
//        int earnings = firstCount * 2000000000 + secondCount * 30000000 + thirdCount * 1500000 + fourthCount * 50000 + fifthCount * 5000;
//        double earningsRate = (double) (earnings - money) / money * 100;
//        earningsRate = Math.round(earningsRate * 100 / 100.0);
//
//        // 8. 당첨 통계 출력
//        String first = "6개 일치 (2,000,000,000원) - %d개".formatted(firstCount);
//        String second = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개".formatted(secondCount);
//        String third = "5개 일치 (1,500,000원) - %d개".formatted(thirdCount);
//        String fourth = "4개 일치 (50,000원) - %d개".formatted(fourthCount);
//        String fifth = "3개 일치 (5,000원) - %d개".formatted(fifthCount);
//        String result = "총 수익률은 %.1f%%입니다.".formatted(earningsRate);
//
//        System.out.println("당첨 통계");
//        System.out.println("---");
//        System.out.println(first);
//        System.out.println(second);
//        System.out.println(third);
//        System.out.println(fourth);
//        System.out.println(fifth);
//        System.out.println(result);
    }
}
