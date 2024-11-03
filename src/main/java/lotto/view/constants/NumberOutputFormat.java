package lotto.view.constants;

import java.text.DecimalFormat;

public enum NumberOutputFormat {
    PRIZE_FORMAT(new DecimalFormat("###,###"))
    , PROFIT_RATE_FORMAT(new DecimalFormat("#,##0.0"));

    private final DecimalFormat format;
    NumberOutputFormat(DecimalFormat format) {
        this.format = format;
    }
    public DecimalFormat getFormat() {
        return format;
    }
}
