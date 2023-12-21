public class Trapping_Rain_Water_47 {
    public static void main(String[] args) {
        System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public static int trap(int[] height) {
        int temp;
        int i=0;
        int res = 0;
        int j;
        int sum=0;
        while(i<height.length) {
            temp = height[i];
            j=i;
            while(temp> 0 && i+1<height.length && height[i+1] < temp) {
                sum += (temp - height[i+1]);
                i++;
            }
            if(i + 1 < height.length) {
                res += sum;
                sum = 0;
                i++;
            } else if(sum > 0) {
                i = j;
                sum = 0;
                i--;
            }
        }
        return res;
    }
}
