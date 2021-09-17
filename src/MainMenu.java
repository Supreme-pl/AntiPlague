import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenu extends JFrame {
    public MainMenu() {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jButton1 = new JButton("New Game");
        jButton1.setFont(new Font("Arial", Font.PLAIN, 40));
        jButton1.setForeground(Color.BLUE);
        JButton jButton2 = new JButton("High Scores");
        jButton2.setFont(new Font("Arial", Font.PLAIN, 40));
        JButton jButton3 = new JButton("Quit");
        jButton3.setFont(new Font("Arial", Font.PLAIN, 40));

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                JOptionPane.showMessageDialog(null, "Welcome to Anti-PlaGUI!\n" +
                        "Your journey begins in Europe, your goal is to stop spreading the virus, \n" +
                        "by achieving completion of cure, and sending it to every country.\n" +
                        "You start your game with 7300 points, and they're reducing by every day.\n" +
                        "The game ends when all people are cured, all of them are infected, or two years pass.\n" +
                        "Try to keep the highest score possible. You have two years to end the pandemics.\n" +
                        "You earn money by sending european people on quarantine, points can be exchanged for a lot of game changers.\n" +
                        "You can exit the game by shortcut Ctrl+Shift+Q, but your run will not be included on the latest runs board.\n" +
                        "Good luck!");
                String[] difficulties = {"Easy", "Harder"}; //3x wyzsze ceny, ale 1.5x wieksze pieniadze, szczepionka 3x dluzej.
                int response = JOptionPane.showOptionDialog(null, "Choose difficulty level",
                        "Difficulty", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, difficulties,
                        "Quit");
                switch (response) {
                    case 0:
                        View v = new View();
                        Country m = new Country();
                        Controller c = new Controller(v, m, new HighScores());

                        c.setMenuBar();
                        c.updateTransport();
                        c.updateLabels();
                        c.controlButtons();
                        c.controlTime();
                        break;
                    case 1:
                        View2 v2 = new View2();
                        Country m2 = new Country();
                        Controller2 c2 = new Controller2(v2, m2, new HighScores());

                        c2.setMenuBar();
                        c2.updateTransport();
                        c2.updateLabels();
                        c2.controlButtons();
                        c2.controlTime();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Didn't expect that.");
                }

                }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                HighScores ha = new HighScores();
                ha.frame.setVisible(true);


            }
        });
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(jButton1);
        frame.add(jButton2);
        frame.add(jButton3);
        frame.setLayout(new GridLayout(3, 1));
        frame.setResizable(false);
        frame.setSize(1024, 760);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
