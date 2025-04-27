import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

public class AddCarWindow extends JFrame implements ActionListener {

    String[] typeFuel = {"DIESEL", "PETROL"};

    JButton submitButton;

    JComboBox<String> typeFuelBox = new JComboBox<>(typeFuel);

    JTextField registrationField = new JTextField();
    JTextField speciesField = new JTextField();
    JTextField brandField = new JTextField();
    JTextField modelField = new JTextField();
    JTextField tankCapacityField = new JTextField();
    JTextField fuelConsumptionField = new JTextField();
    JTextField horsePowerField = new JTextField();
    JTextField gearBoxField = new JTextField();
    JTextField dateOfCreationField = new JTextField();
    JTextField dateOfRegistrationField = new JTextField();
    JTextField insuranceDateField = new JTextField();
    JTextField dateOfReviewField = new JTextField();
    JTextField dateOfChangeTiresField = new JTextField();
    JTextField kilometersField = new JTextField();


    JLabel registrationErrorLabel = new JLabel();
    JLabel speciesErrorLabel = new JLabel();
    JLabel brandErrorLabel = new JLabel();
    JLabel modelErrorLabel = new JLabel();
    JLabel fuelConsumptionErrorLabel = new JLabel();
    JLabel tankCapacityErrorLabel = new JLabel();
    JLabel typeFuelErrorLabel = new JLabel();
    JLabel horsePowerErrorLabel = new JLabel();
    JLabel gearBoxErrorLabel = new JLabel();
    JLabel dateOfCreationErrorLabel = new JLabel();
    JLabel dateOfRegistrationErrorLabel = new JLabel();
    JLabel insuranceDateErrorLabel = new JLabel();
    JLabel dateOfReviewErrorLabel = new JLabel();
    JLabel dateOfChangeTiresErrorLabel = new JLabel();
    JLabel kilometersEngineOilErrorLabel = new JLabel();

    AddCarWindow() {

        setTitle("Add car");
        setSize(700, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Ilia's Garage");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(title);

        JPanel addCarPanel = new JPanel();

        JPanel vehicleDetailsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        vehicleDetailsPanel.add(createPanel("Registration number", registrationField, registrationErrorLabel));
        vehicleDetailsPanel.add(createPanel("Species", speciesField, speciesErrorLabel));
        vehicleDetailsPanel.add(createPanel("Brand", brandField, brandErrorLabel));
        vehicleDetailsPanel.add(createPanel("Model", modelField, fuelConsumptionErrorLabel));
        vehicleDetailsPanel.add(createPanel("Tank capacity", tankCapacityField, tankCapacityErrorLabel));
        vehicleDetailsPanel.add(createPanel("Type fuel", typeFuelBox, typeFuelErrorLabel));
        vehicleDetailsPanel.add(createPanel("Fuel consumption", fuelConsumptionField, fuelConsumptionErrorLabel));
        vehicleDetailsPanel.add(createPanel("Horse power", horsePowerField, horsePowerErrorLabel));
        vehicleDetailsPanel.add(createPanel("Gear Box", gearBoxField, gearBoxErrorLabel));
        vehicleDetailsPanel.add(createPanel("Date of creation", dateOfCreationField, dateOfCreationErrorLabel));
        vehicleDetailsPanel.add(createPanel("Date of registration", dateOfRegistrationField, dateOfRegistrationErrorLabel));
        vehicleDetailsPanel.add(createPanel("Insurance date", insuranceDateField, insuranceDateErrorLabel));
        vehicleDetailsPanel.add(createPanel("Date of review", dateOfReviewField, dateOfReviewErrorLabel));
        vehicleDetailsPanel.add(createPanel("Date of change tires", dateOfChangeTiresField, dateOfChangeTiresErrorLabel));
        vehicleDetailsPanel.add(createPanel("Kilometers engine oil", kilometersField, kilometersEngineOilErrorLabel));

        addCarPanel.add(submitButton);

        vehicleDetailsPanel.setPreferredSize(new Dimension(400, 650));
        addCarPanel.add(vehicleDetailsPanel);


        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(createSelectPanel(), BorderLayout.WEST);
        mainPanel.add(addCarPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    public JPanel createSelectPanel() {
        JPanel selectPanel = new JPanel(new BorderLayout());

        JPanel boxPanel = new JPanel(new GridLayout(2, 1, 4, 4));
        JLabel searchLabel = new JLabel("Search by:");
        JComboBox<String> selectSearch = new JComboBox<>(MainWindow.searchCategories);
        boxPanel.add(searchLabel);
        boxPanel.add(selectSearch);

        JPanel selectPanelButtons = new JPanel(new GridLayout(4, 1, 50, 50));
        JButton addButton = new JButton("Add car");
        JButton deleteButton = new JButton("Delete car");
        JButton updateButton = new JButton("Update car");
        JButton showButton = new JButton("Show cars");
        selectPanelButtons.add(addButton);
        selectPanelButtons.add(deleteButton);
        selectPanelButtons.add(updateButton);
        selectPanelButtons.add(showButton);

        selectPanel.add(boxPanel, BorderLayout.NORTH);
        selectPanel.add(selectPanelButtons, BorderLayout.SOUTH);

        selectPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));

        return selectPanel;
    }

    public JPanel createPanel(String labelText, JTextField field, JLabel anyLabel) {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        JLabel label = new JLabel(labelText);
        field.setPreferredSize(new Dimension(140, 25));
        panel.add(label);
        panel.add(field);
        panel.add(anyLabel);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String registrationNumber = validateAndGet(registrationField, Car::validateRegistrationNumber, registrationErrorLabel);
            String species = validateAndGet(speciesField, Car::validateSpecies, speciesErrorLabel);
            String brand = validateAndGet(brandField, Car::validateBrand, brandErrorLabel);
            String model = validateAndGet(modelField, Car::validateModel, modelErrorLabel);
            float fuelConsumption = validateAndGetInt(fuelConsumptionField, Car::validateFuelConsumption, fuelConsumptionErrorLabel);
            int tankCapacity = validateAndGetInt(tankCapacityField, Car::validateTankCapacity, tankCapacityErrorLabel);
        }
    }

    private String validateAndGet(JTextField field, Function<String, Boolean> validator, JLabel label) {
        String text = field.getText();
        label.setForeground(Color.red);
        if (!validator.apply(text)) {
            label.setText("Error");
            return null;
        }
        label.setText("");
        return text;
    }

    private int validateAndGetInt(JTextField field, Function<Integer, Boolean> validator, JLabel label) {
        String text = field.getText();
        label.setForeground(Color.red);
        if (!text.isBlank()) {
            int value = Integer.parseInt(text);
            if (!validator.apply(value)) {
                label.setText("Error");
                return 0;
            }
            label.setText("");
            return value;
        } else {
            label.setText("Error");
            return 0;
        }
    }
}
