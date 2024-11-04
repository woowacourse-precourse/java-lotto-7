package lotto.domain.lotto.constants;

public enum LottoFormat {
    PREFIX_BRACKET("["),
    SUFFIX_BRACKET("]"),
    DELIMITER_WITH_SPACE(", "),
    DELIMITER(",");

    private final String format;

    LottoFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

}
