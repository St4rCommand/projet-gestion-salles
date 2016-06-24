import junit.framework.*;
import org.univ.salles.modele.repository.*;
import org.univ.salles.modele.entite.*;

import static org.univ.salles.modele.repository.AbstractRepository.configureSessionFactory;

public class RepositorySalleTest extends TestCase{

    RepositorySalle repository = new RepositorySalle();

    public void testGetSalles() throws Exception {
        configureSessionFactory();
        assertNotNull(repository.getSalles());
    }

    public void testCreer() throws Exception {
        configureSessionFactory();

        Salle salle = repository.creer(new Batiment("BatimentTest"), new TypeSalle("Reception"), 1, 2, 50);

        assertEquals(1, salle.getNoSalle().intValue());
        assertEquals(2, salle.getNoEtage().intValue());
        assertEquals(50, salle.getSuperficie().intValue());
        assertTrue(salle.getBatiment().getNom().equals("BatimentTest"));
        assertTrue(salle.getType().getLibelle().equals("Reception"));

    }

/*    public void testExiste() throws Exception {


}*/
}
