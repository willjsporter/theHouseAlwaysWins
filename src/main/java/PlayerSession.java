public class PlayerSession {
        private int playerId;
        //a unique id for the player
        private String gameName;
        //Poker, Roulette or Blackjack
        private int numberOfGamesPlayed;
        private int amountWageredInPounds;
        //The total amount the player has wagered in the given game in whole £’s
        private int amountWonInPounds;
        //The total amount the player has won in the given game in whole £’s

        public PlayerSession(int playerId, String gameName, int numberOfGamesPlayed, int amountWageredInPounds, int amountWonInPounds) {
                this.playerId = playerId;
                this.gameName = gameName;
                this.numberOfGamesPlayed = numberOfGamesPlayed;
                this.amountWageredInPounds = amountWageredInPounds;
                this.amountWonInPounds = amountWonInPounds;
        }
}
