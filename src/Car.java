import java.time.LocalDate;

class Car extends Vehicle {
    enum GearBoxType {
        AUTOMATIC,
        MANUAL
    }

    float fuelConsumption;
    int tankCapacity;
    int typeFuel;
    int horsePower;
    GearBoxType gearBoxType;
    LocalDate dateOfCreation;
    private LocalDate dateOfRegistration;
    private LocalDate insuranceDate;
    private LocalDate dateOfReview;
    LocalDate dateOfChangeTires;
    int kilometersEngineOil;

    Car(String species, String registrationNumber, String brand, String model, float fuelConsumption,
        int tankCapacity, int typeFuel, int horsePower, GearBoxType gearBoxType, LocalDate dateOfCreation,
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


}