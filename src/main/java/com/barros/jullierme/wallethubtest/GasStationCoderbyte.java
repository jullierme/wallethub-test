package com.barros.jullierme.wallethubtest;

import java.util.Scanner;
/*Gas Station
Have the function GasStation(strArr) take strArr which will be an an array consisting of the
following elements: N which will be the number of gas stations in a circular route and each subsequent
element will be the string g:c where g is the amount of gas in gallons at that gas station and c will
be the amount of gallons of gas needed to get to the following gas station. For example strArr may
be: ["4","3:1","2:2","1:2","0:1"]. Your goal is to return the index of the starting gas station that
will allow you to travel around the whole route once, otherwise return the string impossible.
For the example above, there are 4 gas stations, and your program should return the string 1 because
starting at station 1 you receive 3 gallons of gas and spend 1 getting to the next station.
Then you have 2 gallons + 2 more at the next station and you spend 2 so you have 2 gallons when you get
to the 3rd station. You then have 3 but you spend 2 getting to the final station, and at the final
station you receive 0 gallons and you spend your final gallon getting to your starting point.
Starting at any other gas station would make getting around the route impossible, so the answer is 1.
If there are multiple gas stations that are possible to start at, return the smallest index (of the gas station).
N will be >= 2.

Hard challenges are worth 15 points and you are not timed for them.
Examples
Input: new String[] {"4","1:1","2:2","1:2","0:1"}
Output: "impossible"
Input: new String[] {"4","0:1","2:2","1:2","3:1"}
Output: "4"
*/
class GasStationCoderbyte {
    private static final String IMPOSSIBLE = "impossible";


    public static String GasStation(String[] strArr) {
        int circuitSize = strArr.length - 1;
        System.out.println("circuitSize " + circuitSize);

        int[] gas = new int[circuitSize];
        int[] costs = new int[circuitSize];

        for (int x = 1; x <= circuitSize; x++) {
            String[] gasAndCost = strArr[x].split(":");
            gas[x - 1] = Integer.parseInt(gasAndCost[0]);
            costs[x - 1] = Integer.parseInt(gasAndCost[1]);
        }

        for (int station = 0; station < circuitSize; station++) {
            String startIndex = getStartIndex(gas, costs, station);
            if (!IMPOSSIBLE.equals(startIndex)) return startIndex;
        }

        // code goes here
        return IMPOSSIBLE;
    }

    private static String getStartIndex(int[] gas, int[] costs, int startStation) {
        int circuitSize = gas.length;
        int nextStation = startStation < (circuitSize - 1) ? startStation + 1 : 0;
        int currentStation = startStation;
        int tank = 0;
        for (int x = 0; x < circuitSize; x++) {
            tank = tank - costs[currentStation] + gas[currentStation];

            if (tank < 0) return IMPOSSIBLE;
            if (x == circuitSize - 1) return String.valueOf(startStation + 1);//+1 because start with zero

            nextStation = nextStation < (circuitSize - 1) ? nextStation + 1 : 0;
            currentStation = currentStation < (circuitSize - 1) ? currentStation + 1 : 0;
        }

        return IMPOSSIBLE;
    }


    public static void main(String[] args) {
        System.out.println(GasStation(new String[] {"4","3:1","2:2","1:2","0:1"}) + " == 1");
        System.out.println(GasStation(new String[] {"4","1:1","2:2","1:2","0:1"}) + " == impossible");
        System.out.println(GasStation(new String[] {"4","0:1","2:2","1:2","3:1"}) + " == 4");
    }

}
