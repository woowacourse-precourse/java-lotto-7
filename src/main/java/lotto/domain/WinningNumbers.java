package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.common.ErrorMessage.ERROR_MESSAGE;
import static lotto.common.NumberConstants.LOTTO_LENGTH;

public class WinningNumbers extends NumberImpl implements Iterable<Integer> {

    private final List<Integer> winningNumbers;

    public WinningNumbers(String rawWinningNumbers) {
        String trimWinningNumbers = rawWinningNumbers.trim();
        validateBlank(trimWinningNumbers, getDomain());
        List<String> splitWinningNumbers = split(trimWinningNumbers);
        validateSize(splitWinningNumbers);
        List<Integer> winningNumbers = validateNumbers(splitWinningNumbers);;
        validateRange(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private List<String> split(String numbers) {
        return Arrays.stream(numbers.split(",")).toList();
    }

    private List<Integer> validateNumbers(List<String> numbers) {
        return numbers.stream()
                .map(number -> {
                    validateNumber(number.trim(), getDomain());
                    return Integer.parseInt(number.trim());
                })
                .toList();
    }

    private void validateSize(List<String> numbers) {
        if (hasCorrectSize(numbers)) return;
        throw new IllegalArgumentException(ERROR_MESSAGE + " " +getDomain() + "는 길이가 6여야 합니다.");
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .peek(number -> validateRange(number, getDomain()))
                .toList();
    }

    private boolean hasCorrectSize(List<String> numbers) {
        return numbers.size() == LOTTO_LENGTH;
    }

    public Map<Integer, Boolean> toMap() {
        return winningNumbers.stream()
                .collect(Collectors.toMap(number -> number, number -> true));
    }

    public Set<Integer> getKeySet() {
        return toMap().keySet();
    }

    @Override
    public Iterator<Integer> iterator() {
        return winningNumbers.iterator();
    }

    public Stream<Integer> stream() {
        return winningNumbers.stream();
    }

    public String getDomain() {
        return "당첨번호";
    }

}
