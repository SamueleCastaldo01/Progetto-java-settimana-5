package samuelecastaldo.Progetto_java_settimana_5.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class UsernameEsistenteException extends RuntimeException {
    public UsernameEsistenteException(String message) {
        super(message);
    }
}
