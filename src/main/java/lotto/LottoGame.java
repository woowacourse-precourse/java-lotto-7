package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LottoGame {
    private Lotto[] purchasedLottos;
    private Lotto winningLotto;
    private int bonusNumber;
    private int lottoCount;

    public LottoGame() {
        purchasedLottos = null;
        winningLotto = null;
        bonusNumber = 0;
        lottoCount = 0;
    }

    public void purchaseLotto(Money money) {
        if (money.getAmount() % LottoRegulation.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(
                    MessageFormat.format("[ERROR] 구입금액은 {0}원 단위로 입력해야 합니다.", LottoRegulation.LOTTO_PRICE));
        }
        lottoCount = money.getAmount() / LottoRegulation.LOTTO_PRICE;
        purchasedLottos = new Lotto[lottoCount];
    }

    public void assignRandomNumberToLotto() {
        for (int i = 0; i < purchasedLottos.length; i++) {
            List<Integer> randomLottoNumbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(
                            LottoRegulation.LOTTO_NUMBER_MIN,
                            LottoRegulation.LOTTO_NUMBER_MAX,
                            LottoRegulation.LOTTO_NUMBERS_COUNT
                    ));
            purchasedLottos[i] = new Lotto(randomLottoNumbers);
        }
    }

    public void prettyPrintPurchasedLottos() {
        System.out.println(MessageFormat.format("{0}개를 구매했습니다.", lottoCount));
        for (Lotto lotto : purchasedLottos) {
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }

    public void assignWinningLotto(String numbersInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumber : numbersInput.split(",")) {
            winningNumber = winningNumber.strip();
            try {
                winningNumbers.add(Integer.parseInt(winningNumber));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(MessageFormat.format(
                        "[ERROR] 콤마로 구분된 {0}개의 로또 번호를 입력하세요.",
                        LottoRegulation.LOTTO_NUMBERS_COUNT
                ));
            }
        }
        winningLotto = new Lotto(winningNumbers);
    }

    public void assignBonusNumber(String bonusNumberInput) {
        String errorMessage = MessageFormat.format(
                "[ERROR] 보너스 번호는 당첨 번호가 아닌 {0} 이상 {1} 이하의 정수여야 합니다.",
                LottoRegulation.LOTTO_NUMBER_MIN, LottoRegulation.LOTTO_NUMBER_MAX
        );
        try {
            bonusNumber = Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
        if (winningLotto.getNumbers().contains(bonusNumber) || !(Lotto.inRange(bonusNumber))) {
            bonusNumber = 0;
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public Lotto[] getPurchasedLottos() {
        return purchasedLottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoRank compareWithWinningLotto(Lotto userLotto) {
        HashSet<Integer> commonNumbers = new HashSet<>(userLotto.getNumbers());
        commonNumbers.retainAll(winningLotto.getNumbers());

        int matchCount = commonNumbers.size();
        boolean matchBonusNumber = userLotto.getNumbers().contains(bonusNumber);

        for (LottoRank rank : LottoRank.values()) {
            if ((rank.getMatchCount() == matchCount) &&
                    (rank.isMatchBonusNumber() == matchBonusNumber)) {
                return rank;
            }
        }
        return LottoRank.LOTTO_RANK_NONE;
    }
}
