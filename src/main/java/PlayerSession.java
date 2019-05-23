public class PlayerSession {
        private int playerId;
        private String gameName;
        private int numberOfGamesPlayed;
        private int amountWageredInPounds;
        private int amountWonInPounds;

        int getPlayerId() {
                return playerId;
        }

        public String getGameName() {
                return gameName;
        }

        public int getNumberOfGamesPlayed() {
                return numberOfGamesPlayed;
        }

        public int getAmountWageredInPounds() {
                return amountWageredInPounds;
        }

        public int getAmountWonInPounds() {
                return amountWonInPounds;
        }

        PlayerSession(int playerId, String gameName, int numberOfGamesPlayed, int amountWageredInPounds, int amountWonInPounds) {
                this.playerId = playerId;
                this.gameName = gameName;
                this.numberOfGamesPlayed = numberOfGamesPlayed;
                this.amountWageredInPounds = amountWageredInPounds;
                this.amountWonInPounds = amountWonInPounds;
        }
}
