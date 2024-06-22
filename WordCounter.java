import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JButton countButton;
    private JLabel wordCountLabel;

    public WordCounter() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        countButton = new JButton("Count Words");
        countButton.addActionListener(this);
        add(countButton, BorderLayout.SOUTH);

        wordCountLabel = new JLabel("Word Count: 0");
        add(wordCountLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String text = textArea.getText();
            int wordCount = countWords(text);
            wordCountLabel.setText("Word Count: " + wordCount);
        }
    }

    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WordCounter::new);
    }
}
