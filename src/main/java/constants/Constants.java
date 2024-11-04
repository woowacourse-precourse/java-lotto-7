package constants;

import java.text.DecimalFormat;

public class Constants {

    private Constants() {
        throw new IllegalArgumentException("인스턴스화 금지");
    }

    public static final int LOTTO_SIZE = 6;
    public static final DecimalFormat AMOUNT_NOTATION = new DecimalFormat("#,###.##");
}
