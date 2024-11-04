package lotto;

public enum LottoRank {
    NONE(0),
    FIFTH(5_000),
    FOURTH(50_000),
    THIRD(1_500_000),
    SECOND(30_000_000),
    FIRST(2_000_000_000);

    private final int prize;

    LottoRank(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank getRank(int matchCnt, boolean matchBonus) {
        if (matchCnt == 6) return FIRST;
        if (matchCnt == 5 && matchBonus) return SECOND;
        if (matchCnt == 5) return THIRD;
        if (matchCnt == 4) return FOURTH;
        if (matchCnt == 3) return FIFTH;
        return NONE;
    }

    public String chooseText(LottoRank rank, int cnt) {
        if (rank == FIRST) return String.format("%s (%,d원) - %d개", "6개 일치", prize, cnt);
        if (rank == SECOND) return String.format("%s (%,d원) - %d개", "5개 일치, 보너스 볼 일치", prize, cnt);
        if (rank == THIRD) return String.format("%s (%,d원) - %d개", "5개 일치", prize, cnt);
        if (rank == FOURTH) return String.format("%s (%,d원) - %d개", "4개 일치", prize, cnt);
        if (rank == FIFTH) return String.format("%s (%,d원) - %d개", "3개 일치", prize, cnt);
        return "";
    }
}
