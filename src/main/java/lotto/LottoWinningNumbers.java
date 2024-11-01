package lotto;

public enum LottoWinningNumbers {

    WinnningNumOne(4),
    WinningNumTwo(12),
    WinningNumThree(27),
    WinningNumFour(41),
    WinningNumFive(7),
    WinningNumSix(35),
    WinningNumBonus(17);

    private final int winningNum;

    LottoWinningNumbers(int winningNum) {
        this.winningNum=winningNum;
    }

    public int getValue() {
        return winningNum;
    }
 }
