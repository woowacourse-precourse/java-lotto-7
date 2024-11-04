package lotto.global.dto.request;

import java.util.List;
import java.util.UUID;

public record SetPrizeLottoRequestDTO(UUID uuid, List<Integer> prizeNumbers) {
}
