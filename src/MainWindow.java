import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {

    JButton addButton;

    static String[] searchCategories = {
            "Registration number",
            "Brand",
            "Model",
            "Insurance date",
            "Date of registration"
    };

    public MainWindow() {
        setTitle("Home page");
        setSize(700, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JLabel title = new JLabel("Ilia's Garage");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);

        JLabel searchLabel = new JLabel("Search by:");
        JComboBox<String> selectSearch = new JComboBox<>(searchCategories);
        JPanel boxPanel = new JPanel(new GridLayout(2, 1, 4, 4));
        boxPanel.add(searchLabel);
        boxPanel.add(selectSearch);

        addButton = new JButton("Add car");
        addButton.addActionListener(this);
        JButton showButton = new JButton("Show cars");
        JPanel sectionPanelButtons = new JPanel(new GridLayout(2, 1, 50, 50));
        sectionPanelButtons.add(addButton);
        sectionPanelButtons.add(showButton);

        JPanel sectionPanel = new JPanel(new BorderLayout());
        sectionPanel.add(boxPanel, BorderLayout.NORTH);
        sectionPanel.add(sectionPanelButtons, BorderLayout.SOUTH);

        sectionPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0)); // top, left, bottom, right

        JLabel text = new JLabel("Hello! Please select a car from a garage.");
        text.setFont(new Font("Arial", Font.PLAIN, 20));
        JPanel textPanel = new JPanel();
        textPanel.add(text);

        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(sectionPanel, BorderLayout.WEST);
        mainPanel.add(textPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            dispose();
            new AddCarWindow();
        }
    }
}
