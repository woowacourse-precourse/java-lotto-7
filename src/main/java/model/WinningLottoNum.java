package model;

import java.util.List;
import validation.Validation;

public class WinningLottoNum {
    List<Integer> lottoNums;
    public WinningLottoNum(List<Integer> lottoNums){
        this.lottoNums = lottoNums;
    }

    public List<Integer> getLottoNums(){
        return lottoNums;
    }
}
