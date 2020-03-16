package blackjack.domain.strategy;

import blackjack.domain.Dealer;
import blackjack.domain.Status;
import blackjack.domain.Player;
import blackjack.domain.PlayerResult;

public class DealerBustStrategy implements DealerStatusStrategy {
    @Override
    public PlayerResult calculateResultByPlayerStatus(Dealer dealer, Player player) {
        if (player.getStatus() == Status.BUST) {
            return PlayerResult.LOSE;
        }
        return PlayerResult.WIN;
    }
}