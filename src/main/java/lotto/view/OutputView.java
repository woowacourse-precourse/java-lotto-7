package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView implements UserOutput{
    @Override
    public void outputLottoCount(int lottoCount) {
        System.out.println(String.format("%d개를 구매했습니다."));
    }

    @Override
    public void outputStatistics(List<List<Integer>> lottoNumbers) {
        for(List<Integer> lottoNumber : lottoNumbers){
            System.out.println(lottoNumber.toString());
        }
    }
}
