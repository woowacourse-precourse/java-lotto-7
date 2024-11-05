package lotto.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.ValidatorUtil;

public class CommonUtil {

    public static Integer stringToInteger(String input) {
        ValidatorUtil.validateNumericInput(input);
        return Integer.valueOf(input);
    }

    public static List<Integer> splitToList(String input) {
        return Arrays.stream(input.split(","))
                .map(CommonUtil::stringToInteger)
                .collect(Collectors.toList());
    }

    public static String formatToSingleDecimalPlace(double profitRate) {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(profitRate);
    }
}
