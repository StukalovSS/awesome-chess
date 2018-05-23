package ru.chessTeam.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.chessTeam.client.ChessService;

public class ChessAppServiceImpl extends RemoteServiceServlet implements ChessService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}