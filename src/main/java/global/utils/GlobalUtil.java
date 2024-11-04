package global.utils;

import static global.constant.GlobalStatic.WEEKLY_NUMBER_SEPARATOR;

import global.exception.ErrorCode;
import global.view.OutputView;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GlobalUtil {

    public static class PurchaseAmountUtil {
        public static BigInteger parsingPurchaseAmount(String input) {
            try {
                return new BigInteger(input);
            } catch (NumberFormatException e) {
                OutputView.printErrorMsgWithReason(ErrorCode.INPUT_SHOULD_BE_PARSING, input);
                throw new NumberFormatException(ErrorCode.INPUT_SHOULD_BE_PARSING.getMsg());
            }
        }
    }

    public static class LottoUtil {
        public static List<Integer> sortingNumbers(List<Integer> numbers) {
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            sortedNumbers.sort(Integer::compareTo);
            return sortedNumbers;
        }
    }

    public static class WeeklyNumberUtil {
        public static List<String> splitWeeklyNumberWithSeparator(String inputWeeklyNumbers) {
            String[] weeklyNumbers = inputWeeklyNumbers.split(WEEKLY_NUMBER_SEPARATOR);
            return new ArrayList<>(List.of(weeklyNumbers));
        }

        public static List<Integer> parsingWeeklyNumbers(List<String> weeklyNumbers) {
            List<Integer> numbers = new ArrayList<>();
            for (String weeklyNumber : weeklyNumbers) {
                try {
                    numbers.add(Integer.parseInt(weeklyNumber));
                } catch (NumberFormatException e) {
                    OutputView.printErrorMsgWithReason(ErrorCode.INPUT_SHOULD_BE_PARSING, weeklyNumber);
                    throw new NumberFormatException(ErrorCode.INPUT_SHOULD_BE_PARSING.getMsg());
                }
            }
            return numbers;
        }
    }

    public static class BonusNumberUtil {
        public static int parsingBonusNumber(String input) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                OutputView.printErrorMsgWithReason(ErrorCode.INPUT_SHOULD_BE_PARSING, input);
                throw new NumberFormatException(ErrorCode.INPUT_SHOULD_BE_PARSING.getMsg());
            }
        }
    }

    public static class PrizeUtil {
        public static String applyPrizeFormat(int prize) {
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            return decimalFormat.format(prize);
        }
    }
}
