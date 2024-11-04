package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TODO 숫자 다 상수로 수정

public class InputHandler {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private final static int LOTTO_NUM_SIZE = 6;
    public int getLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                int amount = Integer.parseInt(Console.readLine());
                validateInputMoneyAmount(amount);

                return amount / 1000;
            }

            catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }

    }

    public List<Integer> getWinnerNumber() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> winnerNumbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();
                validateNumberInput(winnerNumbers);
                return winnerNumbers;
            }
            catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }

    public int getBonusNumber(List<Integer> winnerNumbers) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());
                checkNumber(bonusNumber);
                checkBonusNumberDuplicateWithWinnerNumbers(winnerNumbers, bonusNumber);

                return bonusNumber;
            }

            catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }

    private void checkBonusNumberDuplicateWithWinnerNumbers(List<Integer> winnerNumbers, int bonusNumber) {
        Set<Integer> check = new HashSet<>(winnerNumbers);
        if (!check.add(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

    private void checkNumber(int number) {
        if (!(number >= 1 && number <= 45)) {
            throw new IllegalArgumentException("1부터 45까지만 가능합니다.");
        }
    }

    private void validateInputMoneyAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위로 입력해주세요.");
        }
    }



    private void validateNumberInput(List<Integer> winnerNumbers) {
        checkInputNumberCount(winnerNumbers);
        checkDuplicateWinnerNumber(winnerNumbers);
        checkWinnerNumberRange(winnerNumbers);
    }

    private void checkInputNumberCount(List<Integer> winnerNumbers) {
        if (winnerNumbers.size() != LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void checkDuplicateWinnerNumber(List<Integer> winnerNumbers) {
        Set<Integer> check = new HashSet<>();
        for(Integer number : winnerNumbers) {
            if (!check.add(number)) {
                throw new IllegalArgumentException("로또 숫자는 중복될 수 없습니다. 중복 번호 : " + number);
            }
        }
    }

    private void checkWinnerNumberRange(List<Integer> winnerNumbers) {
        winnerNumbers.forEach(this::checkNumber);
    }
}
