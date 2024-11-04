package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        // 로또 구입 금액 입력받기
        int totalPurchase = getTotalPurchase();

        int numberOfLottos = buyLotto(totalPurchase);

        WinningNumbers winningNumber = null;
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        while (winningNumber == null) {
            try {
                winningNumber = new WinningNumbers(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                // 다시 입력 받기
                winningNumbers = getWinningNumbers();
                bonusNumber = getBonusNumber();
            }
        }
        winningNumber = new WinningNumbers(winningNumbers, bonusNumber);


        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            tickets.add(lotto);
        }

        // 로또 출력하기
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }

        // 당첨 확인하고 금액 계산하기
        LottoGame lottoGame = new LottoGame(tickets, winningNumber);
        lottoGame.calculateResults();
        lottoGame.printResults(totalPurchase);

    }

    private static int getTotalPurchase() {
        while (true) {
            System.out.println("구입 금액을 입력해 주세요.");
            String input = readLine();
            try {
                // 입력값이 숫자가 아닐 경우 IllegalArgumentException 발생
                if (!input.matches("\\d+")) {
                    throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
                }
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static List<Integer> getWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력하세요.(숫자는 쉼표(,) 기준으로 구분)");
            String input = readLine();
            try {
                List<Integer> winningNumbers = Arrays.stream(input.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                Collections.sort(winningNumbers); // 당첨 번호 정렬
                return winningNumbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 잘못된 입력입니다. 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static int getBonusNumber() {
        while (true) {
            System.out.println("보너스 번호를 입력하세요.");
            String input = readLine();
            try {
                // 입력값이 숫자가 아닐 경우 IllegalArgumentException 발생
                if (!input.matches("\\d+")) {
                    throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
                }
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    static public int buyLotto(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000으로 나눠떨어져야 합니다.");
        }

        int numberOfLottos = amount / 1000; // 로또 개수 계산

        return numberOfLottos;
    }
}
