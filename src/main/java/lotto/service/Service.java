package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.CustomException;
import lotto.model.Lotto;
import lotto.model.Prize;

import java.util.*;
import java.util.stream.Collectors;
import javax.xml.validation.Validator;
public class Service {

    public final static int MIN = 1;
    public final static int MAX = 45;
    public final static int COUNT = 6;
    public final static int LOTTO_MIN = 1;
    public final static int LOTTO_MAX = 45;
    public final static int LOTTO_COUNT = 6;
    public final static String REGEX = "^[0-9]+(,[0-9]+)*$";

    public int count(int amount) {
        validateAmountCount(amount);
        return amount / 1000;
    }


    public List<Lotto> createLotto(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {

            List<Integer> nums = Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT);

            nums.sort(Integer::compareTo);

            lottos.add(new Lotto(nums));
        }
        return lottos;
    }

    public Lotto createWinningNumber(String lottoNum) {

        validateEmpty(lottoNum);
        validateDelimiter(lottoNum);

        List<Integer> numbers = Arrays.stream(lottoNum.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        validateDuplicatedWinningNumber(numbers);

        return new Lotto(numbers);
    }

    public int bonusNum(Integer bonusNum, Lotto lotto) {
        validateEmpty(bonusNum);
        validateDuplicatedBonusNumber(bonusNum, lotto);
        return bonusNum;
    }

    public Map<Prize, Integer> calculateWinningDetail(List<Lotto> lottos, Lotto lotto, int bonusNum) {
        Map<Prize, Integer> prizeIntegerMap = Arrays.stream(Prize.values())
                .collect(Collectors.toMap(prize -> prize, prize -> 0));

        for (Lotto l : lottos) {
            int matchCount = (int) l.getNumbers().stream()
                    .filter(lotto.getNumbers()::contains)
                    .count();

            boolean isBonusMatch = l.getNumbers().contains(bonusNum);

            Prize prize;

            if (matchCount == 6) {
                prize = Prize.SIX_MATCH;
            } else if (matchCount == 5 && isBonusMatch) {
                prize = Prize.FIVE_MATCH_BONUS;
            } else if (matchCount == 5) {
                prize = Prize.FIVE_MATCH;
            } else if (matchCount == 4) {
                prize = Prize.FOUR_MATCH;
            } else if (matchCount == 3) {
                prize = Prize.THREE_MATCH;
            } else {
                prize = Prize.NO_MATCH;
            }

            prizeIntegerMap.put(prize, prizeIntegerMap.get(prize) + 1);
        }

        return prizeIntegerMap;
    }

    public double calculateRate(Map<Prize, Integer> prizeIntegerMap, int purchaseAmount) {
        long sum = 0;
        for(Prize prize : Prize.values()){
            sum += (long) prize.getPrizeAmount() * prizeIntegerMap.get(prize);
        }
        return (double) sum / purchaseAmount;
    }

    public int validateNumber(String inputPurchaseAmount){
        try {
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CustomException.INVALID_NUMBER.getMessage());
        }
    }

    public void validateAmountCount(int amount){
        if (amount%1000 != 0){
            throw new IllegalArgumentException(CustomException.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
        }
    }

    public void validateLottoCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(CustomException.RESTRICTION_WINNING_NUMBER.getMessage());
        }
    }

    public void validateDuplicatedWinningNumber(List<Integer> numbers){
        numbers.forEach(this::validateNumberRange);
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(CustomException.DUPLICATED_WINNING_NUMBER.getMessage());
        }
    }

    public void validateDuplicatedBonusNumber(int bonusNumber, Lotto lotto){
        validateNumberRange(bonusNumber);
        if(lotto.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException(CustomException.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    public void validateNumberRange(int bonusNumber){
        if(bonusNumber < LOTTO_MIN || bonusNumber > LOTTO_MAX){
            throw new IllegalArgumentException(CustomException.NUMBER_RANGE_LIMITATION.getMessage());
        }
    }

    public void validateDelimiter(String winningNumber){
        if (!winningNumber.matches(REGEX)) {
            throw new IllegalArgumentException(CustomException.INVALID_DELIMITER.getMessage());
        }
    }

    public void validateEmpty(Object input) {
        if (input == null || (input instanceof String && ((String) input).trim().isEmpty())) {
            throw new IllegalArgumentException(CustomException.INPUT_EMPTY.getMessage());
        }
    }
}
