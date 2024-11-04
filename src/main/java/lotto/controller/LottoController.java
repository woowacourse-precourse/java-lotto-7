package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoConstant;
import lotto.service.LottoService;
import lotto.utils.AnswerParser;
import lotto.view.LottoView;

public class LottoController {
    private final LottoService lottoService;
    private final LottoView lottoView;

    public LottoController(LottoService lottoService, LottoView lottoView) {
        this.lottoService = lottoService;
        this.lottoView = lottoView;
    }

    public void run() {
        int money = getMoneyFromUser();
        int lottoCount = lottoService.getLottoCount(money);
        lottoView.showLottoCount(lottoCount);
        lottoService.issueLottos(lottoCount);
        lottoView.showLottoAll(lottoService.getLottoList());
        lottoService.saveLottoAnswer(getValidatedAnswerFromUser());
        lottoService.saveBonusNumber(getValidatedBonusNumberFromUser());
        lottoView.printResult(lottoService.calculateResults(money));
    }

    private Integer getValidatedBonusNumberFromUser() {
        while (true) {
            try {
                lottoView.showBonusNumberRequestMessage();
                Integer bonusNumber = getInteger();
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                lottoView.showErrorMessage("[ERROR] 숫자를 입력해주세요.");
            } catch (Exception e) {
                lottoView.showErrorMessage("[ERROR] 알 수 없는 예외가 발생했습니다.");
            }
        }
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (bonusNumber < LottoConstant.LOTTO_NUMBER_MIN_RANGE
                || bonusNumber > LottoConstant.LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 "
                    + LottoConstant.LOTTO_NUMBER_MIN_RANGE + " 이상 "
                    + LottoConstant.LOTTO_NUMBER_MAX_RANGE + " 이하의 숫자여야 합니다.");
        }
        if (lottoService.isBonusNumberDuplicate(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private List<Integer> getValidatedAnswerFromUser() {
        while (true) {
            try {
                lottoView.showAnswerRequestMessage();
                String input = Console.readLine();
                List<Integer> answerList = AnswerParser.getAnswerList(input);
                validateAnswerList(answerList);
                return answerList;
            } catch (IllegalArgumentException e) {
                lottoView.showErrorMessage(e.getMessage());
            } catch (Exception e) {
                lottoView.showErrorMessage("[ERROR] 유효하지 않은 입력입니다. 다시 시도해주세요.");
            }
        }
    }

    private void validateAnswerList(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.ANSWER_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 "
                    + LottoConstant.ANSWER_NUMBER_COUNT + "개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LottoConstant.ANSWER_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }

        for (Integer number : numbers) {
            if (number < LottoConstant.LOTTO_NUMBER_MIN_RANGE
                    || number > LottoConstant.LOTTO_NUMBER_MAX_RANGE) {
                throw new IllegalArgumentException("[ERROR] 유효한 범위의 숫자가 아닙니다.");
            }
        }
    }

    private int getMoneyFromUser() {
        while (true) {
            try {
                lottoView.showPaymentRequestMessage();
                int money = getInteger();
                validateMoney(money);
                return money;
            } catch (IllegalArgumentException e) {
                lottoView.showErrorMessage(e.getMessage());
            } catch (Exception e) {
                lottoView.showErrorMessage("[ERROR] 유효하지 않은 금액입니다. 다시 입력해주세요.");
            }
        }
    }

    private void validateMoney(int money) {
        if (money < LottoConstant.LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000보다 커야 합니다.");
        }
        if (money % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
    }

    private Integer getInteger() {
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 변환할 수 없습니다.");
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException("[ERROR] 알 수 없는 예외 발생");
        }
    }
}
