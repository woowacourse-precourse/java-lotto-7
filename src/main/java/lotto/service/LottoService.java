package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.*;
import lotto.io.*;
import lotto.domain.*;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int AMOUNT_OF_LOTTO_NUMBERS = 6;

    private static LottoService service;

    private final Input input;
    private final Output output;

    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    private LottoService(LottoConfig config) {
        this.input = config.input();
        this.output = config.output();
    }

    public static LottoService getInstance(LottoConfig config) {
        if(service== null)
            service = new LottoService(config);

        return service;
    }

    public List<Lotto> buyLottos() {

        AmountOfLottos amountOfLottos = input.inputMoney(LOTTO_PRICE);
        output.completePurchase(amountOfLottos.getAmount());

        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < amountOfLottos.getAmount(); i++)
            lottos.add(issueLotto());

        return lottos;
    }

    public void setWinningNumbers() {

        winningNumbers = input.inputWinningNumbers();
    }


    public void setBonusNumber() {

        bonusNumber = input.inputBonusNumber(winningNumbers);
    }

    public void calculateResult(List<Lotto> lottos) {

        ResultCount resultCount = new ResultCount();

        for(Lotto lotto : lottos)
            compareLotto(lotto, resultCount);

        output.printWinningStatistics(resultCount, LOTTO_PRICE);
    }

    private Lotto issueLotto() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER,
                END_NUMBER, AMOUNT_OF_LOTTO_NUMBERS);
        numbers = numbers.stream().sorted().collect(Collectors.toList());

        Lotto lotto = null;
        try{
            lotto = new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            output.printMsg(e.getMessage());
        }
        output.printLotto(lotto);

        return lotto;
    }

    private void compareLotto(Lotto lotto, ResultCount resultCount) {

        int cnt = 0;
        boolean bonus = false;
        for(int n : lotto.getNumbers()) {
            if(bonusNumber.getBonusNumber() == n) {
                bonus = true;
                continue;
            }
            if(winningNumbers.getNumbers().contains(n))
               cnt++;
        }

        resultCount.check(cnt, bonus);
    }
}
