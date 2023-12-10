package project.pages;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpPage extends JFrame {

    public HelpPage() {
        initComponents();
        setLookAndFeel();
        setWindowProperties();
        HomePages.stopAudio();
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setWindowProperties() {
        setTitle("Pac-Man Help");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
                setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.BLACK);

        JTextArea helpText = new JTextArea();
        helpText.setEditable(false);
        helpText.setFont(new Font("Arial", Font.PLAIN, 14));
        helpText.setForeground(Color.WHITE);
        helpText.setBackground(Color.BLACK);
        helpText.setText(
                "Welcome to Pac-Man!\n\n" +
                        "Objective:\n" +
                        "The goal is to navigate Pac-Man through the maze, eating all the dots while \n avoiding the ghosts.\n\n" +
                        // Rest of the help text
                        "Have fun playing Pac-Man!"
        );

        JViewport viewport = new JViewport();
        viewport.setView(helpText);
        viewport.setScrollMode(JViewport.BLIT_SCROLL_MODE); // Set the scroll mode to blit to hide scroll bars

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewport(viewport);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 14));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current HelpPage window
                HomePages home = new HomePages(); // Create a new HomePages window
                home.setVisible(true); // Show the HomePages window
            }
        });

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.add(back, BorderLayout.CENTER); // Add the "Back" button to the center of the bottom panel

        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.add(bottomPanel, BorderLayout.SOUTH); // Add the bottom panel to the south

        getContentPane().add(contentPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HelpPage helpPage = new HelpPage();
            helpPage.setVisible(true);
        });
    }
}
