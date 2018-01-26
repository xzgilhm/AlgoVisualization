import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class AlgoVisualizer {

    //创建自己的数据
    private MonteCarloPiData data;
    private int N;
    private static int DELAY = 40;// 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){
        if(sceneHeight != sceneWidth)
            throw new IllegalArgumentException("Must square");
        // 初始化数据
        this.N = N;
        Circle circle = new Circle(sceneWidth/2,sceneHeight/2,sceneWidth/2);
        data = new MonteCarloPiData(circle);
        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Get pi", sceneWidth, sceneHeight);

            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){

        //绘制
        for(int i=0;i<N;i++){
            if(i % 100 == 0){
                frame.render(data);
                AlgoVisHelper.pause(DELAY);
                System.out.println(data.estimatePi());
            }

            int x = (int)(Math.random() * frame.getCanvasWidth());
            int y = (int)(Math.random() * frame.getCanvasHeight());
            data.addPoint(new Point(x,y));
        }
    }


    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 20000;

        //  根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight,N);
    }
}