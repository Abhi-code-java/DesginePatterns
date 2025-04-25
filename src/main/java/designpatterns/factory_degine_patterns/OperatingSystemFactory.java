package designpatterns.factory_degine_patterns;

public class OperatingSystemFactory {
    private OperatingSystemFactory() {
    }

    public static OperatingSystem getInstance( String type,String value, String arvhetecture){
        switch (type){
            case "WINDOWS":
                return new WindowsOperatingSystem(value,arvhetecture);
            case "LINUX":
                return new LinuxOperatingSystem(value,arvhetecture);
            default:
                throw new IllegalArgumentException("no SYSTEM FOUND ");
        }
    }
}
