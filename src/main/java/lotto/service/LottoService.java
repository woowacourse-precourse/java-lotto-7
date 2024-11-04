package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningTable;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {
    private final List<Lotto> userLottoWallet;
    public LottoService(List<Lotto> userLottoWallet) {
        this.userLottoWallet = userLottoWallet;
    }

    public Map<LottoWinningTable, Integer> getWinningResultTable(final List<Integer> winningNumbers,int bonusNumber) {
        List<LottoWinningTable> validTable = filterValidWallet(winningNumbers, bonusNumber);
        Map<LottoWinningTable, Integer> result = new HashMap<>();

        for (LottoWinningTable table : LottoWinningTable.values()) {
            result.put(table, countMatchingNumberFromValidTable(validTable, table));
        }
        return result;
    }

    private int countMatchingNumberFromValidTable(final List<LottoWinningTable> validTable, LottoWinningTable target) {
        return validTable.stream()
                .filter(key -> key == target)
                .mapToInt(key -> 1)
                .sum();
    }
    private List<LottoWinningTable> filterValidWallet(final List<Integer> winningNumbers, final int bonusNumber ) {
        return userLottoWallet.stream()
                .map(lotto -> lotto.getResult(winningNumbers, bonusNumber))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
