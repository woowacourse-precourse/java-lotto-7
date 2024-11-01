package lotto.controller;

import lotto.validation.ErrorMessage;
import lotto.model.LottoModel;
import lotto.view.LottoView;

import java.util.*;

public class LottoController {
    private final LottoModel lottoModel = new LottoModel();
    private final LottoView lottoView = new LottoView();


    public void start() {
        int lottoCount = getLottoCount();
        lottoView.output.lottoCount(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            lottoModel.makeRandomLottoNumbers();
            lottoView.output.lottoNumber(lottoModel.getLottoNumbers(i));
        }

        List<Integer> winningNumber = getWinningNumber();

        int bonusNumber = getBonusNumber(winningNumber);

        //당첨 로직 구현
        int[] ans = new int[5];
        for (int i = 0; i < lottoCount; i++) {
            int total = 0;
            for (Integer winVal : winningNumber) {
                if (lottoModel.getLottoNumbers(i).contains(winVal)) {
                    total++;
                }
            }
            if (total == 3) {
                ans[0]++;
            }
            if (total == 4) {
                ans[1]++;
            }
            if (total == 5) {
                if (lottoModel.getLottoNumbers(i).contains(bonusNumber)) {
                    ans[3]++;
                    continue;
                }
                ans[2]++;
            }
            if (total == 6) {
                ans[4]++;
            }
        }

        lottoView.output.winningResult(ans, getRate(lottoCount, ans));
    }

    private static double getRate(int lottoCount, int[] ans) {
        int price = lottoCount * 1000;
        long sum = 0;
        sum = ans[0] * 5000L + ans[1] * 50000L + ans[2] * 1500000L
                + ans[3] * 30000000L + ans[4] * 2000000000L;
        double rate = ((double)sum / price) * 100;
        return rate;
    }

    int getLottoCount() {
        int price = 0;
        while (true) {
            try {
                try {
                    price = Integer.parseInt(lottoView.input.price());
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
                }
                if (price <= 0) {
                    throw new IllegalArgumentException(ErrorMessage.NEGATIVE_OR_ZERO.getMessage());
                }
                if (price % 1000 != 0) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return price / 1000;
    }

    List<Integer> getWinningNumber() {
        List<Integer> winningNumber = new ArrayList<>();
        while (true) {
            String[] inputWinningNumber = lottoView.input.winningNumber().split(",");
            try {
                if (inputWinningNumber.length != 6) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getMessage());
                }
                for (String strNumber : inputWinningNumber) {
                    int number;
                    try {
                        number = Integer.parseInt(strNumber);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
                    }
                    if (number < 1 || number > 45) {
                        throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
                    }
                    winningNumber.add(number);
                }
                if (new HashSet<>(winningNumber).size() != 6) {
                    throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumber;
    }

    private int getBonusNumber(List<Integer> winningNumber) {
        int bonusNumber;
        while (true) {
            try {
                try {
                    bonusNumber = Integer.parseInt(lottoView.input.bonusNumber());
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
                }
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
                }
                if (winningNumber.contains(bonusNumber)) {
                    throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WITH_WIN_NUMBER.getMessage());
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }
}
