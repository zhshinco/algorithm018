public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;


        int low = 0;
        int hight = m * n - 1;

        while (low <= hight) {
            int pivotIdx = (low + hight) / 2;
            int pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) hight = pivotIdx - 1;
                else low = pivotIdx + 1;
            }
        }

        return false;
    }
}
