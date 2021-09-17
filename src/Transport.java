import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transport extends JPanel implements ActionListener {
    Timer timer = new Timer(15, this);
    int x = 1;
    int y = 1;
    int z = 1;
    int velocityX = 1;
    int velocityY = 1;
    int velocityZ = 1;
    Image plane;
    Image train;

    public Transport() {
        this.setBounds(450, 370, 400, 400);
        this.setOpaque(false);

        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        plane = new ImageIcon("out/images/plane_up.png").getImage();
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(plane, x, y, null);

        train = new ImageIcon("out/images/train.png").getImage();
        g2D.drawImage(train, 100, z, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x>=240 || x<=0){
            velocityX = -velocityX;
        }
        if (y>=240 || y<=0) {
            velocityY = -velocityY;
        }
        if (z>=260 || z<=0) {
            velocityZ = -velocityZ;
        }

        x= x+velocityX;
        y= y+velocityY;
        z = z+velocityZ;
        repaint();
    }
}
