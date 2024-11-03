package lotto.model;

public enum MatchComment {
    FIFTH_LOTTO_MESSAGE("3개 일치 (5,000원) - %d개"),
    FOURTH_LOTTO_MESSAGE("4개 일치 (50,000원) - %d개"),
    THIRD_LOTTO_MESSAGE("5개 일치 (1,500,000원) - %d개"),
    SECOND_LOTTO_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_LOTTO_MESSAGE("6개 일치 (2,000,000,000원) - %d개");

    private final String comment;

    MatchComment(String comment) {
        this.comment = comment;
    }

    public String getComment(int value) {
        return String.format(comment, value);
    }
}
