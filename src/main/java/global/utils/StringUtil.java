package global.utils;

import static lotto.constant.LottoStatic.WEEKLY_NUMBER_SEPARATOR;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    public static class WeeklyNumber {

        public static List<String> splitWeeklyNumberWithSeparator(String inputWeeklyNumbers) {
            String[] weeklyNumbers = inputWeeklyNumbers.split(WEEKLY_NUMBER_SEPARATOR);
            return new ArrayList<>(List.of(weeklyNumbers));
        }

        public static List<Integer> parsingWeeklyNumbers(List<String> weeklyNumbers) {
            List<Integer> numbers = new ArrayList<>();

            for (String weeklyNumber : weeklyNumbers) {
                numbers.add(Integer.parseInt(weeklyNumber));
            }

            return numbers;
        }

    }

}
