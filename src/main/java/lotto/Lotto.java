package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (checkDuplicateList(numbers)) {
            throw new IllegalArgumentException("[ERROR] 입력된 당첨 번호가 중복인 숫자가 있습니다.");
        }
    }

    private static boolean checkDuplicateList(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) == numbers.get(j)) {
                    return true;
                }
            }
        }
        return false;
    }


    // TODO: 추가 기능 구현
    public static boolean validatePurchase(String numbers) {
        try {
            if (!(numbers.matches("^[0-9]*$")) ) {
                throw new IllegalArgumentException("[ERROR] 숫자가 입력되어야 합니다.");
            }
            if (Integer.parseInt(numbers) % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 천 원 단위여야 합니다.");
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean validateWinningNumber(String[] numbers) {
        try {
            if (numbers.length != 6) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
            }
            if (!checkNumbersRange(numbers)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이 숫자여야 합니다.");
            }
            if (checkDuplicateNumbers(numbers)) {
                throw new IllegalArgumentException("[ERROR] 입력된 당첨 번호가 중복인 숫자가 있습니다.");
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static boolean checkNumbersRange(String[] numbers) {
        for (String number : numbers) {
            if (!(number.matches("^[0-9]*$")) ) {
                throw new IllegalArgumentException("[ERROR] 숫자가 입력되어야 합니다.");
            }
            if(!(Integer.parseInt(number) >= 1 && Integer.parseInt(number) <= 45)) {
                return false;
            }
        }
        return true;
    }

    // Depth 3
    private static boolean checkDuplicateNumbers(String[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i].equals(numbers[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validateBonus(String[] winningNumbers, String bounsNumber) {
        try {
            if (!(bounsNumber.matches("^[0-9]*$")) ) {
                throw new IllegalArgumentException("[ERROR] 숫자가 입력되어야 합니다.");
            }
            if (!(Integer.parseInt(bounsNumber) >= 1 && Integer.parseInt(bounsNumber) <= 45)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이 숫자여야 합니다.");
            }
            if(checkDuplicationBonus(winningNumbers, bounsNumber)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 이미 입력된 숫자입니다.");
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static boolean checkDuplicationBonus(String[] numbers, String input) {
        for (String element : numbers) {
            if (input.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // 1. 로또 구입 금액 만큼의 로또 번호를 저장한다.
    public static Lotto purchaseLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Integer::compareTo); // 정렬 후 반환
        Lotto lotto = new Lotto(numbers);
        System.out.println(lotto.getNumbers());
        return lotto;
    }

    // 3. 당첨 번호와 로또 번호를 비교해서 결과를 저장한다.
    public static Integer[] calculateWinningStatus(List<Integer> lottoNumbers, String[] winningNumber, int bonusNumber) {
        int count = 0;
        Integer[] temp = new Integer[2];
        for (int i = 0; i < lottoNumbers.size(); i++) {
            if (lottoNumbers.contains(Integer.parseInt(winningNumber[i]))) {
                count++;
            }
        }
        temp[0] = count;
        temp[1] = 0;
        if (lottoNumbers.contains(bonusNumber)) {
            temp[1] = 1;
        }
        return temp;
    }

    public static int checkLottoResult(int number, boolean bonus) {
        Rank rank = Rank.getRank(number, bonus);
        if (rank == Rank.THREE) {
            return 5000;
        }
        if (rank == Rank.TWO_WITH_BONUS) {
            return 5000;
        }
        if (rank == Rank.FOUR) {
            return 50000;
        }
        if (rank == Rank.THREE_WITH_BONUS) {
            return 50000;
        }
        if (rank == Rank.FOUR_WITH_BONUS) {
            return 1500000;
        }
        if (rank == Rank.FIVE) {
            return 3000000;
        }
        if (rank == Rank.FIVE_WITH_BONUS) {
            return 2000000000;
        }
        if (rank == Rank.SIX) {
            return 2000000000;
        }
        if (rank == Rank.SIX_WITH_BONUS) {
            return 2000000000;
        }
        return 0;
    }

    public static int checkWinnerIndex(int number, boolean bonus) {
        Rank rank = Rank.getRank(number, bonus);
        if (rank == Rank.THREE) {
            return 1;
        }
        if (rank == Rank.TWO_WITH_BONUS) {
            return 1;
        }
        if (rank == Rank.FOUR) {
            return 2;
        }
        if (rank == Rank.THREE_WITH_BONUS) {
            return 2;
        }
        if (rank == Rank.FOUR_WITH_BONUS) {
            return 3;
        }
        if (rank == Rank.FIVE) {
            return 4;
        }
        if (rank == Rank.FIVE_WITH_BONUS) {
            return 5;
        }
        if (rank == Rank.SIX) {
            return 5;
        }
        if (rank == Rank.SIX_WITH_BONUS) {
            return 5;
        }
        return 0;
    }

    public static Integer[] lottoStatistics(int count) {
        Integer[] result = new Integer[7];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }

        int sum = 0;
        Integer[] temp;
        List<Integer>[] tempList = new List[count];
        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.purchaseLotto();
            tempList[i] = lotto.getNumbers();
        }

        String[] winningNumber = inputWinningNumbers();
        int bonusNumInt = inputBonusNumbers(winningNumber);

        for (int i = 0; i < count; i++) {
            temp = calculateWinningStatus(tempList[i], winningNumber, bonusNumInt);
            boolean bonus = false;
            if (temp[1] == 1) {
                bonus = true;
            }
            result[checkWinnerIndex(temp[0], bonus)] += 1;
            sum += checkLottoResult(temp[0], bonus);
        }

        result[6] = sum;
        return result;
    }

    private static String[] inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winningNumber[];
        while (true) {
            String winningNum = Console.readLine();
            winningNumber = winningNum.split(",");
            if (validateWinningNumber(winningNumber)) {
                break;
            }
        }

        return winningNumber;
    }

    private static int inputBonusNumbers(String[] winningNumber) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumInt;
        while (true) {
            String bonusNum = Console.readLine();
            if (validateBonus(winningNumber, bonusNum)) {
                bonusNumInt = Integer.parseInt(bonusNum);
                break;
            }
        }

        return bonusNumInt;
    }
}
