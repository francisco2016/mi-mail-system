
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
    //At para almacenar el último email recibido.
    private MailItem lastMail;
    //At para ayudar a comprobar si el mensaje contiene spam.
    private boolean spam;
    //At para guardar los mensajes enviados.
    private int enviados;
    //At para guardar los mensajes recibidos.
    private int recibidos;
    //At para guardar los mensajes con spam.
    private int conSpam;
    //At para guardar la dirección de correo del mensaje mas largo.
    private String mensajeLargo;
    //At para almacenar el nº de caracteres del mensaje.
    private int numDeCaracteres;
    //At para guardar el último mensaje con spam.
    private MailItem menConSpam;

    /**
     * Crea un objeto MailClient a partir de los valores dados
     */
    public MailClient(MailServer server, String user)
    {   
        this.server = server;
        this.user = user;
        lastMail = null;
        spam = false;
        enviados = 0;
        recibidos = 0;
        conSpam = 0;
        mensajeLargo = "";
        numDeCaracteres = 0;
        menConSpam = null;
    }

    /**
     * Recupera del servidor el siguiente email destinado
     * al usuario que esta usando el cliente. Si no hay 
     * ningun email pendiente de ser descargado devuelve null; si
     * lo hay, devuelve el email
     */
    public MailItem getNextMailItem()
    {
        MailItem email = server.getNextMailItem(user);
        if (email != null)
        {
            if(email.getMessage().contains("trabajo")){
                spam = false;
                lastMail = email;
            }

            else if(email.getMessage().contains("regalo") || email.getMessage().contains("promocion") ){
                spam = true;
                // email = null;
                conSpam++; 
                menConSpam = email;
            }
            //Condiciconal para controlar el mensaje más largo, y saber el nº de caracteres que tiene.
            if(spam == false && email.getMessage().length() > numDeCaracteres){
                numDeCaracteres = email.getMessage().length(); //cuenta el nº de caracteres.
                mensajeLargo = email.getFrom(); //guarda la dirección del msj. más largo.
            }
            lastMail = email;
            recibidos++;
        }
        return email;
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
            if(spam == false){
                //Imprimimos los detalles del email
                email.print();
                lastMail = email;
            }
            else if(email.getMessage().contains("regalo") || email.getMessage().contains("promocion") ){
                System.out.println("Ha recibido un spam en su servidor de correo.");
            }
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
        enviados++;
    }

    /**
     * Mt para conocer el nº de correos que tenemos en el servidor.
     */
    public void mailsEnServidor(){
        int cantidad = server.howManyMailItems(user);

        System.out.println("tienes: " +cantidad+ " correos sin abrir. ");

    }

    /**
     * Mt para responder automáticamente cuado recibimos un correo, y no estamos
     *  con el ordenador en ese momento, para poder responder.
     */
    public void getNextMailItemAndSendAutomaticRespond(){
        MailItem email = getNextMailItem();
        if(email != null && spam == false){
            // sendMailItem(email.getFrom()," \n Estoy en Japón.\n " + email.getMessage(), " RE " +email.getSubject()) ;
            sendMailItem(email.getFrom(), email.getSubject()," RE \n Estoy en Japón.\n " + email.getMessage() ) ;
        }

    }

    /**
     * Mt para almacenar el último mensaje recibido.
     */
    public void ultimoMensaje(){
        if(lastMail != null){
            lastMail.print();
        }
        else{System.out.println("No tenemos mensajes nuevos.");}
    }

    /**
     * Mt para mostrar las estadisticas relacionadas con los mensajes.
     */
    public void porcentajes(){
        float a = recibidos;
        float b = conSpam;
        float porcentaje = (b / a) * 100;
        System.out.println("Mensajes recibidos:           " +recibidos);
        System.out.println("Mensajes enviados:            " +enviados);
        System.out.println("Mensajes con spam:            " +conSpam);
        System.out.println("Porcentaje de spam recibidos: " +porcentaje+ " %.");
        System.out.println("El mensaje más largo \nlo ha escrito\n " +mensajeLargo+ " tiene " +numDeCaracteres+ " caracteres.");

    }

    /**
     * Mt para mostrar por pantalla el último msj recibido com spam.
     */
    public void showSpam(){
        if(spam == true){
            menConSpam.print();
        }
        else{
            System.out.println("No tiene mensajes con spam.");
        }
    }

    /**
     * Mt. para transmitir ms. con error.
     */
    public void sendMailItemWithTransmissionError(String to, String subject, String message){
        
        if(message.contains("o")){
            message = message.replace("o", "#o");
        }
        if(message.contains("i")){
            message = message.replace("i", "$i");
        }
        if(message.contains("O")){
            message = message.replace("O", "#O");
        }
        if(message.contains("I")){
            message = message.replace("I", "$I");
        }
        MailItem email = new MailItem(user, to, subject, message);
        server.post(email);
        
    }  
}






