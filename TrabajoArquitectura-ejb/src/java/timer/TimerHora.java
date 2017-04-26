
package timer;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

@Singleton
@LocalBean
public class TimerHora {
    @EJB
    MuestraHora mh;
    
    @Schedule(second="*/1", minute="*",hour="*", persistent=false)
    public void myTimer() {
        MuestraHora.mostrarHora();
    }
    
    @Schedule(second="*/10", minute="*",hour="*", persistent=false)
    public void cambioFoto() {
        CambioFoto.cambiar();
    }

}
