
/**
 *VACACIONES, VACACIONES, VACACIONES.
 *31 / 12 / 2015
 */
public class MaliClient
{
    // At para guardar el servidor que tiene este cliente.
    private MailServer server;
    //At para guardar la dirección del correo que usa este cliente.
    private String user;

    /**
     * Constructor for objects of class MaliClient
     */
    public MaliClient(MailServer server, String user)
    {
        server = new MailServer();
        this.server = server;
        this.user = user;
    }
    
    /**
     * Mt para recuperar del servidor el siguiente mensaje.
     */
    public MailServer getNextMailItem(){
        return getNextMailItem();
        
    }
    
    
    
}






















