import junit.framework.*;
import org.univ.salles.modele.repository.*;

import static org.univ.salles.modele.repository.AbstractRepository.configureSessionFactory;

public class RepositoryTypeSalleTest extends TestCase{

    RepositoryTypeSalle repository = new RepositoryTypeSalle();

    public void testGetBatiments() throws Exception {
        configureSessionFactory();
        assertNotNull(repository.getTypesSalle());
    }
}
