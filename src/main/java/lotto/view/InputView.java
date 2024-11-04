package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    // 로또 구입 금액 입력 메소드
    public int purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                int amount = Integer.parseInt(Console.readLine());
                System.out.println();
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
            }
        }
    }

    // 당첨 번호 입력 메소드
    public List<Integer> winningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = numberValidate();
        System.out.println();
        return winningNumbers;
    }

    // 당첨 번호 입력 및 유효성 검사 메소드
    private List<Integer> numberValidate() {
        while (true) {
            try {
                List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                detailValidate(winningNumbers);
                return winningNumbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 숫자로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 당첨 번호 유효성 검사
    private void detailValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
        }
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 존재합니다.");
        }
    }

    // 보너스 번호 입력 메소드
    public int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                int bonus = Integer.parseInt(Console.readLine());
                bonusValidate(bonus);
                System.out.println();

                return bonus;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 보너스 번호 유효성 검사
    private void bonusValidate(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
