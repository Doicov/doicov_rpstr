import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AnnotationGUI extends JFrame {
    private JTextField textField;
    private JLabel lastModifiedLabel;
    private JLabel timeLastModifiedLabel;
    private Annotation annotation;
    private JTextArea textArea;

    public AnnotationGUI() {
        super("Annotation");

        // Создаем GUI компоненты
        setSize(600, 200);

        textField = new JTextField(20);
        lastModifiedLabel = new JLabel("Last modified: ");
        timeLastModifiedLabel = new JLabel("Time last modified: ");
        JButton saveButton = new JButton("Save");
        textArea = new JTextArea("Hello World\n", 5, 30);

        // Добавляем компоненты GUI на панель
        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(saveButton);
        panel.add(lastModifiedLabel);
        panel.add(timeLastModifiedLabel);
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        annotation = new Annotation("Hello world", Instant.parse("2023-03-14T21:00:00Z"));
        lastModifiedLabel.setText("Last modified: " + annotation.getLastModified());
        timeLastModifiedLabel.setText("Time last modified: " + annotation.getTimeLastModified() + " seconds");

        // Прикрепляем ActionListener к кнопке сохранения
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                Pattern pattern = Pattern.compile("\\d");
                Matcher matcher = pattern.matcher(text);
                if (matcher.find()) {
                    JOptionPane.showMessageDialog(null, "Text contains a digit!");
                } else {
                    annotation.setText(text);
                    lastModifiedLabel.setText("Last modified: " + annotation.getLastModified());
                    timeLastModifiedLabel.setText("Time last modified: " + annotation.getTimeLastModified() + " seconds");
                    textArea.append(text + "\n");
                }
            }
        });

        // Установить свойства фрейма и показать
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AnnotationGUI();
            }
        });
    }
}
