package lotto.converter;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.Validator;
import lotto.view.OutputView;

public class LottoConverter {

    private List<Integer> lottoNumbers = new ArrayList<>();
    private int bonusNumber;

    public LottoConverter(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateRange(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoConverter(String bonusNumber) {
        this.bonusNumber = Validator.isNumeric(bonusNumber);
        Validator.isRightRange(this.bonusNumber);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateSize(List<Integer> lottoNumbers) {
        try {
            System.out.println(lottoNumbers);
            Validator.isRightSize(lottoNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.getInstance().printErrorMessage(e.getMessage());
            throw new IllegalArgumentException();
        }

    }

    private void validateRange(List<Integer> lottoNumbers) {
        try {
            Validator.isRightRange(lottoNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.getInstance().printErrorMessage(e.getMessage());
            throw new IllegalArgumentException();
        }

    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        try {
            Validator.isDuplicated(lottoNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.getInstance().printErrorMessage(e.getMessage());
            throw new IllegalArgumentException();
        }

    }


}
