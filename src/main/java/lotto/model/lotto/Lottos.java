package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.common.LottoConst;
import lotto.error.ErrorMessage;
import lotto.model.parseLotto.ParseLotto;
import lotto.model.util.GeneraterLotto;

public class Lottos {
    private List<Lotto> lottos;

    private List<Integer> winNumbers;

    private int lottosCount;

    private int bonusNumber;

    private Winstatus winstatus;

    public Lottos(List<String> winNumbersStr, int buyAmount,int bonusNumber) {
        if (validateWinNumberNotNumber(winNumbersStr)) {
            throw new IllegalArgumentException(ErrorMessage.NOTNUMBERWINNUMBERS.getMessage());
        }

        winNumbers = ParseLotto.winNumberStrToInteger(winNumbersStr);
        lottos = new ArrayList<>();
        lottosCount = buyAmount / LottoConst.LOTTOPERAMOUNT.getLottoConst();
        bonusNumber = bonusNumber;
        winstatus = new Winstatus();
    }

    public void generateLotto() {
        GeneraterLotto.generateLotto(lottos, lottosCount);
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    private boolean validateWinNumberNotNumber(List<String> winNumbersStr) {
        try {
            winNumbersStr.stream().map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            return true;
        }

        return false;
    }

    public void lottosSort() {
        for (Lotto lotto : lottos) {
            lotto.numbersSort();
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottosCount() {
        return lottosCount;
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Winstatus getWinstatus() {
        return winstatus;
    }

}
