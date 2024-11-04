package lotto.lottoMachine;

import java.util.List;

public class LottoNumberPrinter {
    private static final String LOTTO_NUMBER_LEFT_BRACKET = "[";
    private static final String LOTTO_NUMBER_RIGHT_BRACKET = "]";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    public void printThisLottoNumber(List<Integer> generatedLottoNumbers) {
        List<String> makeStringLottoNumberForUseJointMethod = makeStringGeneratedLottoNumbers(generatedLottoNumbers);
        String fullLottoNumberWithDelimiter = String.join(LOTTO_NUMBER_DELIMITER, makeStringLottoNumberForUseJointMethod);

        System.out.println(LOTTO_NUMBER_LEFT_BRACKET + fullLottoNumberWithDelimiter + LOTTO_NUMBER_RIGHT_BRACKET);
    }

    private List<String> makeStringGeneratedLottoNumbers(List<Integer> generatedLottoNumbers) {
        List<String> makeStringForUseJoinMethod = generatedLottoNumbers.stream().map(String::valueOf).toList();

        return makeStringForUseJoinMethod;
    }
}
