package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.common.LottoConst;
import lotto.error.ErrorMessage;
import lotto.model.parseLotto.ParseLotto;

public class Lottos {
    private List<Lotto> lottos;

    private List<Integer> winNumbers;

    private int lottosCount;

    public Lottos(List<String> winNumbersStr, int buyAmount) {
        if (validateWinNumberNotNumber(winNumbersStr)) {
            throw new IllegalArgumentException(ErrorMessage.NOTNUMBERWINNUMBERS.getMessage());
        }

        winNumbers = ParseLotto.winNumberStrToInteger(winNumbersStr);
        lottos = new ArrayList<>();
        lottosCount = buyAmount / LottoConst.LOTTOPERAMOUNT.getLottoConst();

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

}
