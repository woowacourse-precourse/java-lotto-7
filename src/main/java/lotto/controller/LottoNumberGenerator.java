package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.handler.LottoResultHandler;

public class LottoNumberGenerator {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBERS = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final LottoResultHandler resultPrinter;

    public LottoNumberGenerator(){
        this.resultPrinter = new LottoResultHandler();
    }

    public List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBERS, LOTTO_NUMBER_COUNT);
    }

    public List<List<Integer>> generateLottoSet(int lottoSetCount) {
        List<List<Integer>> lottoSets = new ArrayList<>();
        resultPrinter.printLottoSetCount(lottoSetCount);
        for (int i = 0; i < lottoSetCount; i++) {
            List<Integer> lottoNumber = generateRandomLottoNumbers();
            Collections.sort(lottoNumber);
            lottoSets.add(lottoNumber);
            resultPrinter.printLottoNumbers(lottoNumber);
        }
        return lottoSets;
    }
}
