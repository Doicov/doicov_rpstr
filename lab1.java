
import javax.swing.*;

public class lab1 {
    public static void main(String[] args) {
        
        // Запрос ввода текста
        String text = JOptionPane.showInputDialog("Введите текст");
        System.out.println(text);
      
        // Запрос ввода подстроки для поиска
        String substring = JOptionPane.showInputDialog("Введите текст для поиска");
        System.out.println(substring);
    
        // Запрос ввода слова для добавления
        String wordToAdd = JOptionPane.showInputDialog("Введите слово для добавления");
        System.out.println(wordToAdd);
    
        // Разделение введенного текста на слова
        String[] words = text.split(" ");
        StringBuilder modifiedText = new StringBuilder();
    
        // Обработка каждого слова
        for (String word : words) {
          modifiedText.append(word);
            if (word.endsWith(substring)) {
              modifiedText.append(" " + wordToAdd);
            }
            modifiedText.append(" ");
        }
    
        // Вывод измененного текста
        System.out.println("Измененный текст: " + modifiedText.toString().trim());
        JOptionPane.showMessageDialog(null, modifiedText);
    }
} 
