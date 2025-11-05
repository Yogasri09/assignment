import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ColorChangerFrame extends JFrame implements ActionListener {
    JComboBox<String> colorBox;
    Container container;

    public ColorChangerFrame() {
        setTitle("Background Color Changer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        container = getContentPane();

        String[] colors = {"Select Color", "Red", "Green", "Blue", "Yellow", "Pink"};
        colorBox = new JComboBox<>(colors);
        colorBox.addActionListener(this);

        add(colorBox);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String selected = (String) colorBox.getSelectedItem();
        switch (selected) {
            case "Red":
                container.setBackground(Color.RED);
                break;
            case "Green":
                container.setBackground(Color.GREEN);
                break;
            case "Blue":
                container.setBackground(Color.BLUE);
                break;
            case "Yellow":
                container.setBackground(Color.YELLOW);
                break;
            case "Pink":
                container.setBackground(Color.PINK);
                break;
            default:
                container.setBackground(null);
        }
    }

    public static void main(String[] args) {
        new ColorChangerFrame();
    }
}
