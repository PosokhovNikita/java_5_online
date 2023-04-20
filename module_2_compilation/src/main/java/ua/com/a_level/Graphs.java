package ua.com.a_level;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Graphs {
    private final Map<String, Integer> nodes = new TreeMap<>();
    private final int[][] evaluations;

    public Graphs(int size) {
        evaluations = new int[size][size];
    }

    public static int[] cheapestWay(int source, int[][] evaluations) {
        boolean[] wentTo = new boolean[evaluations.length];
        Arrays.fill(wentTo, false);

        int[] costs = new int[evaluations.length];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[source] = 0;

        for (int i = 0; i < evaluations.length - 1; i++) {
            int minCost = minPrice(wentTo, costs);
            wentTo[minCost] = true;
            for (int j = 0; j < wentTo.length; j++) {
                if (!wentTo[j] && evaluations[minCost][j] != 0) {
                    int temp = costs[minCost] + evaluations[minCost][j];
                    if (temp < costs[j]) {
                        costs[j] = temp;
                    }
                }
            }
        }
        return costs;
    }

    private static int minPrice(boolean[] visited, int[] prices) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && prices[i] < min) {
                min = prices[i];
                index = i;
            }
        }
        return index;
    }

    public void addNode(int id, String name) {
        if (nodes.containsKey(name)) {
            throw new SecurityException();
        }
        nodes.put(name, id);
    }

    public void addWay(int from, int to, int cost) {
        if (from < 0 || to < 0 || cost < 0) {
            throw new SecurityException();
        }
        evaluations[from][to] = cost;
    }

    public int cityIndex(String name) {
        return nodes.get(name);
    }

    public int[][] getEvaluations() {
        return evaluations;
    }

}
