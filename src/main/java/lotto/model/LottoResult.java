package lotto.model;

public class LottoResult {
    private int firstPlaceCount;  // 1등 당첨 횟수
    private int secondPlaceCount; // 2등 당첨 횟수
    private int thirdPlaceCount;  // 3등 당첨 횟수
    private int fourthPlaceCount; // 4등 당첨 횟수
    private int fifthPlaceCount;  // 5등 당첨 횟수
    private int noWinCount;       // 꽝 횟수

    public LottoResult() {
        this.firstPlaceCount = 0;
        this.secondPlaceCount = 0;
        this.thirdPlaceCount = 0;
        this.fourthPlaceCount = 0;
        this.fifthPlaceCount = 0;
        this.noWinCount = 0;
    }
}