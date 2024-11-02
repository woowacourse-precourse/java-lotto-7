package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Constants;
import lotto.domain.Lotto;
import lotto.validator.InputValidator;

import java.util.List;

public class LottoService {

    private List<Lotto> lottoList;
    private InputValidator inputValidator;

    public LottoService() {
        inputValidator = new InputValidator();
    }

    public int purchaseLotto(int lottoPrice) {
        int lottoNum = lottoPrice / Constants.PURCHASE_FORM;

        return lottoNum;
    }

    public List<Lotto> randomLottoNum(int lottoNum) {
        for(int i=0; i<lottoNum; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public int validateLottoPrice(String lottoPrice) {
        inputValidator.validateEmpty(lottoPrice);
        int lottoPriceInt = inputValidator.validateNumber(lottoPrice);
        inputValidator.validatePriceForm(lottoPriceInt);

        return lottoPriceInt;
    }

    public void validateWinningNumbers(String lottoWinningNumbers) {
        inputValidator.validateEmpty(lottoWinningNumbers);
        inputValidator.validateNumbersForm(lottoWinningNumbers);
    }

    public void validateBonusNumbers(String lottoBonusNumber) {
        inputValidator.validateEmpty(lottoBonusNumber);
        inputValidator.validateNumber(lottoBonusNumber);
    }

    public void winningLotto(String lottoWinningNumbers, String lottoBonusNumber) {

    }
}
