package blackjack.domain.User;

import blackjack.domain.Card.CardFactory;
import blackjack.domain.PlayerResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public static Players create(List<String> playerNames, CardFactory cardFactory) {
        return playerNames.stream()
                .map(name -> new Player(name, cardFactory.initCards()))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Players::new
                ));
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public Map<String, String> getStatistics(Dealer dealer) {
        Map<String, String> result = new HashMap<>();
        for (Player player : players) {
            PlayerResult compare = PlayerResult.decision(dealer, player);
            result.put(player.getName(), compare.getValue());
        }
        return result;
    }
}
