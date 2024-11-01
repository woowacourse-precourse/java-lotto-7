package model;

import java.util.List;
import validation.Validation;

public class WinningLottoNum {

    List<Integer> winningNums;

    public WinningLottoNum(List<Integer> lottoNums) {
        this.winningNums = lottoNums;
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }
}
