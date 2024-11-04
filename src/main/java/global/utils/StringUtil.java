package global.utils;

import static global.constant.GlobalStatic.WEEKLY_NUMBER_SEPARATOR;

import global.exception.ErrorCode;
import global.view.OutputView;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    public static class PurchaseAmount {
        public static BigInteger parsingPurchaseAmount(String input) {
            try {
                return new BigInteger(input);
            } catch (NumberFormatException e) {
                OutputView.printErrorMsgWithReason(ErrorCode.INPUT_SHOULD_BE_PARSING, input);
                throw new NumberFormatException(ErrorCode.INPUT_SHOULD_BE_PARSING.getMsg());
            }
        }
    }

    public static class WeeklyNumber {
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

    public static class BonusNumber {
        public static int parsingBonusNumber(String input) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                OutputView.printErrorMsgWithReason(ErrorCode.INPUT_SHOULD_BE_PARSING, input);
                throw new NumberFormatException(ErrorCode.INPUT_SHOULD_BE_PARSING.getMsg());
            }
        }
    }

    public static class Prize {
        public static String applyPrizeFormat(int prize) {
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            return decimalFormat.format(prize);
        }
    }
}
