package projectjobs.app.com.br.util;

public class InternetExcpecion extends Exception {

    private static final long serialVersionUID = 1149241039409861914L;

    public InternetExcpecion(String msg){
        super(msg);
    }

    public InternetExcpecion(String msg, Throwable cause){
        super(msg, cause);
    }

}
