package models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
public class DriveLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String series;

    @OneToOne(mappedBy = "driveLicense", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Owner owner;

    public DriveLicense(String series) {
        this.series = series;
    }
}
