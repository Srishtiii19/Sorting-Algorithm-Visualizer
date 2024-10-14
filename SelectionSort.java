import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {

    public void sort(ArrayList<Integer> arr, DrawRect rectArr, Visualizer vis) throws InterruptedException {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr.get(j) > arr.get(maxIndex)) {
                    maxIndex = j;
                }

                rectArr.setArr(arr);
                rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);
                Thread.sleep(10);
            }

            if (maxIndex != i) {
                Collections.swap(arr, i, maxIndex);
            }

            rectArr.setArr(arr);
            rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);
            Thread.sleep(10);
        }
    }
}
