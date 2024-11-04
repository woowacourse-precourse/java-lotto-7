package Common;

import java.text.DecimalFormat;

public class Formatter {
    private Formatter() {}
    public static String currencyFormatted(int num) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(num);
    }
}
