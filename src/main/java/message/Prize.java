package message;

public enum Prize {

    MISS(0, "", 0L),
    THREE_MATCHES(3, "3개 일치 (5,000원) - ", 5_000L),
    FOUR_MATCHES(4, "4개 일치 (50,000원) - ", 50_000L),
    FIVE_MATCHES(5, "5개 일치 (1,500,000원) - ", 1_500_000L),
    FIVE_BONUS_MATCHES(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000L),
    ALL_MATCHES(6, "6개 일치 (2,000,000,000원) - ", 2_000_000_000L);

    private final Integer matches;
    private final String result;
    private final Long money;

    Prize(Integer matches, String result, Long money) {
        this.matches = matches;
        this.result = result;
        this.money = money;
    }

    public Integer getMatches() {
        return matches;
    }

    public String getResult() {
        return result;
    }

    public Long getMoney() {
        return money;
    }
}
