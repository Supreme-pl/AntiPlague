import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transport2 extends JPanel implements ActionListener {
    Timer timer = new Timer(30, this);
    int x = 1;
    int y = 1;
    int z = 1;
    int velocityX = 1;
    int velocityY = 1;
    int velocityZ = 1;
    Image plane;
    Image bus;

    public Transport2() {
        this.setBounds(180, 300, 310, 600);
        this.setOpaque(false);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        plane = new ImageIcon("out/images/plane_up.png").getImage();
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(plane, x, y, null);

        bus = new ImageIcon("out/images/train.png").getImage();
        g2D.drawImage(bus, x, z+70, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x>=100 || x<=0){
            velocityX = -velocityX;
        }
        if (y>=100 || y<=0) {
            velocityY = -velocityY;
        }
        if (z>=180 || z<=0) {
            velocityZ = -velocityZ;
        }

        x= x+velocityX;
        y= y+velocityY;
        z = z+velocityZ;
        repaint();
    }
}
