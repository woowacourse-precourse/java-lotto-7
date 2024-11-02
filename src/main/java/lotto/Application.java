package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money;
        List<Lotto> lottoList = new ArrayList<>();
        List<Integer> winningNumbers;
        int bonusNumber;

        while (true) {
            try {
                money = getMoney();
                exception(money);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println("[ERROR]" + error.getMessage());
            }
        }
        int count = countLotto(money);
        outputCount(count);

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = randomNumbers();
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
        outputnumbers(lottoList);

        while (true) {
            try {
                winningNumbers = inputWinningNumbers();
                break;
            } catch (IllegalArgumentException error) {
                System.out.println("[ERROR]" + error.getMessage());
            }
        }

        while (true) {
            try {
                bonusNumber = inputBonusNumber(winningNumbers);
                break;
            } catch (NumberFormatException error) {
                System.out.println("[ERROR]" + " 1개의 숫자 이외의 문자는 입력이 안됩니다.");
            } catch (IllegalArgumentException error) {
                System.out.println("[ERROR]" + error.getMessage());
            }
        }

        LottoResult result = calculateResult(lottoList, winningNumbers, bonusNumber);
        outputResult(result);

        profitRateResult(money, result.totalWinningPrize());
    }

    private static int getMoney() {
        System.out.println("로또 구매 금액을 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static void exception (int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("금액이 0보다 커야 합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또 금액이 1개당 1000원이므로 1000원 단위로 입력하세요.");
        }
    }

    private static int countLotto(int money) {
        return money / 1000;
    }

    private static void outputCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    private static List<Integer> randomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Integer::compareTo);
        return numbers;
    }

    private static void outputnumbers(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. (예: 1,2,3,4,5,6)");
        String input = Console.readLine();
        String[] splitInput = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();


        for (String num : splitInput) {
            int number = Integer.parseInt(num.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
            }
            if (winningNumbers.contains(number)) {
                throw new IllegalArgumentException("중복된 당첨 번호가 있습니다.");
            }
            winningNumbers.add(number);
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자를 입력해야 합니다.");
        }
        return winningNumbers;
    }

    private static int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());


        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return bonusNumber;
    }

    private static LottoResult calculateResult(List<Lotto> lottoList, List<Integer> winningNumbers, int bonusNumber) {
        LottoResult result = new LottoResult();

        for (int i = 0; i < lottoList.size(); i++) {
            Lotto lotto = lottoList.get(i);

            int matchCount = 0;
            for (int j = 0; j < lotto.getNumbers().size(); j++) {
                if (winningNumbers.contains(lotto.getNumbers().get(j))) {
                    matchCount++;
                }
            }

            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            result.winningResult(matchCount, bonusMatch);
        }
        return result;
    }

    private static void outputResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.getCountOf3Match());
        System.out.println("4개 일치 (50,000원) - " + result.getCountOf4Match());
        System.out.println("5개 일치 (1,500,000원) - " + result.getCountOf5Match());
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getCountOf5MatchAndBonus());
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getCountOf5MatchAndBonus());
    }

    private static void profitRateResult(double money, double winningPrize) {
        double ProfitRate = ((winningPrize / money) * 100);
        System.out.println("총 수익률은 " + ProfitRate + "%입니다.");
    }
}