package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.view.InputView;

public class LottoController {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBERS = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final int lottoMoney;

    public LottoController(int lottoMoney){
        this.lottoMoney = lottoMoney;
    }
    public void startLotto() {
        generatingRandomLottoNumbers();
        printLottoNumbers();
    }

    public List<Integer> generatingRandomLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBERS, LOTTO_NUMBER_COUNT);
    }

    public void printLottoNumbers(){
        int lottoSetCount = calculateLottoSetCount();
        for (int i=0; i<lottoSetCount; i++){
            List<Integer> lottoNumber = generatingRandomLottoNumbers();
            Collections.sort(lottoNumber);
            //TODO: 출력 메서드 분리하기
            System.out.println(lottoNumber);
        }
    }

    public int calculateLottoSetCount(){
        return lottoMoney / 1000;
    }
}
