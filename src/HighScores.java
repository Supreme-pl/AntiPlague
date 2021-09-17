import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class HighScores {

    JFrame frame;
    JList list;
    JButton back;
    DefaultListModel<String> highscorez = new DefaultListModel<>();

    public HighScores() {
        frame = new JFrame("Anti-PlaGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        list = new JList();
        list.setFont(new Font("Arial", Font.BOLD, 40));
        list.setBackground(Color.decode("#261F2E"));
        list.setForeground(Color.white);
        for(String s : GetHighScore())
            getHighscorez().addElement(s);
        list.setModel(highscorez);
        list.setBounds(0,0,760,760);

        list.setVisibleRowCount(50);
        back = new JButton();
        back.setText("Back to Main Menu");
        back.setFont(new Font("Arial", Font.BOLD, 30));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenu();
            }
        });
        back.setEnabled(true);
        back.setBounds(20, 20, 30, 20);

        frame.add(back);
        frame.add(new JScrollPane(list));
        frame.setResizable(false);
        frame.setLayout(new GridLayout());
        frame.pack();
        frame.setSize(760, 760);
        frame.setLocationRelativeTo(null);
        frame.setVisible(false);
    }
    private ArrayList<String> GetHighScore() {
        ArrayList<String> hScore = new ArrayList<>();
        FileReader readFile = null;
        BufferedReader reader = null;
        try
        {
            File file = new File("highscore.dat");
            readFile = new FileReader("highscore.dat");
            reader = new BufferedReader(readFile);

            for(int i = 0; i <= (int)file.length(); i++)
                hScore.add(reader.readLine());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (reader!=null)
                    reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return hScore;
    }

    public JButton getBack() {
        return back;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JList getList() {
        return list;
    }

    public DefaultListModel<String> getHighscorez() {
        return highscorez;
    }
}
