import java.util.Random;

public class Main{

    private static boolean check_value(int val, int[] arr){
        for(int i : arr){
            if(i == val){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        // create array r with even numbers [16 - 2] 
        int[] q = {16, 14, 12, 10, 8, 6, 4, 2};
        
        // array x with random floats (-7.0 - 3.0)
        float[] x = new float[11];
        Random rand = new Random();
        for(int i =0; i < 11; i++){
            x[i] = rand.nextFloat(10) - 7; 
        }

        double[][] h = new double[8][11];


        for(int i = 0; i < 8; i++){ // calc values of h
            for(int j = 0; j < 11; j++){
                double xj = x[j];

                int[] temp = {2, 6, 14, 16};

                if(q[i] == 10){
                    double base = Math.atan(Math.sin(xj) + 1/3) / Math.atan(Math.cos(xj));
                    double power = Math.pow(xj / (xj + 1/4), 3) + 3/4;
                    power /= Math.atan((xj - 2) / 1 * Math.E + 1);
                    power = Math.pow(power, 2);
                    h[i][j] = Math.pow(base, power);
                }

                else if(check_value(q[i], temp)){ // if temp array contains value 
                    double base = Math.tan(Math.log(Math.abs(xj)));
                    double power = Math.PI * (Math.pow(Math.E, Math.pow(xj, xj/2)) - 1);
                    h[i][j]= Math.pow(base, power);
                }

                else{
                    h[i][j] = Math.tan(Math.sin(Math.sin(1/3 / xj - 1)));
                }

                System.out.printf("%.3f ", h[i][j]); // print line 
            }
            System.out.print('\n');
        }

        
    }

}