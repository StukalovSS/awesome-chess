package ru.chessTeam.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ChessServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
