import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class AlgoVisualizer {

    // TODO: 创建自己的数据
    private int DELAY = 40;
    private int[] money;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight){

        // 初始化数据
        money = new int[100];
        for(int i=0;i<100;i++)
            money[i] = 100;

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){

        // TODO: 编写自己的动画逻辑
        while(true){
            //渲染前排序
            Arrays.sort(money);

            frame.render(money);
            AlgoVisHelper.pause(DELAY);

            for(int k=0; k<50; k++){
                for(int i=0; i<money.length; i++){
//                    if(money[i] > 0){
                        int j = (int)(Math.random() * money.length);
                        money[i] -= 1;
                        money[j] += 1;
//                    }
                }
            }


        }
    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 1000;
        int sceneHeight = 800;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}