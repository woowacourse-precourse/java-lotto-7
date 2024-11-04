package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final int price = getPrice();

        final int numOfLotto = price / 1000;
        System.out.println(numOfLotto + "개를 구매했습니다.");

        final List<List<Integer>> listOfLotto = pickLotto(numOfLotto);
        for (List<Integer> eachOfLotto : listOfLotto) {
            System.out.println(eachOfLotto);
        }

        final List<Integer> winningNumbers = getWinningNumbers();

        final int bonusNumber = getBonusNumber(winningNumbers);

        Map<rank, Integer> resultOfLotto = calculatorForLotto(listOfLotto, winningNumbers, bonusNumber);

    }

    private static Map<rank, Integer> calculatorForLotto(List<List<Integer>> listOfLotto, List<Integer> winningNumbers, int bonusNumber) {
        Map<rank, Integer> resultOfLotto = new HashMap<>();
        for (rank rank : rank.values()) {
            resultOfLotto.put(rank, 0);
        }

        for (List<Integer> lotto : listOfLotto) {
            int matchCount = 0;
            for (int number : lotto) {
                if (winningNumbers.contains(number)) {
                    matchCount++;
                }
            }
            if (matchCount == 6) {
                resultOfLotto.put(rank.first, resultOfLotto.get(rank.first) + 1);
            } else if (matchCount == 5 && lotto.contains(bonusNumber)) {
                resultOfLotto.put(rank.second, resultOfLotto.get(rank.second) + 1);
            } else if (matchCount == 5) {
                resultOfLotto.put(rank.third, resultOfLotto.get(rank.third) + 1);
            } else if (matchCount == 4) {
                resultOfLotto.put(rank.fourth, resultOfLotto.get(rank.fourth) + 1);
            } else if (matchCount == 3) {
                resultOfLotto.put(rank.fifth, resultOfLotto.get(rank.fifth) + 1);
            }

        }
        return resultOfLotto;
    }

    private static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");

        final String inputForBonus = Console.readLine();

        int bonusNumber;
        try {
            bonusNumber = isNotNum(inputForBonus);
            rangeOfNumber(bonusNumber);
            isAlreadyExist(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
        return bonusNumber;
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        final String inputForWinningNumbers = Console.readLine();

        String[] arrayForWinningNumbers = inputForWinningNumbers.split(",");

        List<String> listOfWinningNumbers = new ArrayList<>(Arrays.asList(arrayForWinningNumbers));

        List<Integer> winningNumbers = new ArrayList<>();

        for (String winningNumber : listOfWinningNumbers) {
            try {
                int number = isNotNum(winningNumber);
                rangeOfNumber(number);
                winningNumbers.add(number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return getWinningNumbers();
            }
        }

        try {
            Lotto countOfWinningNumbers = new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
        return winningNumbers;
    }

    private static List<List<Integer>> pickLotto(int numOfLotto) {
        List<List<Integer>> listOfLotto = new ArrayList<>();

        for (int i = 0; i < numOfLotto; i++) {
            List<Integer> pickOneOfLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(pickOneOfLotto);
            listOfLotto.add(pickOneOfLotto);
        }
        return listOfLotto;
    }

    private static int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        final String inputForPrice = Console.readLine();
        try {
            int price = isNotNum(inputForPrice);
            isThousandUnit(price);
            return price;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPrice();
        }
    }

    public static void isThousandUnit(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
        }
    }

    public static int isNotNum(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public static void rangeOfNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력 가능합니다.");
        }
    }

    public static void isAlreadyExist(List<Integer> listOfInteger, int number) {
        if (listOfInteger.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 해당하지 않는 숫자만 입력 가능합니다.");
        }
    }

    public enum rank {
        first("1등"),
        second("2등"),
        third("3등"),
        fourth("4등"),
        fifth("5등");

        private final String displayName;

        rank(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }
    }
}
