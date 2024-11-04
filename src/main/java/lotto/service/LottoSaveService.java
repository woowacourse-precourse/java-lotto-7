package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class LottoSaveService {
    private final String THREE_MATCH = "3";
    private final String FOUR_MATCH = "4";
    private final String FIVE_MATCH = "5";
    private final String FIVE_BONUS_MATCH = "5B";
    private final String SIX_MATCH = "6";
    private final int ZERO = 0;
    private final int THREE = 3;
    private final int FOUR = 4;
    private final int FIVE = 5;
    private final int SIX = 6;
    private Map<String, Integer> lottoMatchCount = new HashMap<>();
    private static final String COMMA_DELIMITER = ",";
    LottoWinningNumber lottoWinningNumber;
    LottoBonusNumber lottoBonusNumber;
    LottoPurchasePrice lottoPurchasePrice;
    Lottos lottos;

    public int buyLottos(String purchasePrice) {
        this.lottoPurchasePrice = new LottoPurchasePrice(Integer.parseInt(purchasePrice));
        return lottoPurchasePrice.getPurchaseCount();
    }

    public int getPurchasePrice() {
        return lottoPurchasePrice.getPurchasePrice();
    }

    public void saveLottos(int lottoCount) {
        int START_INDEX = 0;
        int START_INCLUSIVE = 1;
        int END_EXCLUSIVE = 45;
        int PICK_COUNT = 6;
        TempLottos tempLottos = new TempLottos();
        for (int i = START_INDEX; i < lottoCount; i++) {
            tempLottos.add(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_EXCLUSIVE, PICK_COUNT));
        }
        this.lottos = Lottos.getInstance(tempLottos.getLottoNumbers(), lottoCount);
    }

    public List<List<Integer>> getLottos() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            lottoNumbers.add(lotto.getNumbers());
        }
        return lottoNumbers;
    }


    public void saveWinningLotto(String winningNumber) {
        List<Integer> winningNumbers = Arrays.stream(winningNumber.split(COMMA_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        lottoWinningNumber = LottoWinningNumber.getInstance(winningNumbers);
    }

    public void saveBonusNumber(String bonusNumber) {
        lottoBonusNumber = LottoBonusNumber.getInstance(Integer.parseInt(bonusNumber));
    }


    public void makeDataForReturn() {

        lottoMatchCount.put(THREE_MATCH, ZERO);
        lottoMatchCount.put(FOUR_MATCH, ZERO);
        lottoMatchCount.put(FIVE_MATCH, ZERO);
        lottoMatchCount.put(FIVE_BONUS_MATCH, ZERO);
        lottoMatchCount.put(SIX_MATCH, ZERO);
    }

    public Map<String, Integer> matchLotto() {
        List<Integer> winningNumbers = lottoWinningNumber.getLottoWinningNumbers();
        int bonusNumber = lottoBonusNumber.getBonusNumber();
        int matchedCount = 0;

        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            for (Integer number : numbers) {
                if (winningNumbers.contains(number)) {
                    matchedCount++;
                }
            }
            if (matchedCount == THREE) {
                lottoMatchCount.put(THREE_MATCH, lottoMatchCount.get(THREE_MATCH) + 1);
            } else if (matchedCount == FOUR) {
                lottoMatchCount.put(FOUR_MATCH, lottoMatchCount.get(FOUR_MATCH) + 1);
            } else if (matchedCount == FIVE) {
                if (numbers.contains(bonusNumber)) {
                    lottoMatchCount.put(FIVE_BONUS_MATCH, lottoMatchCount.get(FIVE_BONUS_MATCH) + 1);
                } else {
                    lottoMatchCount.put(FIVE_MATCH, lottoMatchCount.get(FIVE_MATCH) + 1);
                }
            } else if (matchedCount == SIX) {
                lottoMatchCount.put(SIX_MATCH, lottoMatchCount.get(SIX_MATCH) + 1);
            }
        }
        return lottoMatchCount;
    }
}

