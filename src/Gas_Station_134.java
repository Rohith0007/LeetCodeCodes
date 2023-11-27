public class Gas_Station_134 {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[] {1,2,3,4,5,5,70}, new int[] {2,3,4,3,9,6,2}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int max = 0;
        boolean flag = true;
        if(length==1) {
            if(gas[0] >= cost[0]) {
                return 0;
            } else {
                return -1;
            }
        }

        for (int i = 0; i < length; i++) {
            max += gas[i];
            if (max <= 0) {
                flag=false;
            }
            for (int j = i; j < length + i - 1; j++) {
                if (j <= length - 1) {
                    if (max < cost[j]) {
                        flag = false;
                        break;
                    }
                } else {
                    if (max < cost[(j - length) % length]) {
                        flag = false;
                        break;
                    }
                }

                if (j < length - 1) {
                    max = max - cost[j] + gas[j + 1];
                } else {
                    if (j > length - 1) {
                        max = max - cost[(j - length) % length] + gas[(j - length + 1) % length];
                    } else if (j == length - 1) {
                        max = max - cost[j] + gas[0];
                    }
                }
                if (max <= 0) {
                    flag=false;
                    break;
                }
            }
            if (flag) {
                if (i == 0) {
                    if (max >= cost[length - 1]) {
                        return i;
                    }
                } else {
                    if (max >= cost[i - 1]) {
                        return i;
                    }
                }
            }
            max = 0;
            flag = true;
        }
        return -1;
    }
}
