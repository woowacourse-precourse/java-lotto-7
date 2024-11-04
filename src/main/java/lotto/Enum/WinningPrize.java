package lotto.Enum;

public enum WinningPrize {
    FIFTH(3,"3개 일치 (5,000원) - %d개", 5000L),
    FOURTH(2,"4개 일치 (50,000원) - %d개", 50000L),
    THIRD(13,"5개 일치 (1,500,000원) - %d개", 1500000L),
    SECOND(1,"5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30000000L),
    FIRST(0,"6개 일치 (2,000,000,000원) - %d개", 2000000000L);

    private final int matchNumber;
    private final String message;
    private final long prizeMoney;

    WinningPrize(int matchNumber, String message, long prizeMoney) {
        this.matchNumber = matchNumber;
        this.message = message;
        this.prizeMoney = prizeMoney;
    }

    public String getMessage() {
        return message;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public static String getNameByMatchNumber(int matchNumber){
        String name = "";
        for (WinningPrize winningPrize : WinningPrize.values()) {
            if(matchNumber == winningPrize.getMatchNumber()) {
                name = winningPrize.name();
            }
        }
        return name;
    }
}
