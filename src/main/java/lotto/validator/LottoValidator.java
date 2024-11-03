package lotto.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.constant.ErrorMessage;

public class LottoValidator {

    public int purchaseAmountValidate(String purchaseAmountInput) {
        purchaseAmountTypeValidator(purchaseAmountInput);
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        purchaseAmountPositiveValidator(purchaseAmount);
        purchaseAmountUnitValidator(purchaseAmount);
        return purchaseAmount;
    }

    public Lotto winningLottoValidate(String[] winningLottoInput) {
        lottoNumsTypeValidator(winningLottoInput);
        List<Integer> winningLotto = convertArrayToList(winningLottoInput);
        Lotto winningLottoTicket = new Lotto(winningLotto);
        duplicateNumValidator(winningLottoTicket);
        lottoNumRangeValidator(winningLottoTicket);

        return winningLottoTicket;
    }

    public int bonusNumberValidate(String bonusNumberInput) {

        lottoNumTypeValidator(bonusNumberInput);
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        bonusNumRangeValidator(bonusNumber);
        return bonusNumber;
    }


    //구매 금액에 숫자가 아닌 다른 것이 들어갈 때.
    private void purchaseAmountTypeValidator(String purchaseAmount) {
        if(!purchaseAmount.matches("-?\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_TYPE_EXCEPTION);
        }
    }
    //음수인지 검증
    private void purchaseAmountPositiveValidator(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_RANGE_EXCEPTION);
        }

    }

    //1000원 단위인지 검증
    private void purchaseAmountUnitValidator (int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_UNIT_EXCEPTION);
        }
    }

    //중복 값 검증
    private void duplicateNumValidator(Lotto lotto) {
        ArrayList<Integer> lottoNums = new ArrayList<>(lotto.getNumbers());
        Set<Integer> uniqueNumbers = new HashSet<>(lottoNums);

        if (uniqueNumbers.size() != lottoNums.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE_EXCEPTION);
        }
    }

    //로또 1~45 범위 검증
    private void lottoNumRangeValidator (Lotto lotto) {
        ArrayList<Integer> lottoNums = new ArrayList<>(lotto.getNumbers());
        for (Integer lottoNum : lottoNums) {
            if (lottoNum > 45 || lottoNum < 1) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_EXCEPTION);
            }
        }
    }

    //보너스 번호 1~45 범위 검증
    private void bonusNumRangeValidator (int bonusNum) {
        if (bonusNum > 45 || bonusNum < 1) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_EXCEPTION);
        }
    }

    //당첨 번호, 보너스 번호 타입 검증
    private void lottoNumsTypeValidator (String[] lottoNums) {
        for (String lottoNum : lottoNums) {
            lottoNumTypeValidator(lottoNum);
        }
    }

    private void lottoNumTypeValidator (String lottoNum) {
        if(!lottoNum.matches("-?\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_TYPE_EXCEPTION);
        }
    }

    private List<Integer> convertArrayToList(String[] array) {
        List<Integer> list = new ArrayList<>();
        for (String number: array) {
            number = number.trim();
            list.add(Integer.parseInt(number));
        }
        return list;
    }
}
