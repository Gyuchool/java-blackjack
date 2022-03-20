package blackjack.domain.card;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static blackjack.domain.card.Deck.INIT_CARD_SIZE;

public class Cards {
    private static final int BUST_LINE = 21;
    private static final int EXTRA_SCORE = 10;

    private final Set<Card> cards;

    public Cards(List<Card> cards) {
        this(new LinkedHashSet<>(cards));
    }

    private Cards(Set<Card> cards) {
        this.cards = new LinkedHashSet<>(cards);
    }

    public Set<Card> getCards() {
        return new LinkedHashSet<>(cards);
    }

    public void add(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int score = cards.stream()
                .mapToInt(card -> card.getNumber().getValue())
                .sum();
        return addAceScore(score);
    }

    private int addAceScore(int score) {
        long countAce = cards.stream().filter(Card::isAce).count();

        for (int i = 0; i < countAce; i++) {
            score = calculateAceScore(score);
        }
        return score;
    }

    private int calculateAceScore(int score) {
        if (score + EXTRA_SCORE <= BUST_LINE) {
            score += EXTRA_SCORE;
        }
        return score;
    }

    public int size() {
        return cards.size();
    }

    public boolean isBlackJack() {
        return cards.size() == INIT_CARD_SIZE && getScore() == BUST_LINE;
    }

    public boolean isBust() {
        return getScore() > BUST_LINE;
    }

    public boolean isGreaterThan(Cards cards) {
        return this.getScore() > cards.getScore();
    }

    public boolean isSameScore(Cards cards) {
        return !isBust() && this.getScore() == cards.getScore();
    }
}
