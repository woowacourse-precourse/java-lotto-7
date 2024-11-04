package lotto.type;

public enum WinType {

    FIRST("1등", "6개 일치", 2_000_000_000),
    SECOND("2등", "5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD("3등", "5개 일치", 1_500_000),
    FOURTH("4등", "4개 일치", 50_000),
    FIFTH("5등", "3개 일치", 5_000);

    private final String text;
    private final String description;
    private final long lottoWinnings;

    WinType(String text, String description, long lottoWinnings) {
        this.text = text;
        this.description = description;
        this.lottoWinnings = lottoWinnings;
    }

    public String getDescription() {
        return description;
    }

    public long getLottoWinnings() {
        return lottoWinnings;
    }
}
