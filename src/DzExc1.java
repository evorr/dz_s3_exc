public class DzExc1 {
    // 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
    // MyArrayDataException и вывести результат расчета (сумму элементов, при условии что подали на вход
    // корректный массив).

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException{
        int sum = 0;
        String[][] matrix = {{"1", "0", "4", "0"},
                {"u", "0", "4", "6"},
                {"1", "9", "t", "0"},
                {"1", "0", "4", "0"}};
        try{
            sum = fourXFour(matrix);
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }
        System.out.println(sum);
    }

    // 1. Напишите метод, на вход которого подаётся двумерный строковый массив
    // размером 4х4, при подаче массива другого размера необходимо бросить
    // исключение MyArraySizeException.

    public static int fourXFour(String[][] matrix) {
        if (matrix.length != 4 || matrix[0].length != 4) {
            throw new MyArraySizeException();
        }
        int result = 0;
        result = sum(matrix);
        return result;
    }

    // 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int,
    // и просуммировать. Если в каком-то элементе массива преобразование не удалось
    // (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
    // исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.

    private static int sum(String [][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int val = 0;
                try {
                    val = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
                sum += val;
            }
        }
        return sum;
    }
}
