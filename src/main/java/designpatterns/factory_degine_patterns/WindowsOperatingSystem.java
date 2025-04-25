package designpatterns.factory_degine_patterns;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WindowsOperatingSystem extends OperatingSystem{
    private String version;
    private String archetect;

    public WindowsOperatingSystem(String version, String archetect) {
        this.version = version;
        this.archetect = archetect;
    }

    @Override
    public void createDir(String value, String removeDir) {
        super.createDir(value, removeDir);
    }

    @Override
    public void removeDir(String value, String removeDir) {
        super.removeDir(value, removeDir);
    }
}
