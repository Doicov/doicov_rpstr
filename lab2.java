import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lab2 {
    public static void main(String[] args) {
        String t = JOptionPane.showInputDialog("Enter text");
        System.out.println("Enter the text" + t);
        Word word = new Word(t);
        StringBuffer answer = word.modifiedText();
        System.out.print("ModifiedText: " + answer);
    }
}

class Paragraph {
    String text;

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class Word extends Paragraph { // Наследование
    Paragraph paragraph; // Композиция

    public Word(String text) {
        super(text); // Вызов конструктора суперкласса
        this.paragraph = new Paragraph(text); // Создаем объект Paragraph внутри Word
    }

    public StringBuffer modifiedText() {
        String substring = JOptionPane.showInputDialog("Enter substring ");
        System.out.println("Enter substring" + substring);

        String wordToAdd = JOptionPane.showInputDialog("Enter word ");
        System.out.println("Enter word" + wordToAdd);

        String text = paragraph.getText(); // Получаем текст из объекта Paragraph
        Pattern pattern = Pattern.compile(substring + "\\b");
        Matcher matcher = pattern.matcher(text);

        StringBuffer modifiedText = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(modifiedText, matcher.group() + " " + wordToAdd);
        }
        StringBuffer newText = matcher.appendTail(modifiedText);
        return newText;
    }
}
