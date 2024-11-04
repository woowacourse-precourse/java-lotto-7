package lotto.dto;

import java.util.List;

public class WinningNumsDto {
    private final List<Integer> winningNums;
    private final int bonusNum;

    public WinningNumsDto(List<Integer> winningNums, int bonusNum) {
        this.winningNums = winningNums;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
