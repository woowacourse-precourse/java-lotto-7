package lotto;

import static lotto.ExceptionHandler.hasDuplicates;
import static lotto.ExceptionHandler.isLottoNumber;
import static lotto.ExceptionHandler.isLottoPriceDivisible;
import static lotto.ExceptionHandler.isPositiveNumber;
import static lotto.ExceptionHandler.validateLottoNumber;
import static lotto.ExceptionHandler.validateNumeric;
import static lotto.Utils.calculateProfitRate;
import static lotto.Utils.convertToSortedNumber;
import static lotto.Utils.parseByComma;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class IOProcessor {
    private static final List<String> LOTTO_RANK = List.of("FIFTH", "FOURTH", "THIRD", "SECOND", "FIRST");

    public static int readNumber(InputPrompt prompt) {
        String numberText;
        while (true) {
            try {
                System.out.println(prompt.getGuide());
                numberText = Console.readLine().strip();
                validateNumeric(numberText);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(numberText);
    }

    public static List<String> readCommaSeperatedText(InputPrompt prompt) {
        System.out.println(prompt.getGuide());
        String commaSeperatedText = Console.readLine().strip();
        return parseByComma(commaSeperatedText);
    }

    public static int readPurchaseAmount() {
        int purchaseAmount;
        while (true) {
            try {
                purchaseAmount = readNumber(InputPrompt.PURCHASE);
                isPositiveNumber(purchaseAmount);
                isLottoPriceDivisible(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    public static List<Integer> readWinningNumbers() {
        List<String> winningNumbersText;
        List<Integer> winningNumbers;
        while (true) {
            try {
                winningNumbersText = readCommaSeperatedText(InputPrompt.WINNING_NUMBERS);
                winningNumbers = convertToSortedNumber(winningNumbersText);
                validateLottoNumber(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }

    public static int readBonusNumber(List<Integer> numbers) {
        int bonusNumber;
        while (true) {
            try {
                bonusNumber = readNumber(InputPrompt.BONUS_NUMBER);
                isLottoNumber(bonusNumber);
                hasDuplicates(numbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    public static void printIssueAmount(int issueAmount) {
        String issueText = OutputPrompt.LOTTO_ISSUE.print(issueAmount);
        System.out.println(issueText);
    }

    public static void printIssuedLottos(List<Lotto> issuedLottos) {
        for (Lotto lotto : issuedLottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printWinningDetails() {
        String winningDetailHead = OutputPrompt.WINNING_DETAIL_HEAD.getDefaultPrint();
        System.out.println(winningDetailHead);

        for (String rank : LOTTO_RANK) {
            int count = LottoWinner.valueOf(rank).getCount();
            String winningDetail = OutputPrompt.valueOf(rank).print(count);
            System.out.println(winningDetail);
        }
    }

    public static void printProfitRate(int purchaseAmount) {
        String profitRate = calculateProfitRate(purchaseAmount);
        String profitRatePrint = OutputPrompt.PROFIT_RATE.print(profitRate);
        System.out.println(profitRatePrint);
    }
}