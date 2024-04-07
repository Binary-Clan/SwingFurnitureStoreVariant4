import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

public class ModelViewer {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("View the Model");
            frame.setLayout(new BorderLayout()); // Use BorderLayout to manage the main layout

            final JFXPanel fxPanel = new JFXPanel();
            frame.add(fxPanel, BorderLayout.CENTER); // The WebView will take up the central part of the layout

            // Create a vertical box layout panel for buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            buttonPanel.setBackground(new Color(0, 229, 164)); // Set the preferred green background color

            // Create and style buttons
            JButton saveButton = styleButton(new JButton("Save"));
            JButton editButton = styleButton(new JButton("Edit"));
            JButton deleteButton = styleButton(new JButton("Delete"));
            JButton returnButton = styleButton(new JButton("Return"));

            // Add action listeners for the buttons
            addActionButtonListeners(frame, saveButton, editButton, deleteButton, returnButton);

            // Add buttons to the panel
            buttonPanel.add(saveButton);
            buttonPanel.add(editButton);
            buttonPanel.add(deleteButton);
            buttonPanel.add(returnButton);

            // Add some spacing between buttons
            buttonPanel.add(Box.createVerticalGlue());

            // Add the panel of buttons to the left of the frame
            frame.add(buttonPanel, BorderLayout.WEST);

            frame.setSize(900, 700);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            Platform.runLater(() -> initFX(fxPanel));
        });
    }

    private static JButton styleButton(JButton button) {
        button.setBackground(new Color(0, 229, 164)); // Set background to green
        button.setForeground(Color.BLACK); // Set text color to black
        button.setFont(new Font("Arial", Font.BOLD, 12)); // Changed font for a new look
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align buttons in the BoxLayout
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height)); // Make buttons take full width of the panel
        return button;
    }

    private static void addActionButtonListeners(JFrame frame, JButton saveButton, JButton editButton, JButton deleteButton, JButton returnButton) {
        saveButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,
                    "Successfully saved to your directory",
                    "Save Successful",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        editButton.addActionListener(e -> frame.dispose());

        deleteButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(frame,
                    "Are you sure?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                frame.dispose();
            }
        });

        returnButton.addActionListener(e -> frame.dispose());
    }

    private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        WebView webView = new WebView();
        webView.getEngine().load("https://sketchfab.com/3d-models/86091129fc304b5d951dbd5352dcb04f/embed");

        Scene scene = new Scene(webView);
        fxPanel.setScene(scene);
    }
}
