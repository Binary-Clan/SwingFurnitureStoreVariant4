import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneratingProcess extends JFrame {

    private JProgressBar progressBar;
    private JLabel loadingLabel;
    private Timer progressTimer;
    private Timer blinkTimer;

    public GeneratingProcess() {
        setTitle("Loading Progress");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create a panel for the content
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(new Color(0, 229, 164)); // Set the preferred green background color

        // Create a panel for the title
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(new Color(0, 229, 164)); // Match the background color
        JLabel titleLabel = new JLabel("Loading in Progress");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font and size
        titleLabel.setForeground(Color.BLACK); // Set text color to black
        titlePanel.add(titleLabel);
        contentPanel.add(titlePanel, BorderLayout.NORTH);

        // Create a panel for the progress bar
        JPanel progressBarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true); // Use an indeterminate progress bar for unknown progress
        progressBar.setPreferredSize(new Dimension(400, 30)); // Adjust size
        progressBarPanel.add(progressBar);
        progressBarPanel.setBackground(new Color(0, 229, 164)); // Match the background color
        contentPanel.add(progressBarPanel, BorderLayout.CENTER);

        // Create a panel for the loading label
        JPanel loadingLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        loadingLabel = new JLabel("Loading...");
        loadingLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font and size
        loadingLabel.setForeground(Color.BLACK); // Set text color to black
        loadingLabelPanel.add(loadingLabel);
        loadingLabelPanel.setBackground(new Color(0, 229, 164)); // Match the background color
        contentPanel.add(loadingLabelPanel, BorderLayout.SOUTH);

        // Set content panel to the frame
        getContentPane().add(contentPanel);

        // Simulate progress
        simulateProgress();

        setVisible(true);
    }

    private void simulateProgress() {
        int delay = 500; // Milliseconds
        progressTimer = new Timer(delay, new ActionListener() {
            private int progressValue = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                progressValue += 10;
                if (progressValue >= 100) {
                    progressTimer.stop(); // Stop the progress timer
                    loadingLabel.setText("Loading Complete!"); // Change label text
                    progressBar.setIndeterminate(false); // Stop indeterminate progress
                    progressBar.setValue(100); // Set progress to 100%
                    blinkTimer.stop(); // Stop the blink timer

                    // Show message dialog with custom button
                    showMessageDialogWithCustomButton();
                }
            }
        });
        progressTimer.start();

        // Blinking loading label
        int blinkDelay = 500; // Milliseconds
        blinkTimer = new Timer(blinkDelay, new ActionListener() {
            private boolean isVisible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                loadingLabel.setVisible(isVisible);
                isVisible = !isVisible;
            }
        });
        blinkTimer.start();
    }

    private void showMessageDialogWithCustomButton() {
        // Custom button text
        final JOptionPane optionPane = new JOptionPane("Loading Complete!",
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        final JDialog dialog = new JDialog(this, "Dialog", true);
        dialog.setContentPane(optionPane);

        // Adding "Show 3D View" button
        JButton show3DViewButton = new JButton("View in 3D");
        show3DViewButton.addActionListener(e -> {
            dispose(); // Close the current window

            // Show the 3D view, assuming ModelViewer class exists and is prepared to be called like this
             ModelViewer.main(new String[]{});
        });

        optionPane.add(show3DViewButton);

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GeneratingProcess::new);
    }
}
