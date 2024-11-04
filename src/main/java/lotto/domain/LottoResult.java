package lotto.domain;

public class LottoResult {
    private int threeNumberMatchCount;
    private int fourNumberMatchCount;
    private int fiveNumberMatchCount;
    private int fiveNumberAndBonusMatchCount;
    private int sixNumberMatchCount;

    public LottoResult() {
        this.threeNumberMatchCount = 0;
        this.fourNumberMatchCount = 0;
        this.fiveNumberMatchCount = 0;
        this.fiveNumberAndBonusMatchCount = 0;
        this.sixNumberMatchCount = 0;
    }

    public void updateLottoResult(final int matchingCount, final boolean isBonus) {
        if (matchingCount == 3) {
            threeNumberMatchCount += 1;
        }
        if (matchingCount == 4) {
            fourNumberMatchCount += 1;
        }
        if (matchingCount == 5 && !isBonus) {
            fiveNumberMatchCount += 1;
        }
        if (matchingCount == 5 && isBonus) {
            fiveNumberAndBonusMatchCount += 1;
        }
        if (matchingCount == 6) {
            sixNumberMatchCount += 1;
        }
    }
    
    public void printLottoWinningStatistics() {
        System.out.println("3개 일치 (5,000원) - " + threeNumberMatchCount +"개");
        System.out.println("4개 일치 (50,000원) - " + fourNumberMatchCount +"개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveNumberMatchCount +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveNumberAndBonusMatchCount +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixNumberMatchCount +"개");
    }
}
