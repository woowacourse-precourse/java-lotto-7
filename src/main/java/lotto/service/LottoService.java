package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import lotto.domain.WinningNumber;
import lotto.enums.WinningRanking;
import lotto.factory.LottoFactory;
import lotto.utility.Divider;
import lotto.utility.Parser;
import lotto.utility.RandomGenerator;
import lotto.validation.Validator;

public class LottoService {
    private static final String FIXED_DELIMITER = ",";


    public int isValidNumber(String inputCost) {
        isBlank(inputCost);
        isPositiveNumber(inputCost);
        int parsedCost = parseStringToInt(inputCost);
        isDivisibleByThousand(parsedCost);

        return parsedCost;
    }

    private void isBlank(String inputCost) {
        Validator.isBlank(inputCost);
    }

    private void isPositiveNumber(String inputCost) {
        Validator.isPositiveNumber(inputCost);
    }

    private int parseStringToInt(String inputCost) {
        return Parser.parseStringToInt(inputCost);
    }

    private void isDivisibleByThousand(int parsedPurchaseAmount) {
        Validator.isDivisibleByThousand(parsedPurchaseAmount);
    }

    public int divideInputByLottoPrice(int parsedPurchaseAmount) {
        return Divider.divideInputByLottoPrice(parsedPurchaseAmount);
    }

    public LottoCollection generateLottoCollection(int purchasedLottoCount) {
        LottoCollection lottoCollection = generateLottoCollection();

        for (int i = 0; i < purchasedLottoCount; i++) {
            Lotto oneLotto = generateOneLottoObject();
            lottoCollection.addLotto(oneLotto);
        }
        return lottoCollection;
    }

    public List<Integer> generateOneSetRandomNumber() {
        return RandomGenerator.makeRandomNumber();
    }

    public Lotto generateOneLottoObject() {
        List<Integer> randomNumber = generateOneSetRandomNumber();
        return LottoFactory.createLotto(randomNumber);
    }

    public LottoCollection generateLottoCollection() {
        return LottoFactory.createLottoCollection();
    }

    public List<Lotto> prepareCollectionForPrint(LottoCollection lottoCollection) {
        List<Lotto> lottos = lottoCollection.getAllLotto();
        for (Lotto lotto : lottos) {
            Collections.sort(lotto.getNumbers());
        }
        return lottos;
    }

    // split 전, 모든 문자열이 비어있는지 콤마(,)와 숫자로만 이루어져있는지 검증
    public void validateInputWinNumber(String winningNumber) {
        Validator.isBlank(winningNumber);
        Validator.isValidNumberAndDelimiter(winningNumber);
    }

    public String[] splitWinningNumber(String winningNumber) {
        String[] splitWinningNumber = winningNumber.split(FIXED_DELIMITER);
        return splitWinningNumber;
    }

    // split 후, 검증
    public WinningNumber validateSplitWinNumber(String[] splitWinningNumber) {
        List<Integer> validWinNumbers = new ArrayList<>();

        Validator.isNumberSixSize(splitWinningNumber);

        for (String winningNumber : splitWinningNumber) {
            Validator.isBlank(winningNumber);
            int parsedWinNumber = parseStringToInt(winningNumber);
            Validator.isBetweenOneAndFortyFive(parsedWinNumber);
            Validator.isDuplicateNumber(parsedWinNumber);

            validWinNumbers.add(parsedWinNumber);
        }
        return new WinningNumber(validWinNumbers);
    }

    public int validateBonusNumber(String bonusNumber, WinningNumber winningNumberObject) {
        Validator.isBlankBonusNumber(bonusNumber);
        Validator.isPositiveBonusNumber(bonusNumber);

        int parsedBonusNumber = parseBonusNumberToInt(bonusNumber);
        Validator.isBetweenOneAndFortyFive(parsedBonusNumber);
        Validator.isBonusNumberDuplicateWithWinNumber(parsedBonusNumber, winningNumberObject);

        return parsedBonusNumber;
    }

    public int parseBonusNumberToInt(String bonusNumber) {
        return Parser.parseStringToInt(bonusNumber);
    }

    public BonusNumber addBonusNumber(int parsedBonusNumber) {
        return new BonusNumber(parsedBonusNumber);
    }

    public Map<WinningRanking, Integer> decideRanking(LottoCollection lottoCollection,
                                                      WinningNumber winningNumberObject,
                                                      BonusNumber bonusNumberObject) {
        Map<WinningRanking, Integer> rankingCount = new HashMap<>();

        for (WinningRanking ranking : WinningRanking.values()) {
            rankingCount.put(ranking, 0);
        }

        for (Lotto lotto : lottoCollection.getAllLotto()) {
            WinningRanking lottoRanking = getLottoRanking(lotto, winningNumberObject, bonusNumberObject);

            if (lottoRanking != null) {
                rankingCount.put(lottoRanking, rankingCount.get(lottoRanking) + 1);
            }
        }
        return rankingCount;
    }

    private WinningRanking getLottoRanking(Lotto lotto, WinningNumber winningNumberObject,
                                           BonusNumber bonusNumberObject) {
        int matchCount = getMatchCount(lotto, winningNumberObject);
        boolean needBonusNumber = lotto.getNumbers().contains(bonusNumberObject);
        return WinningRanking.getWinningRanking(matchCount, needBonusNumber);
    }

    private int getMatchCount(Lotto lotto, WinningNumber winningNumberObject) {
        List<Integer> winningNumbers = winningNumberObject.getWinningNumbers();

        long count = lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        return (int) count;
    }


}
