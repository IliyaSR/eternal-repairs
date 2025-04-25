import java.time.LocalDate;

class Car extends Vehicle {
    enum GearBoxType {
        AUTOMATIC,
        MANUAL
    }

    enum TypeFuel {
        DIESEL,
        PETROL
    }

    final LocalDate nowDate = LocalDate.now();
    final LocalDate negativeYear = LocalDate.parse("0000-00-00");

    float fuelConsumption;
    int tankCapacity;
    TypeFuel typeFuel;
    int horsePower;
    GearBoxType gearBoxType;
    LocalDate dateOfCreation;
    private LocalDate dateOfRegistration;
    private LocalDate insuranceDate;
    private LocalDate dateOfReview;
    LocalDate dateOfChangeTires;
    int kilometersEngineOil;

    Car(String species, String registrationNumber, String brand, String model, float fuelConsumption,
        int tankCapacity, TypeFuel typeFuel, int horsePower, GearBoxType gearBoxType, LocalDate dateOfCreation,
        LocalDate dateOfRegistration, LocalDate insuranceDate, LocalDate dateOfReview,
        LocalDate dateOfChangeTires, int kilometersEngineOil) {
        super(species, registrationNumber, brand, model);
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
        this.typeFuel = typeFuel;
        this.horsePower = horsePower;
        this.gearBoxType = gearBoxType;
        this.dateOfCreation = dateOfCreation;
        this.dateOfRegistration = dateOfRegistration;
        this.insuranceDate = insuranceDate;
        this.dateOfReview = dateOfReview;
        this.dateOfChangeTires = dateOfChangeTires;
        this.kilometersEngineOil = kilometersEngineOil;
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setInsuranceDate(LocalDate insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public LocalDate getInsuranceDate() {
        return insuranceDate;
    }

    public void setDateOfReview(LocalDate dateOfReview) {
        this.dateOfReview = dateOfReview;
    }

    public LocalDate getDateOfReview() {
        return dateOfReview;
    }

    public boolean validateSpecies(String species) {
        if (species.length() > 100) {
            System.out.println("Species can't be longer than 100 chars!");
            return false;
        }
        if (species.isBlank()) {
            System.out.println("Species can't be empty!");
            return false;
        }
        return true;
    }

    public boolean validateRegistrationNumber(String registrationNumber) {
        if (registrationNumber.length() > 10) {
            System.out.println("Registration number can't be longer than 10 chars!");
            return false;
        }
        if (registrationNumber.isBlank()) {
            System.out.println("Registration number can't be empty!");
            return false;
        }
        return true;
    }

    public boolean validateBrand(String brand) {
        if (brand.length() > 20) {
            System.out.println("Brand can't be longer than 20 chars!");
            return false;
        }
        if (brand.isBlank()) {
            System.out.println("Brand can't be empty!");
            return false;
        }
        return true;
    }

    public boolean validateModel(String model) {
        if (model.length() > 20) {
            System.out.println("Model can't be longer than 20 chars!");
            return false;
        }
        if (model.isBlank()) {
            System.out.println("Model can't be empty!");
            return false;
        }
        return true;
    }

    public boolean validateFuelConsumption(float FuelConsumption) {
        if (fuelConsumption <= 0) {
            System.out.println("The fuel consumption can't be lower than 1!");
            return false;
        }
        return true;
    }

    public boolean validateTankCapacity(int tankCapacity) {
        if (tankCapacity <= 0) {
            System.out.println("The tank capacity can't be lower than 1!");
            return false;
        }
        return true;
    }

    public boolean validateHorsePower(int horsePower){
        if(horsePower < 0){
            System.out.println("The horse power can't be negative number!");
            return false;
        }
        return true;
    }

    public boolean validateDates(LocalDate allDates){
        if(nowDate.isBefore(allDates)){
            System.out.println("Date can't be in the future!");
            return false;
        }
        if(allDates.isBefore(negativeYear)){
            System.out.println("Date can't be negative!");
            return false;
        }
        return true;
    }

    public boolean validateDateOfChangeTires(LocalDate dateOfChangeTires){
        if(dateOfChangeTires.isBefore(nowDate)){
            System.out.println("The date can't be in the past!");
            return false;
        }
        return true;
    }

    public boolean validateChangeOilKilometers(int kilometersChangeOil){
        if(kilometersChangeOil < 0){
            System.out.println("The kilometers can't be negative number!");
            return false;
        }
        return true;
    }





}