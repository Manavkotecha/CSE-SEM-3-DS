
public class Lab19_93 {

    public static void main(String[] args) {
        int[] a = {50, 40, 30, 20, 10};
        int n = a.length;
        int i = 1;
        while (i < n) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
            i++;
        }

        for (int k = 0; k < n; k++) {
            System.out.print(a[k] + " ");
        }
    }
}
