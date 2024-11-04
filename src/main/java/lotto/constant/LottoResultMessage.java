package lotto.constant;

public enum LottoResultMessage {
    FIRST(1, "6개 일치 (2,000,000,000원) - %d개\n"),
    SECOND(2, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    THIRD(3, "5개 일치 (1,500,000원) - %d개\n"),
    FOURTH(4, "4개 일치 (50,000원) - %d개\n"),
    FIFTH(5, "3개 일치 (5,000원) - %d개\n");

    private final int rank;
    private final String message;

    LottoResultMessage(int rank, String message) {
        this.rank = rank;
        this.message = message;
    }

    public static LottoResultMessage findByRank(int rank) {
        for (LottoResultMessage resultMessage : values()) {
            if (resultMessage.rank == rank) {
                return resultMessage;
            }
        }
        throw new IllegalStateException("[Error] 해당 순위에 맞는 메시지가 없습니다: " + rank);
    }

    public String get() {
        return message;
    }
}
