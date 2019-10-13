package com.barros.jullierme.wallethubtest;

public class GasStation {
    static int canCompleteCircuit(int[] gas, int[] costs, int startStation, int tank) {
        int[] gass = new int[gas.length-1];

        int circuitSize = gas.length;
        int nextStation = startStation < (circuitSize - 1) ? startStation + 1 : 0;
        //int tank = gas[startStation];
        int cost = costs[startStation];

        for (int x = 0; x < circuitSize; x++) {
            if (tank - cost < 0) return -1;
            if (nextStation == startStation) return startStation;

            tank = tank - cost + gas[nextStation];
            cost = costs[nextStation];
            nextStation = nextStation < (circuitSize - 1) ? nextStation + 1 : 0;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 3, 4) + " == 3");
    }
}
