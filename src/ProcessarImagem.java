import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ProcessarImagem {
    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};

    private static boolean dentro(BufferedImage img, int x, int y) {
        return x >= 0 && y >= 0 && x < img.getWidth() && y < img.getHeight();
    }

    private static void salvarFrame(BufferedImage img, String pasta, String modo, int idx) throws Exception {
        File dir = new File(pasta + "_" + modo);
        if (!dir.exists()) dir.mkdirs();
        File out = new File(dir, "frame_" + idx + ".png");
        ImageIO.write(img, "png", out);
    }

    private static void salvarFinal(BufferedImage img, String pasta, String modo) throws Exception {
        File dir = new File(pasta + "_" + modo);
        if (!dir.exists()) dir.mkdirs();
        File out = new File(dir, "final.png");
        ImageIO.write(img, "png", out);
        System.out.println("Imagem final (" + modo + ") salva em " + out.getPath());
    }


    public static void floodFillPilha(BufferedImage img, int startY, int startX,
                                      int novaCor, int corAlvo, int saveStep, String pasta) throws Exception {
        int altura = img.getHeight();
        int largura = img.getWidth();

        boolean[][] visited = new boolean[altura][largura];
        Pilha pilha = new Pilha(largura * altura);
        pilha.push(new Pixel(startY, startX));
        visited[startY][startX] = true;

        int step = 0;
        while (!pilha.isEmpty()) {

            Pixel p = pilha.pop();

            if (p == null) continue;

            int y = p.getY(), x = p.getX();

            if (img.getRGB(x, y) != corAlvo) continue;

            img.setRGB(x, y, novaCor);

            if (step % saveStep == 0) salvarFrame(img, pasta, "pilha", step / saveStep);

            step++;

            // olha os vizinhos
            for (int i = 0; i < 4; i++) {

                int ny = y + DY[i], nx = x + DX[i];
                if (dentro(img, nx, ny) && !visited[ny][nx]) {
                    pilha.push(new Pixel(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
        salvarFinal(img, pasta, "pilha");
    }


    public static void floodFillFila(BufferedImage img, int startY, int startX,
                                     int novaCor, int corAlvo, int saveStep, String pasta) throws Exception {
        int altura = img.getHeight();
        int largura = img.getWidth();

        boolean[][] visited = new boolean[altura][largura];
        Fila fila = new Fila(largura * altura);
        fila.enqueue(new Pixel(startY, startX));
        visited[startY][startX] = true;

        int step = 0;
        while (!fila.isEmpty()) {
            Pixel p = fila.dequeue();
            if (p == null) continue;
            int y = p.getY(), x = p.getX();

            if (img.getRGB(x, y) != corAlvo) continue;

            img.setRGB(x, y, novaCor);

            if (step % saveStep == 0) salvarFrame(img, pasta, "fila", step / saveStep);
            step++;

            for (int i = 0; i < 4; i++) {
                int ny = y + DY[i], nx = x + DX[i];
                if (dentro(img, nx, ny) && !visited[ny][nx]) {
                    fila.enqueue(new Pixel(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
        salvarFinal(img, pasta, "fila");
    }
}