import java.util.*;

// The approach is to use Binary Search on the answer. We consider the maximum possible patient load per clinic as a value and check whether it is feasible using at most k clinics. For each village with population p, the minimum number of clinics required is ceil(p / maxLoad). We calculate this for every village and add the required clinics. If the total number of clinics required is greater than k, the maximum load is too small, so we increase it; otherwise, it is feasible and we try to reduce it. We continue the binary search until we reach the required precision.

public class ClinicAndVillage {

    public static double minimumMaximumLoad(int[] population, int k) {

        double low = 0;
        double high = 0;

        for (int p : population) {
            high = Math.max(high, p);
        }

        // Binary search for precision
        for (int i = 0; i < 100; i++) {

            double mid = (low + high) / 2;

            int clinicsRequired = 0;

            for (int p : population) {
                clinicsRequired += (int) Math.ceil(p / mid);

                if (clinicsRequired > k) {
                    break;
                }
            }

            if (clinicsRequired <= k) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }

    public static void main(String[] args) {

        int[] population = {200, 20, 50};
        int k = 5;

        double answer = minimumMaximumLoad(population, k);

        System.out.printf("%.2f%n", answer);
    }
}