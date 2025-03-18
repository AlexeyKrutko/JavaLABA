public class Main {
    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        int[] weights = {1, 2, 10};

        Array array = new Array(values, weights);
        array.createWeightedArray();

        System.out.println("Случайные значения с учетом весов:");
        for (int i = 0; i < 10; i++) {
            System.out.println(array.getRandomValue());
        }
    }
}