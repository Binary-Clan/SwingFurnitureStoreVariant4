import javax.swing.*;
import java.awt.image.BufferedImage;

public class DesignViewer extends JFrame {

    private final Viewer viewer;

    public DesignViewer(BufferedImage canvas) {

        setTitle("2D Design Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);
        viewer = new Viewer(canvas);
        add(viewer);
        setVisible(true);
    }
}

