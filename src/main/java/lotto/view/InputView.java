package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.util.LottoValidator;

public class InputView {
    public int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int purchaseAmount = Integer.parseInt(Console.readLine());
                LottoValidator.validatePurchaseAmount(purchaseAmount);

                return purchaseAmount;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구입금액은 숫자만 허용됩니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumbers () {
        while (true) {
            try {
                System.out.println();
                System.out.println("당첨 번호를 입력해 주세요.");
                String[] rawWinningNumbers = splitRawNumbers(Console.readLine());
                List<Integer> winningNumbers = convertToWinningNumbers(rawWinningNumbers);

                LottoValidator.validateLottoNumbers(winningNumbers);

                return winningNumbers;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("당첨 번호는 숫자만 허용됩니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());
                LottoValidator.validateBonusNumber(bonusNumber, winningNumbers);

                return bonusNumber;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("보너스 번호는 숫자만 허용됩니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private String[] splitRawNumbers (String rawNumbers) {
        return rawNumbers.split(",");
    }

    private List<Integer> convertToWinningNumbers (String[] rawWinningNumbers) {
        return Arrays.stream(rawWinningNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
