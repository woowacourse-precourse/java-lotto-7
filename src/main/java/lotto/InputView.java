package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class InputView {

    public void inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String inputAmount = Console.readLine();
                int purchaseAmount = Integer.parseInt(inputAmount);
                if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputWinningNumbers() {
        Set<Integer> winningNumbers = new HashSet<>();
        while (true) {
            try {
                System.out.println();
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputWinningNumbers = Console.readLine();
                String[] splitWinningNumbers = inputWinningNumbers.split(",");
                if (splitWinningNumbers.length != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
                }
                for (String numStr : splitWinningNumbers) {
                    int num = Integer.parseInt(numStr.trim());
                    if (num < 1 || num > 45) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                    if (!winningNumbers.add(num)) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
                    }
                }
                break; // 유효한 당첨 번호가 입력되면 루프 종료
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 숫자여야 합니다.");
                winningNumbers.clear(); // 잘못된 입력 시 집합 초기화
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                winningNumbers.clear(); // 잘못된 입력 시 집합 초기화
            }
        }
    }
}
