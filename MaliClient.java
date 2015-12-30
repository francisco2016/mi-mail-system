
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
    public MailItem getNextMailItem(){
        return server.getNextMailItem(user);
        
    }
    
    /**
     * Mt para imprimir por pantalla los correos recibidos en el servidor.
     */
    public void printNextMailItem(){
        if(getNextMailItem() != null){
            System.out.println(getNextMailItem()); 
        }
        else{System.out.println("No tiene mensajes nuevos.");}
    }
    
    /**
     * Mt para crear mensajes indicando el destinatario  y el cuerpo
     *  del mensaje, y enviarles a un servidor.
     */
    public void senMailItem(String para, String mensaje){
        MailItem email = new MailItem(user, para, mensaje);
        server.post(email);
    }
        
    }
    
    
    
    
    
    
    
    
    
 






















