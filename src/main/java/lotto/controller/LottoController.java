package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBERS = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final int lottoMoney;

    public LottoController(int lottoMoney){
        this.lottoMoney = lottoMoney;
    }
    public void startLotto() {
        generateRandomLottoNumbers();
        generateLottoSet();
    }

    public List<Integer> generateRandomLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBERS, LOTTO_NUMBER_COUNT);
    }

    public void generateLottoSet(){
        int lottoSetCount = calculateLottoSetCount();
        printLottoSetCount(lottoSetCount);
        for (int i=0; i<lottoSetCount; i++){
            List<Integer> lottoNumber = generateRandomLottoNumbers();
            Collections.sort(lottoNumber);
            printLottoNumbers(lottoNumber);
        }
    }

    public int calculateLottoSetCount(){
        return lottoMoney / 1000;
    }

    public void printLottoSetCount(int lottoSetCount) {
        ResultView.printLottoSetCount(lottoSetCount);
    }

    public void printLottoNumbers(List<Integer> lottoNumber){
        ResultView.printLottoNumbers(lottoNumber);
    }
}