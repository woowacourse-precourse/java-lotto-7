package lotto.dto;

import java.util.List;

public record LotteriesResponse(List<List<Integer>> lotteries,
                                int lotteriesCount) {
}
