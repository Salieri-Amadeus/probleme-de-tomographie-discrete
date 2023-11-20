import java.awt.Color; 
import java.awt.Graphics; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
import java.io.File; 
import java.io.IOException; 
import java.util.Scanner; 

public class GridVisualizer {
    public static void main(String[] args) throws IOException {

        // 读取文本文件
        File file = new File("input.txt"); // 创建 File 对象以指向您的文本文件
        Scanner scanner = new Scanner(file); // 创建 Scanner 对象来读取文件内容

        int rows = 0; 
        int cols = 0;
        String[][] grid = new String[100][100]; // 创建一个字符串数组，假设最大为 100x100 的网格

        // 解析文本文件并填充数组
        while (scanner.hasNextLine()) {
            // 循环读取文件中的每一行
            String[] line = scanner.nextLine().trim().split("\\s+"); // 将每行分割为单词数组, \\s+ = .+ (正则表达式)
            cols = line.length; // 获取列数
            for (int i = 0; i < cols; i++) {
                grid[rows][i] = line[i]; // 将单词填入对应的数组位置
            }
            rows++; // 行数增加
        }
        scanner.close(); // 关闭 Scanner 对象

        // 创建图像
        int cellSize = 50; // 设置每个格子的大小
        BufferedImage image = new BufferedImage(cols * cellSize, rows * cellSize, BufferedImage.TYPE_INT_ARGB);
        // 创建一个新的 BufferedImage 实例，大小根据行列数和格子大小计算
        Graphics graphics = image.getGraphics(); // 获取图像的 Graphics 对象以进行绘图

        // 绘制格子
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                // 遍历每个格子
                if (grid[y][x].equals("Black")) {
                    // 如果格子内容为 "Black"，设置绘图颜色为黑色
                    graphics.setColor(Color.BLACK);
                } else {
                    // 否则设置为白色
                    graphics.setColor(Color.WHITE);
                }
                graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                // 绘制一个填充矩形代表格子
            }
        }

        // 保存图像
        ImageIO.write(image, "png", new File("output.png")); // 将绘制好的图像保存为 PNG 文件
    }
}
