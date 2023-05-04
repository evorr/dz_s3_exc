public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(int i, int j){
        super(String.format("в ячейке [%d][%d] не число", i, j));
    }
}
