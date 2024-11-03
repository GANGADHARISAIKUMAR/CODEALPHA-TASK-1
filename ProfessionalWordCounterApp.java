
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessionalWordCounterApp extends JFrame {

    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public ProfessionalWordCounterApp() {
        // Set up the frame
        setTitle("Professional Word Counter");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set background color for the content pane
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(50, 50, 50)); // Dark background color
        contentPane.setLayout(new BorderLayout(10, 10)); // Add padding
        setContentPane(contentPane);

        // Create and style components
        createComponents();

        // Add components to the frame
        contentPane.add(createTitlePanel(), BorderLayout.NORTH);
        contentPane.add(new JScrollPane(textArea), BorderLayout.CENTER);
        contentPane.add(createBottomPanel(), BorderLayout.SOUTH);
    }

    private void createComponents() {
        // Text Area (User Input)
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setBackground(new Color(240, 240, 240)); // Light background for text area
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Word Count Button
        countButton = new JButton("Count Words");
        countButton.setFont(new Font("Arial", Font.BOLD, 16));
        countButton.setBackground(new Color(30, 144, 255)); // Stylish button color
        countButton.setForeground(Color.WHITE);
        countButton.setFocusPainted(false);
        countButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Result Label
        resultLabel = new JLabel("Word Count: 0");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setForeground(new Color(240, 240, 240)); // Light color for visibility on dark background
    }

    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(50, 50, 50));
        JLabel titleLabel = new JLabel("Professional Word Counter");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(240, 240, 240)); // Light color for title
        titlePanel.add(titleLabel);
        return titlePanel;
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(new Color(50, 50, 50));

        // Add button and result label
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(50, 50, 50));
        buttonPanel.add(countButton);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        bottomPanel.add(resultLabel, BorderLayout.NORTH);

        // Button action to count words
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        return bottomPanel;
    }

    private void countWords() {
        String text = textArea.getText();
        String[] words = text.trim().split("\\s+");
        int wordCount = text.isEmpty() ? 0 : words.length;
        resultLabel.setText("Word Count: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProfessionalWordCounterApp app = new ProfessionalWordCounterApp();
            app.setVisible(true);
        });
    }
}
