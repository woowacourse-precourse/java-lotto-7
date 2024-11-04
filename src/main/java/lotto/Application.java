package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("로또를 구매할 금액을 입력해주세요 (1장에 1000원):");
            int amount = Integer.parseInt(scanner.nextLine().trim());

            if (amount < 1000 || amount % 1000 != 0) {
                System.out.println("[ERROR] 입력 금액은 1000원 단위의 양의 정수여야 합니다.");
                return;
            }

            List<Lotto> purchasedLottos = LottoPurchase.purchaseLottos(amount);
            System.out.println("구매한 로또 티켓 수: " + purchasedLottos.size());

            System.out.println("당첨 번호 6개를 쉼표(,)로 구분하여 입력해 주세요:");
            String line = scanner.nextLine();
            List<Integer> winningNumbers = Arrays.stream(line.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            if (winningNumbers.size() != 6) {
                System.out.println("[ERROR] 정확히 6개의 당첨 번호를 입력해야 합니다.");
                return;
            }

            System.out.println("보너스 번호를 입력해주세요:");
            int bonusNumber = Integer.parseInt(scanner.nextLine().trim());

            // 구매 금액을 추가로 전달
            LottoResultDisplay.displayResults(purchasedLottos, winningNumbers, bonusNumber, amount);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자 입력이 올바르지 않습니다.");
        } finally {
            scanner.close();
        }
    }
}
