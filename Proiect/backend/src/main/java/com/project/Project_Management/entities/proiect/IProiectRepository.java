import java.util.List;
import java.util.Optional;

public interface IProiectRepository<Proiect, ID> {

    public Optional<Proiect> findById(ID ProiectId);

    public List<Proiect> getAll();

    public void insert(Proiect proiect);

    public void update(Proiect proiect);

    public void delete(ID proiectId);

}