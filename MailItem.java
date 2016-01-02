
/**
 * Write a description of class MailItem here.
 * Representa a un email
 * VACACIONES, VACACIONES.
 */
public class MailItem
{
    // At. para guardar el remitente del email.
    private String from;
    //At para guardar la dirección del destinatario.
    private String to;
    //At para guardar el asunto del mensaje.
    private String subject;
    //At para guardar el mensaje.
    private String message;

    /**
     * Constructor for objects of class MailItem
     */
    public MailItem(String from, String to, String subject, String message)
    {
        this.from  = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }
    
    /**
     * Serie de mt. getters para retornar el valor de los atributos.
     */
   
    public String getFrom(){
        return from;
    }
    public String getTo(){
        return to;
    } 
    public String getSubject(){
        return subject;
    }
    public String getMessage(){
        return message;
    }
    
    /**
     * Muestra por pantalla los atributos.
     */
    public void print(){
        System.out.println("De: "      +from);
        System.out.println("Para: "    +to);
        System.out.println("Asunto: "  +subject);
        System.out.println("Mensaje: " +message);
    }
    
}





















