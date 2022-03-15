package blackJack.domain.User;

import blackJack.domain.Card.CardFactory;
import blackJack.domain.Card.Cards;

public abstract class User {

    protected String name;
    protected Cards cards;

    public User(String name, Cards cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public Cards getCards() {
        return cards;
    }

    public int getScore() {
        return cards.calculateScore();
    }

    public boolean isBust() {
        return cards.isBust();
    }

    public boolean isGreaterScoreThan(User user) {
        return this.cards.calculateScore() > user.cards.calculateScore();
    }

    abstract public void addCard(CardFactory cardFactory);


}
