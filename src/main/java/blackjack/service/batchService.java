package blackjack.service;

import blackjack.domain.PlayerResult;
import blackjack.domain.user.Bet;
import blackjack.domain.user.Player;

import java.util.LinkedHashMap;
import java.util.Map;

public class batchService {

    public static Map<String, Double> calculate(Map<Player, PlayerResult> statistics) {
        Map<String, Double> info = new LinkedHashMap<>();
        for (Map.Entry<Player, PlayerResult> entry : statistics.entrySet()) {
            Player player = entry.getKey();
            Bet bet = player.getBet();
            PlayerResult result = entry.getValue();
            info.put(player.getName(), bet.calculate(result.getProfit()));
        }
        return info;
    }
}
