class Solution {
    private static class Player {
        int id;
        int won;
        int lost;

        Player(int id) {
            this.id = id;
        }
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Player> players = new HashMap<>();
        for (int[] match : matches) {
            int winnerId = match[0];
            int looserId = match[1];
            Player winner = players.getOrDefault(winnerId, new Player(winnerId));
            winner.won++;
            Player looser = players.getOrDefault(looserId, new Player(match[1]));
            looser.lost++;
            players.put(winnerId, winner);
            players.put(looserId, looser);
        }
        List<Integer> onlyWins = players.values().stream().filter(p -> p.lost == 0).map(p -> p.id).sorted()
            .collect(Collectors.toList());
        List<Integer> oneLost = players.values().stream().filter(p -> p.lost == 1).map(p -> p.id).sorted()
            .collect(Collectors.toList());
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(onlyWins);
        answer.add(oneLost);
        return answer;
    }
}