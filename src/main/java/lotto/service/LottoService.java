package lotto.service;
import lotto.domain.AutoLotto;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static lotto.domain.rule.LottoRules.AUTO_LOTTO_PRICE;
import static lotto.domain.message.LottoPriceErrorMessage.INVALID_LOTTO_PRICE_DIVISIBLE_OR_ZERO;

public class LottoService {

    public List<AutoLotto> createAutoLottosByLottoPrice(String inputTotalLottoPrice) {
        List<AutoLotto> autoLottos = new ArrayList<>();

        validateDefaultInputPrice(inputTotalLottoPrice);
        validateLottoPrice(Integer.parseInt(inputTotalLottoPrice));
        int autoLottoCount = Integer.parseInt(inputTotalLottoPrice) / AUTO_LOTTO_PRICE.getValue();
        for (int i = 0; i < autoLottoCount; i++) {
            autoLottos.add(Lotto.createRandomLotto());
        }
        return autoLottos;
    }

    public WinningLotto createWinningLotto(String inputWinningLottoNumbers) {
        try {
            List<Integer> winningNumbers = Arrays.stream(inputWinningLottoNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();

            Lotto winningLotto = new Lotto(winningNumbers); // 로또 공통 유효성 검증
            return Lotto.createWinningLotto(winningLotto.getNumbers());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 중복없는 1~45사이의 숫자 형식이어야 합니다. (예시: 1,2,3,4,5,6)");
        }
    }

    public WinningLotto setWinningLottoBonusNumber(WinningLotto winningLotto, String bonusNumber) {
        winningLotto.setBonusNumber(bonusNumber);
        return winningLotto;
    }

    private void validateDefaultInputPrice(String inputPrice) {
        validateNullOrEmpty(inputPrice);
        validateParsableToInt(inputPrice);
    }

    public void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 유효하지 않습니다. 빈 값이나 공백만 입력할 수 없습니다.");
        }
    }

    public void validateParsableToInt(String inputLottoPrice) {
        try{
            Integer.parseInt(inputLottoPrice);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수형식이 아니거나, 너무 큰 숫자입니다.");
        }
    }

    private void validateLottoPrice(int totalLottoPrice) {
        if(isNotValidateLottoPrice(totalLottoPrice)){
            throw new IllegalArgumentException(INVALID_LOTTO_PRICE_DIVISIBLE_OR_ZERO.getMessage());
        }
    }

    private boolean isNotValidateLottoPrice(int totalLottoPrice) {
        return isZeroLottoPrice(totalLottoPrice) || !(isDivisibleByLottoPrice(totalLottoPrice));
    }

    private boolean isZeroLottoPrice(int totalLottoPrice) {
        return totalLottoPrice == 0;
    }

    private boolean isDivisibleByLottoPrice(int totalLottoPrice) {
        return totalLottoPrice % AUTO_LOTTO_PRICE.getValue() == 0;
    }



}
