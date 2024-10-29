package lotto.controller;

import lotto.model.LottoModel;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    private final LottoModel lottoModel = new LottoModel();
    private final LottoView lottoView = new LottoView();


    public void start() {
        int lottoCount = getLottoCount(lottoView.input.price());
        lottoView.output.lottoCount(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            lottoView.output.lottoNumber(lottoModel.getLottoNumbers(i));
        }

        String[] inputWinningNumber = lottoView.input.winningNumber().split(",");
        List<Integer> winningNumber = getWinningNumber(inputWinningNumber);

        String inputBonusNumber = lottoView.input.bonusNumber();
        int bonusNumber = getBonusNumber(inputBonusNumber);

        //당첨 로직 구현
        int[] ans = new int[5];
        for (int i = 0; i < lottoCount; i++) {
            System.out.println("당첨 로직");
            System.out.println(lottoModel.getLottoNumbers(i));
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
            System.out.println(Arrays.toString(ans));
            System.out.println("total = " + total + " bonus = " + bonusNumber);
        }

        //수익률 로직 구현

        lottoView.output.winningResult(ans);
    }

    private int getLottoCount(String inputPrice) {
        int price;
        try {
            price = Integer.parseInt(inputPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 문자열은 입력 불가합니다.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("0 이하의 수는 입력할 수 없습니다.");
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("가격은 1000원 단위로 입력 가능합니다.");
        }
        return price / 1000;
    }

    private List<Integer> getWinningNumber(String[] inputWinningNumber) {
        List<Integer> winningNumber = new ArrayList<>();
        for (String strNumber : inputWinningNumber) {
            int number;
            try {
                number = Integer.parseInt(strNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 문자열은 입력 불가합니다.");
            }
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("1 ~ 45 중에서 입력할 수 있습니다.");
            }
            winningNumber.add(number);
        }

        return winningNumber;
    }

    private int getBonusNumber(String inputBonusNumber) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 문자열은 입력 불가합니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("1 ~ 45 중에서 입력할 수 있습니다.");
        }
        return bonusNumber;
    }
}
