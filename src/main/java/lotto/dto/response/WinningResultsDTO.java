package lotto.dto.response;

import java.util.List;

public record WinningResultsDTO(
        List<WinningResultDTO> winningResultDTOs,
        Double profitRate
) {
    public static WinningResultsDTO of(
            List<WinningResultDTO> winningResultDTOs,
            Double profitRate
    ) {
        return new WinningResultsDTO(winningResultDTOs, profitRate);
    }
}
