package lotto.view;

public enum WinnerPrice {


    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5000, "3개 일치 (5,000원) -"),
    BOOM(0, 0, "");


    private final int countMatch;
    private final int prize;
    private final String outputMessage;

    WinnerPrice(int countMatch, int prize, String outputMessage) {
        this.countMatch = countMatch;
        this.prize = prize;
        this.outputMessage = outputMessage;
    }

    public int getCountMatch() {
        return this.countMatch;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getOutputMessage() {
        return this.outputMessage;
    }

}
