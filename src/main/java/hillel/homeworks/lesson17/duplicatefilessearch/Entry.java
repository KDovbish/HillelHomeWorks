package hillel.homeworks.lesson17.duplicatefilessearch;

import lombok.Getter;
import lombok.Setter;

/**
 * Сущность, которая описывает один файл
 */
@Setter
@Getter
public class Entry {
    private String name;
    private String absoluteName;
    private Long size;
    private Boolean isFolder;
    private Long crc;

    Entry(String name, String absoluteName, Long size, Boolean isFolder) {
        this.name = name;
        this.absoluteName = absoluteName;
        this.size = size;
        this.isFolder = isFolder;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "name='" + name + '\'' +
                ", absoluteName='" + absoluteName + '\'' +
                ", size=" + size +
                ", isFolder=" + isFolder +
                ", crc=" + crc +
                '}';
    }

}
