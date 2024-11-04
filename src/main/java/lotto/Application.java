package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static void main(String[] args) {
        int money = getInputMoney();
        LottoMachine lottoMachine = new LottoMachine(money);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getInputBonusNumber(winningNumbers);
        int totalPrize = lottoMachine.checkWinning(winningNumbers, bonusNumber);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", calculateProfitRate(totalPrize, money));

    }

    public static int getInputMoney() {
        while (true) {
            System.out.println("구입금액을 입력해주세요.");
            try {
                int money = Integer.parseInt(Console.readLine());
                validateInputMoney(money);
                System.out.println();
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static void validateInputMoney(int money) {
        if (money % LOTTO_PRICE != 0 || money <= 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                String[] splitInput = input.split(",");
                List<Integer> winningNumbers = new ArrayList<>();
                for (String number : splitInput) {
                    winningNumbers.add(Integer.parseInt(number.trim()));
                }
                System.out.println();
                return new Lotto(winningNumbers).getNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static int getInputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());
                validateBonusNumber(bonusNumber, winningNumbers);
                System.out.println();
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public static double calculateProfitRate(int totalPrize, int money) {
        if (money == 0) {
            return 0.0;
        }
        return (double) totalPrize / money * 100;
    }
}
