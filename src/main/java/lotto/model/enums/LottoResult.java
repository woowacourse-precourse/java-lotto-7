package lotto.model.enums;

public enum LottoResult {

    FIRST("6개 일치 (2,000,000,000원) - %d개", 2_000_000_000, 0),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30_000_000, 0),
    THIRD("5개 일치 (1,500,000원) - %d개", 1_500_000, 0),
    FOURTH("4개 일치 (50,000원) - %d개", 50_000, 0),
    FIFTH("3개 일치 (5,000원) - %d개", 5_000, 0);


    private final String message;
    private final Integer prizeMoney;
    private Integer count;

    LottoResult(String message, Integer prizeMoney, Integer count) {
        this.message = message;
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public Integer getCount(){
        return count;
    }

    public String getMessage(){
        return message;
    }

    public Integer getPrizeMoney(){
        return prizeMoney;
    }

}
