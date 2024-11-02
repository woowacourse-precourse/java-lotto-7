package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Reader {

    private static final int PRICE = 1000;
    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;

    public int readMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                return validateMoney(readInt());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입금액은 로또 한 개의 가격 보다 큰 정수만 입력해야 합니다.");
                System.out.println("현재 로또 가격: " + PRICE + "원");
            }
        }
    }

    private int validateMoney(int money) {
        if (money < PRICE) {
            throw new IllegalArgumentException();
        }
        return money;
    }

    public List<Integer> readLottoNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                return validateLottoNumbers(readIntStream());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 " + START + "부터 "
                        + END + " 사이의 숫자를 중복 없이 쉼표(,)로 구분해서 "
                        + COUNT + "개 입력해야 합니다.");
            }
        }
    }

    private List<Integer> validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != COUNT
                || numbers.size() != numbers.stream().distinct().count()
                || !numbers.stream().allMatch(n -> START <= n && n <= END)
        ) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    public int readBonusNumber(List<Integer> lottoNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                return validateBonusNumber(readInt(), lottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 "
                        + START + "부터 "
                        + END + " 사이의 정수여야 합니다.");
            }
        }
    }

    private int validateBonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
        if (!(START <= bonusNumber && bonusNumber <= END)
                || lottoNumbers.contains(bonusNumber)
        ) {
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    private List<Integer> readIntStream() {
        try {
            String[] strings = readLine().split(",");
            return Arrays.stream(strings).map(Integer::parseInt).toList();
        } catch (NoSuchElementException | IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (SecurityException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
