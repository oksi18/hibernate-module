package models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // забув додати cascade
    private List<Car> cars = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "drive_license_id", referencedColumnName = "id")
    private DriveLicense driveLicense;

    public Owner(String name, DriveLicense driveLicense) {
        this.name = name;
        this.driveLicense = driveLicense;
    }
}