package hw10;

public class HW10_4108042003_3 extends Buy_Phone{
	
    public int[][] bestPhone(final int[][] inputArr){
        int len = inputArr.length, newLen = len, i, j;

        for(i = 0; i < len-1; i++){
            if(inputArr[i] == null){
                newLen--;
                continue;
            }
            for(j = len-1; j > i;j--){
                if(inputArr[j] == null) {
                }
                else {
                    assert inputArr[i] != null;
                    if(inputArr[i][0]<=inputArr[j][0] && inputArr[i][1] <= inputArr[j][1]){
                        inputArr[i] = null;
                        newLen--; break;
                    }
                }
            }
        }
        int [][] ans = new int [newLen][];
        for(i =0, j=0; i < len; i++){
            if(inputArr[i]!= null){
                ans[j++] = inputArr[i];
            }
        }
        return ans;
    }
}
