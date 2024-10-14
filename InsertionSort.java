import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {
    public void sort(ArrayList<Integer> arr, DrawRect rectArr, Visualizer vis) throws InterruptedException {
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) < arr.get(i + 1)) {
                Collections.swap(arr, i, i + 1);

                Thread.sleep(30);
                rectArr.setArr(arr);
                rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);

                for (int j = i; j > 0; j--) {
                    if (arr.get(j) > arr.get(j - 1)) {
                        Collections.swap(arr, j, j - 1);

                        Thread.sleep(30);
                        rectArr.setArr(arr);
                        rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);

                        System.out.println(arr);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}

