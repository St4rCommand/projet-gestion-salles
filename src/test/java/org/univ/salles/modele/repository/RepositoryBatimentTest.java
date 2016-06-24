import junit.framework.*;
import org.univ.salles.modele.repository.*;

import static org.univ.salles.modele.repository.AbstractRepository.configureSessionFactory;

public class RepositoryBatimentTest extends TestCase{

    RepositoryBatiment repository = new RepositoryBatiment();

    public void testGetBatiments() throws Exception {
        configureSessionFactory();
        assertNotNull(repository.getBatiments());
    }
}
