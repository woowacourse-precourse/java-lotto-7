package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumbers;

public class InputView {
    public PurchasePrice receivePurchasePrice() {
        while(true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int inputPrice = Integer.parseInt(Console.readLine().trim());
                return new PurchasePrice(inputPrice);
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.NOT_A_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumbers receiveWinningNumbers() {
        while (true) {
            try {
//            System.out.println("\n당첨 번호를 입력해 주세요.");
                System.out.println("\nplease input the winning numbers");
                String[] separatedNumbers = Console.readLine().split(",");
                List<Integer> receivedLottoNumbers = Arrays.stream(separatedNumbers)
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();
                return new WinningNumbers(receivedLottoNumbers);
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.NOT_A_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public BonusNumber receiveBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
//            System.out.println("\n보너스 번호를 입력해 주세요.");
                System.out.println("\nplease input the bonus number");
                int bonusNumber = Integer.parseInt(Console.readLine().trim());
                return new BonusNumber(bonusNumber, winningNumbers.getReceivedLottoNumbers());
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.NOT_A_SINGLE.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
