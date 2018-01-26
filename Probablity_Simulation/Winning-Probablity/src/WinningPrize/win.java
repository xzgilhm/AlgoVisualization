package WinningPrize;

//连抽5次,宝箱中有奖概率是20%,问:中奖概率?
public class win {

    private double chance;
    private int playTime;
    private int N;

    //TODO: win()
    public  win(double chance,int playTime,int N){
        this.chance = chance;
        this.playTime = playTime;
        this.N = N;
    }

    //TODO run()
    public void run(){
        int wins = 0;
        for (int i=0;i<N;i++)
            if(play())
                wins ++;

        System.out.println("rate is: " + (double)wins/N);
    }

    //TODO boolean play()
    public boolean play(){
        for(int i=0; i<playTime; i++){
            if((double)Math.random() < chance)
                return true;
        }
        return false;
    }



    public static void main(String[] args){

        double chance = 0.2;
        int playTime = 5;
        int N = 1000000;

        win w = new win(chance,playTime,N);
        w.run();
    }
}
