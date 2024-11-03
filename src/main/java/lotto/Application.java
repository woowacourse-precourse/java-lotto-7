package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int purchaseAmount = Integer.parseInt(Console.readLine());

            int ticketCount = calculateTicketCount(purchaseAmount);
            System.out.println(ticketCount + "개를 구매했습니다.");

            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = Integer.parseInt(Console.readLine());

            LottoValidator.validateWinningNumbers(winningNumbers, bonusNumber);

            Lotto lotto = Lotto.generateLotto();
            System.out.println("생성된 로또 번호: " + lotto.getNumbers());

        } catch (NumberFormatException e) {
            System.out.println(ErrorMessages.INVALID_INPUT.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int calculateTicketCount(int purchaseAmount) {
        final int TICKET_PRICE = 1000;
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_AMOUNT.getMessage());
        }
        return purchaseAmount / TICKET_PRICE;
    }
}