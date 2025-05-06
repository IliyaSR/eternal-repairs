import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AvailableCarsWindow extends JFrame {

    String[][] dataCarsTable = new String[Main.cars.size()][5];

    AvailableCarsWindow() {
        setTitle("Available cars");
        setSize(1000, 960);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel windowPanel = new JPanel(new BorderLayout());

        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Available cars");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(title);

        for (int i = 0; i < Main.cars.size(); i++) {
            Car car = Main.cars.get(i);
            dataCarsTable[i][0] = String.valueOf(i + 1);
            dataCarsTable[i][1] = car.brand;
            dataCarsTable[i][2] = car.model;
            dataCarsTable[i][3] = String.valueOf(car.horsePower);
            dataCarsTable[i][4] = car.registrationNumber;
        }

        String[] columnNames = {"ID", "Brand", "Model", "Horse power", "Registration number"};

        JTable table = new JTable(dataCarsTable, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(scrollPane);

        windowPanel.add(titlePanel, BorderLayout.NORTH);
        windowPanel.add(panel, BorderLayout.CENTER);

        add(windowPanel);
        setVisible(true);
    }
}
