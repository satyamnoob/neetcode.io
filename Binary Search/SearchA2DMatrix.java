class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            // Figure out if the num is in this row and then find it...
            if(target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length - 1]) {
                int lowInner = 0, highInner = matrix[0].length - 1;
                while(lowInner <= highInner) {
                    int midInner = lowInner + (highInner - lowInner) / 2;

                    if(matrix[mid][midInner] == target) {
                        return true;
                    } else if(matrix[mid][midInner] < target) {
                        lowInner = midInner + 1;
                    } else {
                        highInner = midInner - 1;
                    }
                }

                return false;
            } else if(target < matrix[mid][0]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}