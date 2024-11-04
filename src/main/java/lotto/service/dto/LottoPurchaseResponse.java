package lotto.service.dto;

import java.util.List;

public record LottoPurchaseResponse(int lottoTicketsCount, List<List<String>> lottoNumbers) {
}
