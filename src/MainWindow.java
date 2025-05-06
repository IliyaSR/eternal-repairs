import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JFrame implements ActionListener {

    static List<Car> foundCars = new ArrayList<>();

    JButton addButton;
    JButton searchButton;
    JComboBox<String> selectSearch;
    JTextField searchField;
    JLabel errorLabel;
    JButton showButton;

    static String[] searchCategories = {
            "Registration number",
            "Brand",
            "Model",
            "Insurance date",
            "Date of registration"
    };

    public MainWindow() {
        setTitle("Home page");
        setSize(700, 950);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JLabel title = new JLabel("Ilia's Garage");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);

        JPanel boxPanel = new JPanel(new GridLayout(5, 1, 13, 13));
        JLabel searchLabel = new JLabel("Search by:");
        selectSearch = new JComboBox<>(searchCategories);
        searchField = new JTextField();
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        errorLabel = new JLabel();
        boxPanel.add(searchLabel);
        boxPanel.add(selectSearch);
        boxPanel.add(searchField);
        boxPanel.add(searchButton);
        boxPanel.add(errorLabel);

        addButton = new JButton("Add car");
        addButton.addActionListener(this);
        showButton = new JButton("Show cars");
        showButton.addActionListener(this);
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

        if (e.getSource() == searchButton) {
            boolean foundCar = false;
            String searchingParameter = (String) selectSearch.getSelectedItem();
            String textBySearchingField = searchField.getText();

            for (Car car : Main.cars) {
                switch (searchingParameter) {
                    case "Registration number":
                        if (car.registrationNumber.contains(textBySearchingField)) {
                            foundCars.add(car);
                            foundCar = true;
                            break;
                        }
                    case "Brand":
                        if (car.brand.contains(textBySearchingField)) {
                            foundCars.add(car);
                            foundCar = true;
                            break;
                        }
                    case "Model":
                        if (car.model.contains(textBySearchingField)) {
                            foundCars.add(car);
                            foundCar = true;
                            break;
                        }
                    case "Insurance date":
                        if (car.getInsuranceDate().isEqual(LocalDate.parse(textBySearchingField))) {
                            foundCars.add(car);
                            foundCar = true;
                            break;
                        }
                    case "Date of registration":
                        if (car.getDateOfRegistration().isEqual(LocalDate.parse(textBySearchingField))) {
                            foundCars.add(car);
                            foundCar = true;
                            break;
                        }
                }
            }

            if(!foundCar){
                errorLabel.setForeground(Color.red);
                errorLabel.setText("Not found");
            }else{
                dispose();
                new CarDetailsWindow();
            }
        }

        if(e.getSource() == showButton){
            new AvailableCarsWindow();
        }
    }
}
