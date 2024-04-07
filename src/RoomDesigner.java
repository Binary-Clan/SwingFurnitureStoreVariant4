import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoomDesigner {
    private JComboBox<String> shapeComboBox;
    private JComboBox<String> sizeComboBox;
    private JButton colorButton;
    private JButton loadButton;

    public RoomDesigner() {
        JFrame frame = new JFrame("Room Designer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Using GridLayout for a more structured layout
        frame.setLayout(new GridLayout(0, 2, 10, 10)); // 0 rows means any number of rows, 2 columns, and 10px spacing
        frame.setMinimumSize(new Dimension(300,200)); // Adjusted the size for better fit of GridLayout

        // Define a new color palette
        Color foregroundColor = new Color(0, 0, 0); // A deep blue
        Color backgroundColor = new Color(0, 229, 164); // A light blue

        // Shape selection
        shapeComboBox = new JComboBox<>(new String[]{"Square", "Rectangle", "Circle"});
        shapeComboBox.setBackground(backgroundColor);
        shapeComboBox.setForeground(foregroundColor);
        shapeComboBox.setSelectedItem("Rectangle");
        frame.add(new JLabel("Select Shape: "));
        frame.add(shapeComboBox);

        // Size selection
        sizeComboBox = new JComboBox<>(new String[]{"Small", "Medium", "Large"});
        sizeComboBox.setBackground(backgroundColor);
        sizeComboBox.setForeground(foregroundColor);
        sizeComboBox.setSelectedItem("Medium");
        frame.add(new JLabel("Select Size: "));
        frame.add(sizeComboBox);

        // Color selection
        colorButton = new JButton("Select Color");
        colorButton.setBackground(backgroundColor);
        colorButton.setForeground(foregroundColor);
        colorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(frame, "Choose Color", Color.WHITE);
            if (selectedColor != null) {
                colorButton.setBackground(selectedColor);
            }
        });
        frame.add(colorButton);

        // Load button
        loadButton = new JButton("Load Design");
        loadButton.setBackground(backgroundColor);
        loadButton.setForeground(foregroundColor);
        loadButton.addActionListener(e -> {
            loadDesign();
            frame.dispose();
        });
        frame.add(loadButton);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void loadDesign() {
        String selectedShape = (String) shapeComboBox.getSelectedItem();
        String selectedSize = (String) sizeComboBox.getSelectedItem();
        Color selectedColor = colorButton.getBackground();

        // Initialize TwoDViwer form with selected values
        SwingUtilities.invokeLater(() -> {
            TwoDViwer viewer = new TwoDViwer(selectedShape, selectedSize, selectedColor); // Assuming TwoDViwer class exists and can handle these parameters
            viewer.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RoomDesigner::new);
    }
}
