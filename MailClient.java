
/**
 * Write a description of class MailItem here.
 * Representa a un cliente del servidor de correos
 * VACACIONES, VACACIONES.
 */
public class MailClient
{
    //El servidor al que esta conectado este cliente
    private MailServer server;
    //La direccion del usuario que esta usando este cliente
    private String user;

    /**
     * Crea un objeto MailClient a partir de los valores dados
     */
    public MailClient(MailServer server, String user)
    {   
        this.server = server;
        this.user = user;
    }

    /**
     * Recupera del servidor el siguiente email destinado
     * al usuario que esta usando el cliente. Si no hay 
     * ningun email pendiente de ser descargado devuelve null; si
     * lo hay, devuelve el email
     */
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }
    
    
    /**
     * Recupera del servidor el siguiente email destinado al
     * usuario que esta usando el cliente e imprime sus datos
     * por pantalla. Si no hay ningun email imprime por pantalla
     * un mensaje advirtiendo de ello
     */
    public void printNextMailItem()
    {
        MailItem email = getNextMailItem();
        if (email != null)
        {
            //Imprimimos los detalles del email
            email.print();
        }
        else 
        {
            //Avisamos de que no hay emails en el servidor
            System.out.println("No hay correo nuevo");  
        }
    }

    /**
     * Permite redactar un email indicando el destinatario y el
     * cuerpo del mensaje y enviarlo al servidor
     */
    public void sendMailItem(String to, String subject, String message)
    {
        MailItem email = new MailItem(user, to, subject, message);
        server.post(email);
    }
    
    /**
     * Mt para conocer el nº de correos que tenemos en el servidor.
     */
    public void mailsEnServidor(){
        int cantidad = server.howManyMailItems(user);
       System.out.println("tienes: " +cantidad+ " correos sin abrir. ");
    }
}















