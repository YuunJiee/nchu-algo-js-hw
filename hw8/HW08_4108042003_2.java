package hw8;

public class HW08_4108042003_2 extends MaxLandArea{
    private int[] parent;
    private int[] size;
    private int maxLand;
	    
    public int maxLandArea(int[][] array) {
        int m = array.length;
        int n = array[0].length;
        int total = m * n;
        parent = new int[total];
        size = new int[total];
        for (int i = 0; i < total; i++) {
        	size[i] = 1; 
            parent[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 1) {
                    int id = i * n + j;
                    if (i > 0 && array[i - 1][j] == 1) {
                        union(id, id - n);
                    }
                    if (j > 0 && array[i][j - 1] == 1) {
                        union(id, id - 1);
                    }
                }
            }
        }
        
        return maxLand;
    }
    
    private int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
            maxLand = Math.max(maxLand, size[rootQ]);
        }
    }
}
