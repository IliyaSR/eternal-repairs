import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarDetailsWindow extends JFrame implements ActionListener {

    JTextField species;
    JTextField registrationNumber;
    JTextField brand;
    JTextField model;
    JTextField fuelConsumption;
    JTextField tankCapacity;
    JTextField typeFuel;
    JTextField horsePower;
    JTextField gearBoxType;
    JTextField dateOfCreation;
    JTextField dateOfRegistration;
    JTextField insuranceDate;
    JTextField dateOfReview;
    JTextField dateOfChangeTires;
    JTextField kilometersChangeOil;

    static JButton deleteButton;
    static JButton updateButton;

    public CarDetailsWindow() {
        setTitle("Car Details");
        setSize(700, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Ilia's Garage");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(title);

        JPanel carDetails = new JPanel();

        JPanel carDetailsFields = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
        carDetailsFields.setPreferredSize(new Dimension(400, 850));

        if (!MainWindow.foundCars.isEmpty()) {
            species = new JTextField();
            species.setText(MainWindow.foundCars.getFirst().species);
            registrationNumber = new JTextField();
            registrationNumber.setText(MainWindow.foundCars.getFirst().registrationNumber);
            brand = new JTextField();
            brand.setText(MainWindow.foundCars.getFirst().brand);
            model = new JTextField();
            model.setText(MainWindow.foundCars.getFirst().model);
            fuelConsumption = new JTextField();
            fuelConsumption.setText(String.valueOf(MainWindow.foundCars.getFirst().fuelConsumption));
            tankCapacity = new JTextField();
            tankCapacity.setText(String.valueOf(MainWindow.foundCars.getFirst().tankCapacity));
            typeFuel = new JTextField();
            typeFuel.setText(String.valueOf(MainWindow.foundCars.getFirst().typeFuel.ordinal()));
            horsePower = new JTextField();
            horsePower.setText(String.valueOf(MainWindow.foundCars.getFirst().horsePower));
            gearBoxType = new JTextField();
            gearBoxType.setText(String.valueOf(MainWindow.foundCars.getFirst().gearBoxType.ordinal()));
            dateOfCreation = new JTextField();
            dateOfCreation.setText(String.valueOf(MainWindow.foundCars.getFirst().dateOfCreation));
            dateOfRegistration = new JTextField();
            dateOfRegistration.setText(String.valueOf(MainWindow.foundCars.getFirst().dateOfRegistration));
            insuranceDate = new JTextField();
            insuranceDate.setText(String.valueOf(MainWindow.foundCars.getFirst().insuranceDate));
            dateOfReview = new JTextField();
            dateOfReview.setText(String.valueOf(MainWindow.foundCars.getFirst().getDateOfReview()));
            dateOfChangeTires = new JTextField();
            dateOfChangeTires.setText(String.valueOf(MainWindow.foundCars.getFirst().dateOfChangeTires));
            kilometersChangeOil = new JTextField();
            kilometersChangeOil.setText(String.valueOf(MainWindow.foundCars.getFirst().kilometersEngineOil));

            species.setPreferredSize(new Dimension(140, 25));
            registrationNumber.setPreferredSize(new Dimension(140, 25));
            brand.setPreferredSize(new Dimension(140, 25));
            model.setPreferredSize(new Dimension(140, 25));
            fuelConsumption.setPreferredSize(new Dimension(140, 25));
            tankCapacity.setPreferredSize(new Dimension(140, 25));
            typeFuel.setPreferredSize(new Dimension(140, 25));
            horsePower.setPreferredSize(new Dimension(140, 25));
            gearBoxType.setPreferredSize(new Dimension(140, 25));
            dateOfCreation.setPreferredSize(new Dimension(140, 25));
            dateOfRegistration.setPreferredSize(new Dimension(140, 25));
            insuranceDate.setPreferredSize(new Dimension(140, 25));
            dateOfReview.setPreferredSize(new Dimension(140, 25));
            dateOfChangeTires.setPreferredSize(new Dimension(140, 25));
            kilometersChangeOil.setPreferredSize(new Dimension(140, 25));

            makeNotEditableFields(species);
            makeNotEditableFields(registrationNumber);
            makeNotEditableFields(brand);
            makeNotEditableFields(model);
            makeNotEditableFields(species);
            makeNotEditableFields(fuelConsumption);
            makeNotEditableFields(tankCapacity);
            makeNotEditableFields(typeFuel);
            makeNotEditableFields(horsePower);
            makeNotEditableFields(gearBoxType);
            makeNotEditableFields(dateOfCreation);
            makeNotEditableFields(dateOfRegistration);
            makeNotEditableFields(insuranceDate);
            makeNotEditableFields(dateOfReview);
            makeNotEditableFields(dateOfChangeTires);
            makeNotEditableFields(kilometersChangeOil);

            carDetailsFields.add(species);
            carDetailsFields.add(registrationNumber);
            carDetailsFields.add(brand);
            carDetailsFields.add(model);
            carDetailsFields.add(fuelConsumption);
            carDetailsFields.add(tankCapacity);
            carDetailsFields.add(typeFuel);
            carDetailsFields.add(horsePower);
            carDetailsFields.add(gearBoxType);
            carDetailsFields.add(dateOfCreation);
            carDetailsFields.add(dateOfRegistration);
            carDetailsFields.add(insuranceDate);
            carDetailsFields.add(dateOfReview);
            carDetailsFields.add(dateOfChangeTires);
            carDetailsFields.add(kilometersChangeOil);

            carDetails.add(carDetailsFields);
        }


        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(createSelectPanel(), BorderLayout.WEST);
        mainPanel.add(carDetails, BorderLayout.CENTER);

        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);

        add(mainPanel);
        setVisible(true);
    }

    public void makeNotEditableFields(JTextField field) {
        field.setEditable(false);
        field.setFocusable(false);
        field.setBackground(Color.white);
    }

    static public JPanel createSelectPanel() {
        JPanel selectPanel = new JPanel(new BorderLayout());

        JPanel boxPanel = new JPanel(new GridLayout(2, 1, 4, 4));
        JLabel searchLabel = new JLabel("Search by:");
        JComboBox<String> selectSearch = new JComboBox<>(MainWindow.searchCategories);
        boxPanel.add(searchLabel);
        boxPanel.add(selectSearch);

        JPanel selectPanelButtons = new JPanel(new GridLayout(4, 1, 50, 50));
        deleteButton = new JButton("Delete car");
        updateButton = new JButton("Update car");
        selectPanelButtons.add(deleteButton);
        selectPanelButtons.add(updateButton);

        selectPanel.add(boxPanel, BorderLayout.NORTH);
        selectPanel.add(selectPanelButtons, BorderLayout.SOUTH);

        selectPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));

        return selectPanel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton) {
            Main.cars.clear();
            dispose();
            new MainWindow();
        }

        if(e.getSource() == updateButton){
            dispose();
            new UpdateCarWindow();
        }
    }
}
