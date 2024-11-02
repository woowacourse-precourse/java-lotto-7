package enums;

public enum InputRegix {
    PURCHASE("^[1-9]\\d*(000)$"),
    LOTTO("^([1-9]|[1-3][0-9]|[4][0-5])$");

    private final String regix;

    InputRegix(String regix) {
        this.regix = regix;
    }

    public String getRegix() {
        return regix;
    }
}
