import java.util.ArrayList;

public class MergeSort {
    public void sort(ArrayList<Integer> arr, int start, int end, DrawRect rectArr, Visualizer vis) throws InterruptedException {

        if (end - start < 1) {
            return;
        }
        int mid = (start + end) / 2;

        sort(arr, start, mid, rectArr, vis);
        sort(arr, mid + 1, end, rectArr, vis);

        merge(arr, start, mid, end, rectArr, vis);
    }

    private void merge(ArrayList<Integer> arr, int start, int mid, int end, DrawRect rectArr, Visualizer vis) throws InterruptedException {
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr.get(start + i);
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = arr.get(mid + 1 + j);
        }

        int i = 0, j = 0, k = start;

        while (i < left.length && j < right.length) {
            if (left[i] >= right[j]) { // Change comparison to >= for descending order
                arr.set(k, left[i]);
                i++;
            } else {
                arr.set(k, right[j]);
                j++;
            }
            k++;

            updateVisualizer(arr, rectArr, vis);
        }

        while (i < left.length) {
            arr.set(k, left[i]);
            i++;
            k++;

            updateVisualizer(arr, rectArr, vis);
        }

        while (j < right.length) {
            arr.set(k, right[j]);
            j++;
            k++;

            updateVisualizer(arr, rectArr, vis);
        }
    }

    private void updateVisualizer(ArrayList<Integer> arr, DrawRect rectArr, Visualizer vis) throws InterruptedException {
        Thread.sleep(40);
        rectArr.setArr(arr);
        rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);
    }
}

