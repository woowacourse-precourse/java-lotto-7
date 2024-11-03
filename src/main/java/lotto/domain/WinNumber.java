package lotto.domain;

import java.util.List;

public record WinNumber(List<Integer> numbers, int bonusNumber) {
}
