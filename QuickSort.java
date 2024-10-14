import java.util.ArrayList;
import java.util.Collections;

public class QuickSort {
    public void sort(ArrayList<Integer> arr, int low, int high, DrawRect rectArr, Visualizer vis) throws InterruptedException {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, rectArr, vis);
            sort(arr, low, pivotIndex - 1, rectArr, vis);
            sort(arr, pivotIndex + 1, high, rectArr, vis);
        }
    }

    private int partition(ArrayList<Integer> arr, int low, int high, DrawRect rectArr, Visualizer vis) throws InterruptedException {
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j) > pivot) {
                i++;
                Collections.swap(arr, i, j);
                updateVisualizer(arr, rectArr, vis);
            }
        }
        Collections.swap(arr, i + 1, high);
        updateVisualizer(arr, rectArr, vis);
        return i + 1;
    }

    private void updateVisualizer(ArrayList<Integer> arr, DrawRect rectArr, Visualizer vis) throws InterruptedException {

        Thread.sleep(30);
        rectArr.setArr(arr);
        rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);
    }
}

