package lotto.service;

import lotto.dto.BonusNumberRequest;
import lotto.dto.LottoNumbersRequest;
import lotto.dto.PurchaseRequest;
import lotto.view.LottoInputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputProcessService {
    private final int LOTTO_RANGE_MIN;
    private final int LOTTO_RANGE_MAX;
    private final int LOTTO_PRICE;
    private final int LOTTO_NUMBER_COUNT;
    private final LottoInputView lottoInputView;

    public InputProcessService(LottoInputView lottoInputView,
                               int LOTTO_RANGE_MIN,
                               int LOTTO_RANGE_MAX,
                               int LOTTO_PRICE,
                               int LOTTO_NUMBER_COUNT){
        this.lottoInputView = lottoInputView;
        this.LOTTO_RANGE_MIN = LOTTO_RANGE_MIN;
        this.LOTTO_RANGE_MAX = LOTTO_RANGE_MAX;
        this.LOTTO_PRICE = LOTTO_PRICE;
        this.LOTTO_NUMBER_COUNT = LOTTO_NUMBER_COUNT;
    }

    public Integer getPurchaseRequest() {
        while(true) {
            try {
                PurchaseRequest purchaseRequest = lottoInputView.getPurchaseRequest();
                Integer price = purchaseRequestValidation(purchaseRequest);

                return price;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getLottoNumbersRequest() {
        while(true) {
            try {
                LottoNumbersRequest lottoNumbersRequest = lottoInputView.getLottoNumbersRequest();
                List<Integer> lottoNumbers = lottoNumbersRequestValidation(lottoNumbersRequest);

                return lottoNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer getBonusNumberRequest() {
        while(true) {
            try {
                BonusNumberRequest bonusNumberRequest = lottoInputView.getBonusNumberRequest();
                Integer bonusNumber = bonusNumberRequestValidation(bonusNumberRequest);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer purchaseRequestValidation(PurchaseRequest purchaseRequest) {
        Integer price = parseIntegerValidation(purchaseRequest.getPrice());

        if (price % LOTTO_PRICE != 0) {
            String message = String.format("[ERROR] 로또 가격(%d) 단위로 입력해주세요.", LOTTO_PRICE);
            throw new IllegalArgumentException(message);
        }

        return price;
    }

    private List<Integer> lottoNumbersRequestValidation(LottoNumbersRequest lottoNumbersRequest) {
        List<Integer> lottoNumbers = parseIntegerListValidation(lottoNumbersRequest.getLottoNumbers());

        lottoNumbersCountValidation(lottoNumbers);

        for (Integer number : lottoNumbers) {
            lottoNumberRangeValidation(number);
        }

        lottoNumbersDuplicateValidation(lottoNumbers);

        return lottoNumbers;
    }

    private Integer bonusNumberRequestValidation(BonusNumberRequest bonusNumberRequest) {
        Integer bonusNumber = parseIntegerValidation(bonusNumberRequest.getBonusNumber());

        lottoNumberRangeValidation(bonusNumber);

        return bonusNumber;
    }

    private Integer parseIntegerValidation(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해주세요.");
        }
    }

    private List<Integer> parseIntegerListValidation(String input) {
        try {
            String[] numbers = input.split(",");
            return Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수와 구분자 ','만 입력해주세요.");
        }
    }

    private void lottoNumberRangeValidation(Integer number) {
        if (number < LOTTO_RANGE_MIN || number > LOTTO_RANGE_MAX) {
            String message = String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", LOTTO_RANGE_MIN, LOTTO_RANGE_MAX);
            throw new IllegalArgumentException(message);
        }
    }

    private void lottoNumbersCountValidation(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            String message = String.format("[ERROR] 로또 번호는 %d개여야 합니다.", LOTTO_NUMBER_COUNT);
            throw new IllegalArgumentException(message);
        }
    }

    private void lottoNumbersDuplicateValidation(List<Integer> numbers) {
        boolean duplication = false;

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    duplication = true;
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
                }
            }
        }
    }
}
