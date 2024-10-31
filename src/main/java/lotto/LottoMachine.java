package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import io.OutPutHandler;
import io.lotto.InputLottoHandler;
import io.lotto.OutPutLottoHandler;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final OutPutHandler outPutHandler = new OutPutHandler();
    private final InputLottoHandler inputLottoHandler = new InputLottoHandler();
    private final OutPutLottoHandler outPutLottoHandler = new OutPutLottoHandler();

    public void run() {
        boolean validInput = false;
        int price = initPrice(validInput);
        List<Lotto> lottos = createLottoNumbersByCount(getBuyCount(price));
        outPutLottoHandler.showLottos(lottos);

        List<Integer> winningNumber = initWinningNumber(validInput);
        int bonusNumber = initBonusNumber(validInput);



    }

    private List<Lotto> createLottoNumbersByCount(int buyCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottos.add(new Lotto(createLottoNumbers()));
        }
        return lottos;
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int initPrice(boolean validInput) {
        int price = 0;
        while (!validInput) {
            try {
                outPutHandler.showInputPriceMessage();
                price = inputLottoHandler.getPrice();
                outPutLottoHandler.showOutputBuyCountMessage(getBuyCount(price));
                validInput = true;
                return price;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return price;
    }

    public List<Integer> initWinningNumber(boolean validInput) {
        List<Integer> winningNumber = null;
        while (!validInput) {
            try {
                outPutHandler.showInputWinningNumberMessage();
                winningNumber = inputLottoHandler.getWinningNumber();
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumber;
    }

    public int initBonusNumber(boolean validInput) {
        int bonusNumber = 0;
        while (!validInput) {
            try {
                outPutHandler.showInputBonusNumberMessage();
                bonusNumber = inputLottoHandler.getBonusNumber();
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    public int getBuyCount(int price) {
        return price / 1000;
    }
}
