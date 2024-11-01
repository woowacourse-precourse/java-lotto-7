package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.*;
import lotto.domain.Lotto;
import lotto.validator.LottoInputValidator;
import lotto.io.*;

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
    private final LottoInputValidator lottoInputValidator;

    private LottoService(LottoConfig config) {
        this.input = config.input();
        this.output = config.output();
        this.lottoInputValidator = config.lottoInputValidator();
    }

    public static LottoService getInstance(LottoConfig config) {
        if(service== null)
            service = new LottoService(config);

        return service;
    }

    public List<Lotto> buyLottos() {
        int money = inputMoney();
        int amountOfLottos = money / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        output.completePurchase(amountOfLottos);

        for(int i = 0; i < amountOfLottos; i++)
            lottos.add(issueLotto());

        return lottos;
    }

    private int inputMoney() {

        int money = -1;

        while(money == -1) {
            try {
                money = lottoInputValidator.checkInputMoney(input.inputMoney());
            } catch(IllegalArgumentException e) {
                continue;
            }
        }

        return money;
    }

    private Lotto issueLotto() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER,
                END_NUMBER, AMOUNT_OF_LOTTO_NUMBERS);

        // deepcopy
        numbers = numbers.stream().sorted().collect(Collectors.toList());

        Lotto lotto = new Lotto(numbers);

        output.printLotto(lotto);

        return lotto;
    }
}
