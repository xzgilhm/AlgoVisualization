package ThreeGates;

public class ThreeGatesSimulate {

    private int N;

    public ThreeGatesSimulate(int N){

        if(N <= 0)
            throw new IllegalArgumentException("N must larger than 0");

        this.N = N;
    }


    public void run(boolean changeDoor){

        int wins = 0;
        for(int i =0 ; i < N; i++)
            if(play(changeDoor))
                wins ++;

        System.out.println(changeDoor ? "Change" : "Not change");
        System.out.println("winning rate: " + (double)wins/N);
    }


    private boolean play(boolean changeDoor){
        // door 0,1,2
        int prizeDoor = (int)(Math.random() * 3);
        int playerChoice = (int)(Math.random() * 3);

        if( playerChoice == prizeDoor)
            return changeDoor ? false : true;
        else
            return changeDoor ? true : false;
    }

    public static void main(String[] args) {

        int N = 10000000;
        ThreeGatesSimulate tgs = new ThreeGatesSimulate(N);
        tgs.run(true);
        System.out.println();
        tgs.run(false);

    }
}
