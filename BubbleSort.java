import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public void sort(ArrayList<Integer> arr, DrawRect rectArr, Visualizer vis) throws InterruptedException {
        boolean swapped;
        for (int i = 0; i < arr.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.size() - 1 - i; j++) {
                if (arr.get(j) < arr.get(j + 1)) {
                    Collections.swap(arr, j, j + 1);
                    swapped = true;
                    Thread.sleep(20);
                    rectArr.setArr(arr);
                    rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);
                }
            }
            if (!swapped) break;
            System.out.println(arr);
        }
    }
}
