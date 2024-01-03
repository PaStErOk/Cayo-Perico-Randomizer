package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import javax.swing.*;

public class Main {

    static JFrame MainMenu = getFrame();
    static JPanel jPanelMainMenu = new JPanel();
    public static void main(String[] args)  throws Exception {
        MainMenu.add(jPanelMainMenu);
        MainMenu.setIconImage(new ImageIcon(new URL("https://static-cdn.jtvnw.net/jtv_user_pictures/a7ffbcd5-6163-4ad8-b5b4-ae0c13bacabf-profile_image-70x70.png")).getImage());
        JButton MainMenuClearLogsButton = new JButton(new EraseResults()); //Добавить сюда кнопку очистки результатов и его подтверждение
        MainMenuClearLogsButton.setText("Очистка результатов рулетки");
        JLabel jResultLabel = new JLabel("Результаты рулеток:");
        JTextArea jResultField = new JTextArea(5,30);
        jResultField.setLineWrap(true);
        JScrollPane jResultsScrollBar = new JScrollPane(jResultField);
        jPanelMainMenu.add(MainMenuClearLogsButton);
        jPanelMainMenu.add(jResultLabel);
        jPanelMainMenu.add(jResultsScrollBar);
        jPanelMainMenu.revalidate();

        KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl B");

    }

    static class EraseResults extends  AbstractAction {

        EraseResults() {
            putValue(AbstractAction.SHORT_DESCRIPTION,"Очистка результатов рулетки");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            PrintWriter EraserResultsJSON = null;
            try {
                EraserResultsJSON = new PrintWriter("src/Data/IDS/Results.json");
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            EraserResultsJSON.print("[]");
            EraserResultsJSON.close();
        }
    }

    static  JFrame getFrame(){
        JFrame MainMenu = new JFrame("Рандомайзер Кайо-Перико");
        MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        MainMenu.setBounds(dimension.width/2 - 250,dimension.height/2 - 150,500,300);
        MainMenu.setVisible(true);
        return  MainMenu;
    }
}
