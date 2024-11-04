package lotto;

import lotto.EnumManagement.OutputViewEnum;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutputView {
    private List<List<Integer>> boughtLottoNumbers;

    public void outputLottoNumbers() {
        System.out.println(boughtLottoNumbers.size() + OutputViewEnum.BOUGHT_LOTTO_COUNT.getMessage());
        for (List<Integer> boughtLottoNumber : boughtLottoNumbers) {
            System.out.println(boughtLottoNumber);
        }
    }

    private List<Integer> randomNumber(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    public void generateLotto(int lottoCount){
        List<List<Integer>> lottos = new ArrayList<>();
        for(int i = 0 ; i < lottoCount ; i++) {
            List<Integer> lottoNumbers = randomNumber();
            lottoNumbers.sort(Integer::compareTo);
            lottos.add(lottoNumbers);
        }
        this.boughtLottoNumbers = lottos;
    }

    public void lottoWinOutput(List<Integer> lottoMatchTable){
        System.out.println(OutputViewEnum.WINNING_STAT.getMessage());
        for(int i = 0 ; i < lottoMatchTable.size() ; i++) {
            System.out.println(OutputViewEnum.values()[i].getMessage() + lottoMatchTable.get(i) + OutputViewEnum.COUNT.getMessage());
        }
    }

    public void lottoReturnRateOutput(double lottoReturnRate){
        DecimalFormat df = new DecimalFormat(OutputViewEnum.LOTTO_RETURN_RATE_FORMAT.getMessage());
        String lottoReturnRateOutput = df.format(lottoReturnRate);
        System.out.println(OutputViewEnum.LOTTO_RETURN_RATE.getMessage() + lottoReturnRateOutput + OutputViewEnum.PERCENT.getMessage());
    }

    public List<List<Integer>> getBoughtLottoNumbers() {
        return boughtLottoNumbers;
    }
}
