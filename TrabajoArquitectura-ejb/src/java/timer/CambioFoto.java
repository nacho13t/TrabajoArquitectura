
package timer;


import javax.ejb.Stateless;
import javax.ejb.LocalBean;


@Stateless
@LocalBean
public class CambioFoto {
    public static String[] titulos = {"foto1.jpg","foto2.jpg","foto3.jpg","foto4.jpg","foto5.jpg","foto6.jpg"};
    public static String actual = titulos[0];
    public static int i = 0;
    static void cambiar() {
        if(i==5){
            i=0;
        }else{
            i++;
        }
        actual = titulos[i];
    }
}
