public class Array {
    private int[]mas1;
    private int[]mas2;
    private int[]mas3;

    public Array(int[] values, int[] weights) {
        this.mas1 = values;
        this.mas2 = weights;
    }

    public void createWeightedArray() {
        int sizeMas3 = 0;
        for (int i = 0; i < mas2.length; i++) {
            sizeMas3 += mas2[i];
        }
        mas3 = new int[sizeMas3];
        int index = 0; //текущая позиция в mas3
        for (int i = 0; i < mas1.length; i++) {
            for (int j = 0; j < mas2[i]; j++) {
                mas3[index++] = mas1[i];
            }
        }
    }

    public int getRandomValue() {
        int randomIndex =  (int)(Math.random() * (mas3.length-1));
        return mas3[randomIndex];
    }
}
