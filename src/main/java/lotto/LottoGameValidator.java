package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoGameValidator {

    public void validateAmount(int amount, int LOTTO_PRICE) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
    }

    public int readAmount(int LOTTO_PRICE) {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int amount = Integer.parseInt(Console.readLine());
                validateAmount(amount, LOTTO_PRICE);
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식이 올바르지 않습니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> parseWinningNumbers(String input) {
        String[] separatedNumbers = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String separatedNumber : separatedNumbers) {
            int winningNumber = Integer.parseInt(separatedNumber.trim());
            winningNumbers.add(winningNumber);
        }

        validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 모든 당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자로 구성되어야 합니다.");
        }
        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }
}
