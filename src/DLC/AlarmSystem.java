package DLC;

// сигнализация
public class AlarmSystem implements Observer {
    private final RadiationSensor radiationSensor; // датчик радиации
    private final PressureSensor pressureSensor; // датчик давления
    private final PressureDifferenceSensor pressureDifferenceSensor; // датчик перепада давления

    // все датчики в конструкторе
    public AlarmSystem(RadiationSensor radiationSensor, PressureSensor pressureSensor, PressureDifferenceSensor pressureDifferenceSensor) {
        this.radiationSensor = radiationSensor;
        this.pressureSensor = pressureSensor;
        this.pressureDifferenceSensor = pressureDifferenceSensor;

        // уведомления от всех датчиков
        radiationSensor.addObserver(this);
        pressureSensor.addObserver(this);
        pressureDifferenceSensor.addObserver(this);
    }

    @Override
    public void update() {
        checkAlarm(); // проверяем все условия при каждом уведомлении
    }

    // условия аварийной сигнализации
    private void checkAlarm() {
        if (radiationSensor.getRadiationLevel() > 15) {
            System.out.println("Авария! Уровень радиации превышает норму!");
        }
        if (pressureSensor.getPressure() == 0 || pressureSensor.getPressure() > 120) {
            System.out.println("Авария! Давление находится вне допустимых пределов!");
        }
        if (pressureDifferenceSensor.getPressureDifference() > 50) {
            System.out.println("Авария! Перепад давления превышает норму!");
        }
    }
}
