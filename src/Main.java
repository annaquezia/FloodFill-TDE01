import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedImage img1 = ImageIO.read(new File("img/img.png"));
        BufferedImage img2 = ImageIO.read(new File("img/img.png"));

        int startX = 170, startY = 50;
        int corAlvo = Color.WHITE.getRGB();
        int novaCor = Color.MAGENTA.getRGB();
        int saveStep = 50000;

        ProcessarImagem.floodFillPilha(img1, startY, startX, novaCor, corAlvo, saveStep, "frames");
        ProcessarImagem.floodFillFila(img2, startY, startX, novaCor, corAlvo, saveStep, "frames");
    }
}