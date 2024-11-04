package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class LottoSaveService {
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
        lottoMatchCount.put("3", 0);
        lottoMatchCount.put("4", 0);
        lottoMatchCount.put("5", 0);
        lottoMatchCount.put("5B", 0);
        lottoMatchCount.put("6", 0);
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
            if (matchedCount == 3) {
                lottoMatchCount.put("3", lottoMatchCount.get("3") + 1);
            } else if (matchedCount == 4) {
                lottoMatchCount.put("4", lottoMatchCount.get("4") + 1);
            } else if (matchedCount == 5) {
                if (numbers.contains(bonusNumber)) {
                    lottoMatchCount.put("5B", lottoMatchCount.get("5B") + 1);
                } else {
                    lottoMatchCount.put("5", lottoMatchCount.get("5") + 1);
                }
            } else if (matchedCount == 6) {
                lottoMatchCount.put("6", lottoMatchCount.get("6") + 1);
            }
        }
        return lottoMatchCount;
    }
}

