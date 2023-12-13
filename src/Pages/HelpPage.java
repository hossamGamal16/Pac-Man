package Pacman.src.Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpPage extends JFrame {

    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 500;

    public HelpPage() {
        initializeComponents();
        setWindowProperties();
        HomePages.stopAudio();
    }

    private void setWindowProperties() {
        setTitle("PacMan Help");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initializeComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contentPanel = createContentPanel();
        add(contentPanel);
    }

    private JPanel createContentPanel() {
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.BLACK);

        JTextArea helpText = createHelpTextArea();
        JScrollPane scrollPane = createScrollPane(helpText);
        JButton backButton = createBackButton();

        JPanel bottomPanel = createBottomPanel(backButton);

        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.add(bottomPanel, BorderLayout.SOUTH);

        return contentPanel;
    }

    private JTextArea createHelpTextArea() {
        JTextArea helpText = new JTextArea();
        helpText.setEditable(false);
        helpText.setFont(new Font(Font.SERIF, Font.PLAIN, 22));
        helpText.setForeground(Color.WHITE);
        helpText.setBackground(Color.BLACK);

        helpText.append("Welcome to Instructions of PacMan!\n");
        helpText.append("Controllers: \n\n");
        helpText.append("1) press UP to go UP\n\n");
        helpText.append("2) press DOWN to go DOWN\n\n");
        helpText.append("3) press RIGHT to go RIGHT\n\n");
        helpText.append("4) press LEFT to go LEFT\n\n");
        helpText.append("5) press ESC to Pause the GAME\n\n");
        helpText.append("Have fun playing PacMan!");

        return helpText;
    }

    private JScrollPane createScrollPane(JComponent component) {
        JViewport viewport = new JViewport();
        viewport.setView(component);
        viewport.setScrollMode(JViewport.BLIT_SCROLL_MODE);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewport(viewport);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        return scrollPane;
    }

    private JButton createBackButton() {
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.WHITE);
        backButton.addActionListener(createBackButtonActionListener());
        return backButton;
    }

    private ActionListener createBackButtonActionListener() {
        return (ActionEvent e) -> {
            disposeAndOpenHomePage();
        };
    }

    private void disposeAndOpenHomePage() {
        dispose();
        new HomePages().setVisible(true);
    }

    private JPanel createBottomPanel(JButton backButton) {
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.add(backButton, BorderLayout.CENTER);
        return bottomPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HelpPage helpPage = new HelpPage();
            helpPage.setVisible(true);
        });
    }
}
