public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
         PowerControl pjPower = reg.getDevice(Projector.class);
        InputConnectable pjInput = (InputConnectable) pjPower;

        pjPower.powerOn();
        pjInput.connectInput("HDMI-1");

        BrightnessControl lights = reg.getDevice(LightsPanel.class);
        lights.setBrightness(60);

        TemperatureControl ac = reg.getDevice(AirConditioner.class);
        ac.setTemperatureC(24);

        AttendanceCapable scanner = reg.getDevice(AttendanceScanner.class);
        System.out.println("Attendance scanned: present=" + scanner.scanAttendance());
    
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        reg.getDevice(Projector.class).powerOff();
        reg.getDevice(LightsPanel.class).powerOff();
        reg.getDevice(AirConditioner.class).powerOff();
    }
}
