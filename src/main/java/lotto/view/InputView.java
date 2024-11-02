package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import lotto.dto.LottoInputDTO;
import lotto.utils.Validator;

public class InputView {
    private final OutputView outputView = new OutputView();

    public LottoInputDTO inputLottoData() {
        int parsedPurchaseAmount = parsePurchaseAmount(inputPurchaseAmount());
        String[] winningNumbers = inputWinningLotto();
        int[] parsedWinningNumbers = parseWinningNumbers(winningNumbers);
        int parsedBonusNumber = parseBonusNumber(inputBonusNumber(winningNumbers));

        // 모든 입력 값을 담아 DTO로 생성
        return new LottoInputDTO(parsedPurchaseAmount, parsedWinningNumbers, parsedBonusNumber);
    }

    public String inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String purchaseAmount = Console.readLine();
                // 유효성 검증
                Validator.checkPurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
            }
        }
    }

    public String[] inputWinningLotto() {
        while (true) {
            try {
                System.out.println("지난 주 당첨 번호를 입력해 주세요.");
                String input = Console.readLine().replace("\\s", "");
                String[] winningNumbersStr = input.split(",");
                // 유효성 검증
                Validator.checkWinningLottoNumbers(winningNumbersStr, "6개의 당첨 번호를 입력해야 합니다.");
                return winningNumbersStr;
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
            }
        }
    }

    public String inputBonusNumber(String[] winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 볼을 입력해 주세요.");
                String bonusNumber = Console.readLine();
                // 유효성 검증
                Validator.checkBonusNumber(bonusNumber, winningNumbers, "보너스 번호를 입력해주세요.");
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
            }
        }
    }

    // 파싱 메서드 추가
    private int parsePurchaseAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }

    private int[] parseWinningNumbers(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private int parseBonusNumber(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }
}
