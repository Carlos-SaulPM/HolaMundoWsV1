package fes.carlos.holamundowsv1.services;

public interface ApiCallback <T> {

    void onSuccess(T data);
    void onError(String error);
}
