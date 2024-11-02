package lotto;

public class LottoScoreboard {
    private int threeMatches;
    private int fourMatches;
    private int fiveMatches;
    private int fiveBonusMatches;
    private int sixMatches;

    public void incrementThreeMatches() { threeMatches++; }
    public void incrementFourMatches() { fourMatches++; }
    public void incrementFiveMatches() { fiveMatches++; }
    public void incrementFiveBonusMatches() { fiveBonusMatches++; }
    public void incrementSixMatches() { sixMatches++; }

    // 결과 출력 메소드
    public void printScoreboard() {
        System.out.println(threeMatches + "개 일치 (5,000원) - " + threeMatches + "개");
        System.out.println(fourMatches + "개 일치 (50,000원) - " + fourMatches + "개");
        System.out.println(fiveMatches + "개 일치 (1,500,000원) - " + fiveMatches + "개");
        System.out.println(fiveBonusMatches + "개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveBonusMatches + "개");
        System.out.println(sixMatches + "개 일치 (2,000,000,000원) - " + sixMatches + "개");
    }
}

