package ru.chessTeam.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ChessService")
public interface ChessService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use ChessService.App.getInstance() to access static instance of MySampleApplicationServiceAsync
     */
    public static class App {
        private static ChessServiceAsync ourInstance = GWT.create(ChessService.class);

        public static synchronized ChessServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
