package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.*;
import lotto.io.*;
import lotto.domain.*;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int AMOUNT_OF_LOTTO_NUMBERS = 6;

    private static LottoService service;

    private final Input input;
    private final Output output;

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

        AmountOfLottos amountOfLottos = input.inputMoney();
        output.completePurchase(amountOfLottos.getAmount());

        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < amountOfLottos.getAmount(); i++)
            lottos.add(issueLotto());

        return lottos;
    }

    /*
    public void setWinningNumbers() {

        List<Integer> tempWinningNumbers = Arrays.stream(input.inputWinningNumbers()).map(Integer::parseInt).toList();
        try{
            lottoInputValidator.checkWinningNumbers(tempWinningNumbers);
            winningNumbers = tempWinningNumbers;
            System.out.println(winningNumbers);
        } catch(IllegalArgumentException e) {
            setWinningNumbers();
        }
    }
    */

    public void setBonusNumber() {

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
}
