package be.pxl.ja.streamingservice.repository;

import be.pxl.ja.streamingservice.model.Account;
import be.pxl.ja.streamingservice.model.DuplicateEmailException;

import java.util.HashMap;


public class AccountRepository {
    private HashMap<String, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        if (accounts.containsKey(account.getEmail())){
            throw new DuplicateEmailException();
        }
        accounts.put(account.getEmail(),account);

    }

    public Account findAccount(String email) {
        if (accounts.get(email) == null){
            return null;
        }else{
            return accounts.get(email);
        }
    }
}
