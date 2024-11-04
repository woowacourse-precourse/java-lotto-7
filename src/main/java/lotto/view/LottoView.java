package lotto.view;

import lotto.WinnerPrice;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.*;

public class LottoView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE = "[ERROR]";

    //구입금액 입력
    public int inputPurchaseAmountProcess() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);

        while (true) {
            try {
                int purchaseAmount = inputAndValidateNumberForm();
                validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println(ERROR_MESSAGE + " " + "1000으로 나누어 떨어지는 자연수를 입력해 주세요.");
            }
        }
    }

    public int inputAndValidateNumberForm() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }

    private static void validatePurchaseAmount(int purchaseAmount) {

        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }

    }

    public void outputBuyLottoMessage(int purchaseAmount) {
        int amountCount = purchaseAmount / 1000;
        System.out.println();
        System.out.println(amountCount + "개를 구매했습니다.");

    }

    public void outputLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());

    }

    public void outputWinningNumbersMessage() {
        System.out.println();
        System.out.println(WINNING_NUMBER_MESSAGE);

    }

    public void outputBonusNumberInputMessage() {
        System.out.println();
        System.out.println(BONUS_NUMBER_MESSAGE);

    }

    public void outputWinningStatisticsStart() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

    }

    //당첨번호 입력
    public List<Integer> inputWinningNumbersProcess() {
        while (true) {
            try {
                String input = readLine();
                String[] inputTokens = input.split(",");
                List<Integer> winningNumbers = getWinningNumbers(inputTokens);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println(ERROR_MESSAGE + " " + "로또 번호는 1부터 45 사이의 6개의 숫자여야 합니다.");

            }
        }
    }

    public List<Integer> getWinningNumbers(String[] inputTokens) {
        if (inputTokens.length != 6) {
            throw new IllegalArgumentException("6개의 숫자를 입력해야함.");
        }

        List<Integer> winningNumbers = new ArrayList<>();
        for (String inputToken : inputTokens) {
            int winningNumber = validateTokenNumberForm(inputToken);
            winningNumbers.add(winningNumber);
        }
        validateUniqueWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private  void validateUniqueWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> winningNumberSet = new HashSet<>(winningNumbers);
        if (winningNumberSet.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("중복되지 않는 당첨 번호들을 입력해 주세요!");
        }
    }

    private static int validateTokenNumberForm(String winningNumberToken) {
        try {
            int winningNumber = Integer.parseInt(winningNumberToken);
            if (winningNumber < 1 || winningNumber > 45) throw new IllegalArgumentException("1과 45사이의 숫자가 아님.");

            return winningNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아님.");
        }

    }

    //보너스 번호 입력
    public int inputBonusNumberProcess(List<Integer> winnerNumbers) {
        while (true) {
            try {
                String inputBonusNumber = readLine();
                int bonusNumber = validateBonusNumber(inputBonusNumber);
                validateBonusNumberInWinnerNumbers(bonusNumber, winnerNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println(ERROR_MESSAGE + " " + "1부터 45사이의 당첨번호에 포함되지 않는 번호를 입력해주세요!");

            }
        }

    }

    public int validateBonusNumber(String inputBonusNumbers) {

        try {
            int bonusNumber = Integer.parseInt(inputBonusNumbers);
            if (bonusNumber < 1 || bonusNumber > 45) throw new IllegalArgumentException("1부터 45사이의 숫자가 아닙니다.");
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }
    }

    public void validateBonusNumberInWinnerNumbers(int bonusNumber, List<Integer> winnerNumbers) {
        boolean result = winnerNumbers.contains(bonusNumber);
        if (result) {
            throw new IllegalArgumentException("당첨 번호 중 보너스 번호가 이미 포함되어 있습니다.");
        }

    }

    //당첨 통계 출력
    public void outputWinnerStatistics(List<Integer> winningStatistics) {
        int winningStatisticsIndex = 0;
        WinnerPrice[] winnerPrices = WinnerPrice.values();
        for (int i = winnerPrices.length - 1; i >= 0; i--) {
            System.out.println(winnerPrices[i].getOutputMessage() + winningStatistics.get(winningStatisticsIndex++) + "개");

        }

    }

    //총 수익률 출력
    public void outputProfitRate(double profitRate) {
        double profitRateOutputValue = Math.round(profitRate * 10.0) / 10.0;
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRateOutputValue);
        System.out.println();
    }

}
