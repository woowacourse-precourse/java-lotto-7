package lotto;

import java.util.ArrayList;
import java.util.List;

public class result {

    private List<Integer> winningNumber;
    private int bonusNum;
    private List<ArrayList<Integer>> lottoNumbers;
    

    public void setNumbers(List<Integer> winningNumber, int bonusNum, List<ArrayList<Integer>> lottoNumbers) {
        this.winningNumber = winningNumber;
        this.bonusNum = bonusNum;
        this.lottoNumbers = lottoNumbers;
    }

}
