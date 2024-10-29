package lotto.controller;

import lotto.model.LottoModel;
import lotto.view.LottoView;

import java.util.ArrayList;
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

        //수익률 로직 구현

        lottoView.output.winningResult();
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
