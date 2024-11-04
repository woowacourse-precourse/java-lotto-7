package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import io.OutPutHandler;
import io.lotto.InputLottoHandler;
import io.lotto.OutPutLottoHandler;
import lotto.type.WinType;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int COUNT = 6;
    private final OutPutHandler outPutHandler = new OutPutHandler();
    private final InputLottoHandler inputLottoHandler = new InputLottoHandler();
    private final OutPutLottoHandler outPutLottoHandler = new OutPutLottoHandler();

    public void run() {
        boolean validInput = false;

        int price = initPrice(validInput);
        List<Lotto> lottos = createLottoNumbersByCount(getBuyCount(price));
        outPutLottoHandler.showLottos(lottos);

        List<Integer> winningNumbers = initWinningNumbers(validInput);
        int bonusNumber = initBonusNumber(validInput, winningNumbers);

        User user = checkLottos(lottos, winningNumbers, bonusNumber, new User());

        outPutLottoHandler.showTotalResult(user);
        outPutLottoHandler.showProfitRate(price, user.getTotalLottoWinnings());
    }

    public User checkLottos(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, User user) {
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto, winningNumbers);
            setUserWinTypeBy(lotto, matchCount, bonusNumber, user);
        }
        return user;
    }

    public void setUserWinTypeBy(Lotto lotto, int matchCount, int bonusNumber, User user) {
        if(matchCount == 6) {
            user.updateRecordWin(WinType.FIRST);
        }
        if(matchCount == 5) {
            matchBonusNumber(lotto, bonusNumber, user);
        }
        if(matchCount == 4) {
            user.updateRecordWin(WinType.FOURTH);
        }
        if(matchCount == 3) {
            user.updateRecordWin(WinType.FIFTH);
        }
    }

    public int getMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        int match = 0;
        for (Integer i : winningNumbers) {
            for (Integer number : lotto.getNumbers()) {
                match = isMatchNumber(i, number, match);
            }
        }
        return match;
    }

    private int isMatchNumber(Integer i, Integer number, int match) {
        if(number.equals(i)) {
            match++;
        }
        return match;
    }

    public void matchBonusNumber(Lotto lotto, int bonusNumber, User user) {
        for (Integer number : lotto.getNumbers()) {
            if(number.equals(bonusNumber)) {
                user.updateRecordWin(WinType.SECOND);
                return;
            }
        }
        user.updateRecordWin(WinType.THIRD);
    }

    public List<Lotto> createLottoNumbersByCount(int buyCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottos.add(new Lotto(createLottoNumbers()));
        }
        return lottos;
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);
        return numbers.stream().sorted().toList();
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

    public List<Integer> initWinningNumbers(boolean validInput) {
        List<Integer> winningNumbers = null;
        while (!validInput) {
            try {
                outPutHandler.showInputWinningNumbersMessage();
                winningNumbers = inputLottoHandler.getWinningNumbers();
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }

    public int initBonusNumber(boolean validInput, List<Integer> winningNumbers) {
        int bonusNumber = 0;
        while (!validInput) {
            try {
                outPutHandler.showInputBonusNumberMessage();
                bonusNumber = inputLottoHandler.getBonusNumber(winningNumbers);
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
