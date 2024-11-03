package lotto.Domain;

import lotto.Constants.Prize;

/**
 * 로또의 당첨 정보를 저장하는 클래스
 */
public class LottoResult {
    private int firstPrizeCnt;
    private int secondPrizeCnt;
    private int thirdPrizeCnt;
    private int fourthPrizeCnt;
    private int fifthPrizeCnt;

    public LottoResult() {
        this.firstPrizeCnt = 0;
        this.secondPrizeCnt = 0;
        this.thirdPrizeCnt = 0;
        this.fourthPrizeCnt = 0;
        this.fifthPrizeCnt = 0;
    }

    public long calculateTotalPrize() {
        return (long) firstPrizeCnt * Prize.FIRST.getPrize()
                + (long) secondPrizeCnt * Prize.SECOND.getPrize()
                + (long) thirdPrizeCnt * Prize.THIRD.getPrize()
                + (long) fourthPrizeCnt * Prize.FOURTH.getPrize()
                + (long) fifthPrizeCnt * Prize.FIFTH.getPrize();
    }

    public void addFirstPrizeCnt() {
        this.firstPrizeCnt++;
    }

    public void addSecondPrizeCnt() {
        this.secondPrizeCnt++;
    }

    public void addThirdPrizeCnt() {
        this.thirdPrizeCnt++;
    }

    public void addFourthPrizeCnt() {
        this.fourthPrizeCnt++;
    }

    public void addFifthPrizeCnt() {
        this.fifthPrizeCnt++;
    }

    public int getFirstPrizeCnt() {
        return firstPrizeCnt;
    }

    public int getSecondPrizeCnt() {
        return secondPrizeCnt;
    }

    public int getThirdPrizeCnt() {
        return thirdPrizeCnt;
    }

    public int getFourthPrizeCnt() {
        return fourthPrizeCnt;
    }

    public int getFifthPrizeCnt() {
        return fifthPrizeCnt;
    }
}
