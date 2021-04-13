import java.util.*;

class Main {

    public static String GroupTotals(String[] strArr) {
        Map<String, Integer> totals = new TreeMap<String, Integer>();
        for (String player : strArr) {
            String[] playerScore = player.split(":");
            totals.computeIfPresent(playerScore[0], (key, val) -> val + Integer.parseInt(playerScore[1]));
            totals.putIfAbsent(playerScore[0], Integer.parseInt(playerScore[1]));
            if (totals.get(playerScore[0]) == 0) {
                totals.remove(playerScore[0]);
            }
        }
        ArrayList<String> output = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : totals.entrySet()) {
            output.add(entry.getKey() + ":" + entry.getValue());
        }
        return String.join(",", output);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(GroupTotals(new String[]{"X:-1", "Y:1", "X:-4", "B:3", "X:5"}));
    }
}